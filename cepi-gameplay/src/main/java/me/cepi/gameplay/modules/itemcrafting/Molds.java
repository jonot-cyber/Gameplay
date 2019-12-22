package me.cepi.gameplay.modules.itemcrafting;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public final class Molds {
	
	public static final ItemStack generateMold(String matName, Material material, String descName) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + matName + " Mold");
		meta.setLore(Arrays.asList(ChatColor.GRAY + "Mold for crafting " + descName));
		item.setItemMeta(meta);
		return item;
	}
	
	public static final ItemStack TRIDENT() {
		return generateMold("Spear", Material.TRIDENT, "spears");
	}
	
}
