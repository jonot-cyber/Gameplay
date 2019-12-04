package me.cepi.gameplay.modules.itemediting;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SimpleRename implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (player.getInventory().getItemInMainHand() == null) return false;
		String combinedArgs = String.join(" ", args);
		
		ItemStack hand = player.getInventory().getItemInMainHand();
		ItemMeta handMeta = hand.getItemMeta();
		handMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', combinedArgs));
		hand.setItemMeta(handMeta);
		player.getInventory().setItemInMainHand(hand);
		return true;
	}
}
