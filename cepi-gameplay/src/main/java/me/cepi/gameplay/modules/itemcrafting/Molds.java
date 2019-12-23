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
	
	public static final ItemStack CROSSBOW() {
		return generateMold("Crossbow", Material.CROSSBOW, "crossbows");
	}
	
	public static final ItemStack SWORD() {
		return generateMold("Sword", Material.WOODEN_SWORD, "swords");
	}
	
	public static final ItemStack AXE() {
		return generateMold("Axe", Material.WOODEN_AXE, "axes");
	}
	
	public static final ItemStack SCYTHE() {
		return generateMold("Scythe", Material.WOODEN_HOE, "scythes");
	}
	
	public static final ItemStack MACE() {
		return generateMold("Mace", Material.WOODEN_SHOVEL, "maces");
	}
	
}
