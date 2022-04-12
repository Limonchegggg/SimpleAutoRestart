package Main;

public class TimeConvert {
	private int hour;
	private int minute;
	private int second;
	private int time;
	public TimeConvert(int sec) {
		this.time = sec;
		int left = sec;
		if(sec>=3600) {
			this.hour = sec/3600;
			left = sec - (hour*3600);
		}
		if(left>=60) {
			this.minute = left/60;
			left = left - (minute*60);
		}
		this.second = left;
	}
	
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public int getTime() {
		return time;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public void setSecond(int second) {
		this.second = second;
	}
}
