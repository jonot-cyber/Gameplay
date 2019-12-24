package me.cepi.gameplay.modules.social.messaging;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class MessageSystem implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		if (args.length > 0) {
			Player target = Bukkit.getPlayer(args[0]);
			if (!(target == null)) {
				StringBuilder builder = new StringBuilder();
				for(int i = 1; i < args.length; i++) {
				   builder.append(args[i] + " ");
				}
				String msg = builder.toString();
				player.sendMessage(Inserts.POSITIVE + "To " + target.getName() + ": " + msg);
				target.sendMessage(Inserts.POSITIVE + "From " + player.getName() + ": " + msg);
				Reply.reply.put(player, target);
			} else {
				player.sendMessage(Inserts.ERROR + "That is not a valid player!");
			}
		} else {
			player.sendMessage(Inserts.ERROR + "Not enough aruements");
		}
		return true;
	}
	
}
