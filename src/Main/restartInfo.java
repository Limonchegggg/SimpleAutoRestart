package Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class restartInfo implements CommandExecutor {
	
	private Timer t = new Timer();

	@Override
	public boolean onCommand(CommandSender sender, Command com, String str, String[] args) {
		if(!sender.hasPermission("SimpleAutoRestart.restartInfo")) {
			return false;
		}
		return false;
	}

}
