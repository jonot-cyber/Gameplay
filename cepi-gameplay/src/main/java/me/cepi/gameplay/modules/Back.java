package me.cepi.gameplay.modules;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Back implements CommandExecutor {
	
	public static Map<Player, Location> back = new HashMap<Player, Location>();
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!(sender.hasPermission("cepi.staff"))) return false;
		Player player = (Player) sender;
		if (!(args.length > 0)) {
			if (!(back.get(player) == null)) {
				Location loc = back.get(player);
				player.teleport(loc);
				player.sendMessage(Inserts.POSITIVE + "You have been teleported back");
			} else
				player.sendMessage(Inserts.ERROR + "No previous locations");
		} else
			player.sendMessage(Inserts.ERROR + "Too many arguements");
		return true;
	}

}
