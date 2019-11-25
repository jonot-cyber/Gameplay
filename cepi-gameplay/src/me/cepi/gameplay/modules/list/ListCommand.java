package me.cepi.gameplay.modules.list;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ListCommand implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		Inventory inv = Bukkit.createInventory(null, 54, "§9Player List");
		
		int loop = 0;
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
	        SkullMeta meta = (SkullMeta) stack.getItemMeta();
	        meta.setOwningPlayer(p);
	        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix()) + "§e" + p.getDisplayName() + "");
	        stack.setItemMeta(meta);
	        inv.setItem(loop, stack);
	        loop++;
		}
		
		player.openInventory(inv);
		
		return true;
	}
}
