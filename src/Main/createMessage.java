package Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class createMessage implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command com, String str, String[] args){
		if(!sender.hasPermission("SimpleAutoRestart.messages")) {
			sender.sendMessage(ChatColor.GRAY + "Нет прав!");
			return false;
		}
		if(args.length < 5) {
			sender.sendMessage(ChatColor.GRAY + "createMessage <TimeIn> <Stay> <TimeOut> <UpMessage> <KickMessage> //Its a title");
			return false;
		}
		Messages msg = new Messages();
		msg.CreateMessage(args[0], args[1], args[2], args[3], args[4]);
		return false;
	}
}