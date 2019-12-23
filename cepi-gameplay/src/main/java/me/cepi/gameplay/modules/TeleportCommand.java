package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class TeleportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		Player target = Bukkit.getPlayer(args[0]);
		if (args.length > 1) {
			Player target2 = Bukkit.getPlayer(args[1]);
			if (!(target == null || target2 == null)) {
				Location loc = target2.getLocation();
				Back.back.put(player, loc);
				target.teleport(loc);
				target.sendMessage(Inserts.POSITIVE + "You have been teleported to " + target2.getName() + " by " + player.getName());
				target2.sendMessage(Inserts.POSITIVE + target.getName() + " has been teleported to you by " + player.getName());
				player.sendMessage(Inserts.POSITIVE + "You teleported " + target.getName() + " to " + target2.getName());
			} else
				player.sendMessage(Inserts.NEGATIVE + "That is not a valid player!");
		} else if (args.length > 0) {
			if (!(target == null)) {
				Location loc = target.getLocation();
				Back.back.put(player, loc);
				player.teleport(loc);
				player.sendMessage(Inserts.POSITIVE + "You teleported to " + target.getName());
				target.sendMessage(Inserts.POSITIVE + player.getName() + " has teleported to you");
			} else
				player.sendMessage(Inserts.NEGATIVE + "That is not a valid player!");
		} else player.sendMessage(Inserts.NEGATIVE + "You need someone to TP to!");
		return true;
	}
}
