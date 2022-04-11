package Main;


import org.bukkit.plugin.Plugin;


public class ConfigGetter{
	Plugin plugin = Main.getPlugin(Main.class);
	
	public int getSecond() {
		return plugin.getConfig().getInt("sec");
	}
	
	public int getMinute() {
		return plugin.getConfig().getInt("min");
	}
	
	public int getHour() {
		return plugin.getConfig().getInt("hour");
	}
	
	public int MinInSec() {
		return getMinute()*60;
	}
	
	public int HoursInSec() {
		return getHour()*3600;
	}
	
	public int SecInTick() {
		return getSecond()*20;
	}
	//Получение остатка времени
	public int leftTimeMessage() {
		int time = (int)(RestartTime()*0.1);
		return time;
	}
	//Полное время
	public int RestartTime() {
		return getSecond() + MinInSec() + HoursInSec();
	}
	//Получение таймера
	public boolean getBooleanTimer() {
		return plugin.getConfig().getBoolean("usingTimer");
	}
}
