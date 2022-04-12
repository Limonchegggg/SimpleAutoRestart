package Main;

import org.bukkit.ChatColor;
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
		TimeConvert tc = new TimeConvert(t.getLeftTime());
		sender.sendMessage(ChatColor.YELLOW + "До рестарта осталось " + ChatColor.GOLD + tc.getHour() + " часов" + tc.getMinute() + " минут" + tc.getSecond() + " секунд");
		return true;
	}

}
