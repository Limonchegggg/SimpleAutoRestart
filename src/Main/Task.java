package Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Task implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command com, String str, String[] args) {
		if(!sender.hasPermission("SimpleAutoRestart.task")) return false;
		if(args.length < 1) return false;
		switch(args[0]) {
		case "stop":
			
			return false;
		}
		return false;
	}
}
