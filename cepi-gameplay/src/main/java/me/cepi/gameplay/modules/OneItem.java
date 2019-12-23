package me.cepi.gameplay.modules;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OneItem {
	
	ItemStack item;

	public OneItem(Material material) {
		this.item = new ItemStack(material);
	}
	
	public OneItem setName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}
	
}
