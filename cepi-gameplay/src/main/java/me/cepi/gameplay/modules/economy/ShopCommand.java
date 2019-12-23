package me.cepi.gameplay.modules.economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;

public class ShopCommand implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.eco")) return false;
		Player player = (Player) sender;
		if (label.equalsIgnoreCase("adminshop")) {
			if (args.length == 0 || (args.length > 0 && args[0] == "help")) {
				player.sendMessage(ChatColor.GRAY + "--- " + ChatColor.GREEN + "Shop Panel" + ChatColor.GRAY + " ---");
				player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/adminshop create <name>");
				player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/adminshop edit <name>");
				player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/adminshop add <name>");
				player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/adminshop meta <name>");
			} else if (args.length > 0) {
				if (args[0] == "create") {
					
				} else if (args[0] == "edit") {
					
				} else if (args[0] == "add") {
					
				} else if (args[0] == "meta") {
					
				} else player.sendMessage(Inserts.NEGATIVE + "Use /adminshop help for help!");
			} else player.sendMessage(Inserts.NEGATIVE + "Use /adminshop help for help!");
		} else if (label.equalsIgnoreCase("shop")) {
			
		}
		return true;
	}
	
}
