package me.cepi.gameplay.staffchat;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.Main;

public class StaffChatCommand implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		List<Player> staffPlayers = Main.staffChatList;
		if (args.length == 0) {
			if (staffPlayers.contains(player)) {
				staffPlayers.remove(player);
				player.sendMessage("§8[§e*§8]§7 Staff chat §cdisabled!");
			} else {
				staffPlayers.add(player);
				player.sendMessage("§8[§e*§8]§7 Staff chat §aenabled!");
			}
		} else {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.hasPermission("cepi.staff"))
					p.sendMessage("§8(§e*§8) §7LeoDog896 §8// §f" + ChatColor.translateAlternateColorCodes('&', args[0]));
					
		}
		return true;
	}

}
