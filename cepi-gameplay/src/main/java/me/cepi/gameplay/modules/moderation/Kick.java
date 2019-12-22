package me.cepi.gameplay.modules.moderation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;

public class Kick implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (args.length > 0) {
			if (Bukkit.getPlayer(args[0]) != null) {
				if (args.length > 1) Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.GREEN + "Cepi Moderation\n" + ChatColor.GRAY + "Kicked For: " + ChatColor.GREEN + args[1]);
				else Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.GREEN + "Cepi Moderation\n" + ChatColor.GRAY + "Kicked from the server.");
			} else player.sendMessage(Inserts.NEGATIVE + "Usage: /kick <online player> [<reason>]");
		} else player.sendMessage(Inserts.NEGATIVE + "Usage: /kick <online player> [<reason>]");
		return true;
	}
	
}
