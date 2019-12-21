package me.cepi.gameplay.modules;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class FlyCommand implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (player.getAllowFlight()) {
			player.setAllowFlight(false);
			player.setFlying(false);
			player.sendMessage(Inserts.POSITIVE + "You can no longer fly!");
		} else {
			player.setAllowFlight(true);
			player.sendMessage(Inserts.POSITIVE + "You can now fly!");
		}
		return true;
	}

}
