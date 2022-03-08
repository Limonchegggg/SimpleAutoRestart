package Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		getServer().getPluginCommand("createMessage").setExecutor(new createMessage());
		getServer().getPluginCommand("memory").setExecutor(new memory());
		if(getConfig().getBoolean("usingTimer")) {
			new Timer();
		}else {
			new TimerMemory();
		}
		
	}
	@Override
	public void onDisable() {
		
	}
	
}