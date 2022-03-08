package Main;


import org.bukkit.plugin.Plugin;


public class ConfigGetter{
	Plugin plugin = Main.getPlugin(Main.class);
	
	public int getSecondTime() {
		return plugin.getConfig().getInt("sec");
	}
	
	public int getMinuteTime() {
		return plugin.getConfig().getInt("min");
	}
	
	public int getHourTime() {
		return plugin.getConfig().getInt("hour");
	}
	
	public int MinInSec() {
		return getMinuteTime()*60;
	}
	
	public int HoursInSec() {
		return getHourTime()*3600;
	}
	
	public int SecInTick() {
		return getSecondTime()*20;
	}
	//Получение остатка времени
	public int leftTimeMessage() {
		int time = (int)(RestartTime()*0.1);
		return time;
	}
	//Полное время
	public int RestartTime() {
		return getSecondTime() + MinInSec() + HoursInSec();
	}
	//Получение таймера
	public boolean getBooleanTimer() {
		return plugin.getConfig().getBoolean("usingTimer");
	}

}
