package me.cepi.gameplay.modules.spawn;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class ToSpawn implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (player.getWorld() != null || player.getWorld().getSpawnLocation() != null)
			player.teleport(player.getWorld().getSpawnLocation());
		else {
			player.sendMessage(Inserts.NEGATIVE + "No spawn set! Make one!");
			return true;
		}
		player.sendMessage(Inserts.POSITIVE + ChatColor.GRAY + "Sent to spawn!");
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
		return true;
	}
}
