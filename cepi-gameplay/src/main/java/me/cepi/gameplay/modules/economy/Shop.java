package me.cepi.gameplay.modules.economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Shop implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.eco")) return false;
		Player player = (Player) sender;
		if (label.equalsIgnoreCase("adminshop")) {
			
		} else if (label.equalsIgnoreCase("shop")) {
			
		}
		return true;
	}
	
}
