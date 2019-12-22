package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class TphereCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.staff")) return false;
		Player player = (Player) sender;
		if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if (!(target == null)) {
				Location loc = player.getLocation();
				target.teleport(loc);
				player.sendMessage(Inserts.POSITIVE + "You teleported " + target.getName() + " to you");	
				target.sendMessage(Inserts.POSITIVE + player.getName() + " has teleported you to them");
			} else {
				player.sendMessage(Inserts.NEGATIVE + "That is not a valid player!");
			}
		} else {
			player.sendMessage(Inserts.NEGATIVE + "Error: too many arguements!");
		}
		return true;
	}
	
}
