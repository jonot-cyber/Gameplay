package me.cepi.gameplay.modules.economy;

import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItem {
	
	ItemStack item;
	Price price;
	
	public ShopItem(ItemStack item, Price price) {
		this.item = item;
		this.price = price;
	}
	
	public ItemStack compile() {
		ItemStack item = this.item;
		ItemMeta meta = item.getItemMeta();
		List<String> lore = meta.getLore();
		lore.add(" ");
		item.setItemMeta(meta);
		return item;
	}

}
