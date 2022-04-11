package Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class Timer {
	private int time = 0;
	private Messages msg = new Messages();
	private ConfigGetter cg = new ConfigGetter();
	private Main main = Main.getPlugin(Main.class);
	public int finalTime = cg.RestartTime();
	private int a = 10;
	public Timer() {
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				time++;
				if(time == (finalTime-30)) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						
						player.sendTitle(ChatColor.DARK_GREEN + "Рестарт сервера!",ChatColor.GOLD + "через 30 секунд");
					}
				}
				if(time == (finalTime-a)) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						player.sendTitle(ChatColor.YELLOW + "До рестарта",""+a);
					}
					a--;
				}
				if(time >= finalTime) {
					time=0;
					a=10;
					msg.kickAll();
					main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "save-all");
					if(Bukkit.getOnlinePlayers().size() == 0) {
					Bukkit.spigot().restart();
					}
				}
			}
		}.runTaskTimer(main, 20L, 20L);
	}
	public int getRestartTime() {
		return finalTime;
	}
}