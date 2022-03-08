package Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerMemory {
	private Main main = Main.getPlugin(Main.class);
	private Messages msg = new Messages();
	private int time = 0;
	public TimerMemory() {
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if(((freeMemory()/totalMemory())*100) < 10) {
					if(time == 1) {
						for(Player player : Bukkit.getOnlinePlayers()){
							player.sendTitle(msg.getUpMessage(), "Перезапуск сервера через 1 минуту");
						}
					}
					if(time == 55) {
						for(Player player : Bukkit.getOnlinePlayers()) {
							player.sendTitle("Рестарт сервера!", "5 секунд");
						}
					}
					time++;
					if(time >= 60) {
						time = 0;
						msg.kickAll();
						main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "save-all");
						Bukkit.spigot().restart();
					}
				}
			}
		}.runTaskTimer(main, 20L, 20L);
	}
	private long freeMemory() {
		Runtime r = Runtime.getRuntime();
		return r.freeMemory();
	}
	private long totalMemory() {
		Runtime r = Runtime.getRuntime();
		return r.totalMemory();
	}
}
