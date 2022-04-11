package Main;

public enum timeType {
	hour("3600"),
	minute("60"),
	second("1");
	
	private String string;
	
	timeType(String string) {
		this.string = string;
	}
	public String getTitle() {
		return string;
	}
}
