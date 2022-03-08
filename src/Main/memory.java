package Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class memory implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command com, String str, String[] args) {
		if(!sender.hasPermission("SimpleAutoRestart.memory")) {
			sender.sendMessage(ChatColor.GRAY + " У вас нет доступа к этой команде!");
			return false;
		}
		Runtime r = Runtime.getRuntime();
		sender.sendMessage(ChatColor.YELLOW + "Память: " + ChatColor.GREEN + (r.freeMemory()/1000000) + ChatColor.DARK_GRAY + "/" + ChatColor.GREEN + (r.totalMemory()/1000000));
		return false;
	}

}
