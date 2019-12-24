package me.cepi.gameplay.modules.social.messaging;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Reply implements CommandExecutor {

	public static Map<Player, Player> reply = new HashMap<Player, Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		if (!(reply.get(player) == null)) {
			Player target = reply.get(player);
			StringBuilder builder = new StringBuilder();
			for(int i = 1; i < args.length; i++) {
			   builder.append(args[i] + " ");
			}
			String msg = builder.toString();
			player.sendMessage(Inserts.POSITIVE + "To " + target.getName() + ": " + msg);
			target.sendMessage(Inserts.POSITIVE + "From " + player.getName() + ": " + msg);
			reply.put(player, target);
		} else {
			player.sendMessage(Inserts.ERROR + "That is not a valid player!");
		}
		return true;
	}
	
}
