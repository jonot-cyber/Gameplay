package me.cepi.gameplay.modules;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Top implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		Location top = player.getLocation();
		top.setY(256);
		for (int i = 0; i < 256; i++) {
			if (player.getLocation().getBlockY() == top.getY()) {
				player.sendMessage(Inserts.NEGATIVE + "You are already at the top!");
				break;
			}
			if (!top.getBlock().isPassable()) {
				Location tempLoc = top;
				tempLoc.setY(tempLoc.getY() + 1);
				player.teleport(tempLoc);
				player.sendMessage(Inserts.POSITIVE + "Woosh!");
				break;
			}
			top.setY(top.getY() - 1);
		}
		return true;
	}
	
}
