package Main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Messages {
	private Plugin plugin = Main.getPlugin(Main.class);
	private ConfigGetter cg = new ConfigGetter();
	public void CreateMessage(String timeIn, String stay, String timeOut, String UpMessage, String kickMessage) {
		HashMap<String, String> message = new HashMap<String,String>();
		message.put("UpMessage", UpMessage);
		message.put("timeIn", timeIn);
		message.put("DownMessage", kickMessage);
		message.put("stay", stay);
		message.put("timeOut", timeOut);
		plugin.getConfig().set("Message", message);
		plugin.saveConfig();
		plugin.reloadConfig();
	}
	//Получение верхнего сообщения
	public String getUpMessage() {
		return plugin.getConfig().getConfigurationSection("Message").getString("UpMessage");
	}
	//Получение нижнего сообщение
	public String getDownMessage() {
		return plugin.getConfig().getConfigurationSection("Message").getString("DownMessage");
	}
	//Появление сообщения
	public int getTimeIn() {
		return Integer.parseInt(plugin.getConfig().getConfigurationSection("Message").getString("timeIn"));
	}
	//Длительность сообщения
	public int getStay() {
		return Integer.parseInt(plugin.getConfig().getConfigurationSection("Message").getString("stay"));
	}
	//Затухание сообщения
	public int gettimeOut() {
		return Integer.parseInt(plugin.getConfig().getConfigurationSection("Message").getString("timeOut"));
	}
	
	public boolean sendMessage(Player player) {
		if(plugin.getConfig().contains("Message")) {
			String DownMessage = "";
			if(cg.leftTimeMessage() < 60) {
				DownMessage = "Через "+ cg.leftTimeMessage() + " секунд";
			}else if(cg.leftTimeMessage() > 60 && cg.leftTimeMessage() < 3600) {
				DownMessage = "Через "+ (cg.leftTimeMessage()*60) + " Минут";
			}else if(cg.leftTimeMessage() > 3600) {
				DownMessage = "Через "+ (cg.leftTimeMessage()*3600) + " Часов";
			}
			player.sendTitle(getUpMessage(), DownMessage,  getTimeIn(), getStay(), gettimeOut());
		return true;
		}
		return false;
	}
	public String ColorizeText(String text) {
		for(int a = 0; a < text.length(); a++) {
			text = ChatColor.translateAlternateColorCodes('&', text);
		}
		return text;
	}
	public String getRestartMessage() {
		return ColorizeText(plugin.getConfig().getString("RestartMessage"));
	}
	public void kickAll() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			Bukkit.getPlayer(player.getName()).kickPlayer(getRestartMessage());
		}
	}
}