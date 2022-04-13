package Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
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