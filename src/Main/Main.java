package Main;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public ArrayList<String> task = new ArrayList<String>();
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		getServer().getPluginCommand("createMessage").setExecutor(new createMessage());
		getServer().getPluginCommand("timeleft").setExecutor(new restartInfo());
		new Timer();
		
	}
	@Override
	public void onDisable() {
		
	}
	
}