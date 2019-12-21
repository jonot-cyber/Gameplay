package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;

public class GiveSkull implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		ItemStack head = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta headMeta = (SkullMeta) head.getItemMeta();
		if (args.length > 0) {
			headMeta.setOwningPlayer(Bukkit.getOfflinePlayer(args[0]));
			head.setItemMeta(headMeta);
			player.getInventory().setItemInMainHand(head);
			player.sendMessage(Inserts.POSITIVE + "Gave you the skull of " + ChatColor.YELLOW + args[0] + ChatColor.GRAY + "!");
		} else player.sendMessage(Inserts.NEGATIVE + "Usage: /skull <player>");
		return true;
	}
}
