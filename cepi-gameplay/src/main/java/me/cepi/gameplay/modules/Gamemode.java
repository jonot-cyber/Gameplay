package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;

public class Gamemode implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.gamemode")) return false;
		Player player = (Player) sender;
		if (label.equalsIgnoreCase("gamemode")) {
			if (args.length > 0) {
				String cmd = args[0].toLowerCase();
				if (cmd.equals("0") || cmd.equals("survival") || cmd.equals("s")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Survival");
				} else if (cmd.equals("1") || cmd.equals("creative") || cmd.equals("c")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Creative");
				} else if (cmd.equals("2") || cmd.equals("adventure") || cmd.equals("a")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Adventure");
				} else if (cmd.equals("3") || cmd.equals("spectator") || cmd.equals("sp")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Spectator");
				}
			}
		} else if (label.equalsIgnoreCase("gmc")) {
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Creative");
		} else if (label.equalsIgnoreCase("gms")) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Survival");
		} else if (label.equalsIgnoreCase("gmsp")) {
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Spectator");
		} else if (label.equalsIgnoreCase("gma")) {
			player.setGameMode(GameMode.ADVENTURE);
			player.sendMessage(Inserts.POSITIVE + "Set gamemode to " + ChatColor.GREEN + "Adventure");
		}
		return true;
	}
	
}
