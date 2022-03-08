package Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
	private int time = 0;
	private Messages msg = new Messages();
	private ConfigGetter cg = new ConfigGetter();
	private Main main = Main.getPlugin(Main.class);
	public Timer() {
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				time++;
				if(time == cg.leftTimeMessage()) {
					if(Bukkit.getOnlinePlayers() != null) {
						for(Player player : Bukkit.getOnlinePlayers()) {
							msg.sendMessage(player);
						}
					}
				}
				if(time == (cg.RestartTime()-5)) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						player.sendTitle("Рестарт сервера!", "5 секунд");
					}
				}
				if(time >= cg.RestartTime()) {
					time = 0;
					msg.kickAll();
					main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "save-all");
					Bukkit.spigot().restart();
				}
			}
		}.runTaskTimer(main, 20L, 20L);
	}
}