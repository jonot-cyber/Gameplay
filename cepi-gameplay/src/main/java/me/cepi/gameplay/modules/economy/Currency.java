package me.cepi.gameplay.modules.economy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Currency implements Listener {
	
	public static String generateTier(int tier, ChatColor tierColor) {
		return ChatColor.DARK_GRAY + "(" + tierColor + "T" + tier + ChatColor.DARK_GRAY + ") ";
	}
	
	public static List<ItemStack> integerToItems(int amount) {
		int crateDivider = 4096;
		int barDivider = 64;
		
		int crates = (int) Math.floor(amount / crateDivider);
		amount = amount - (crateDivider * crates);
		
		int bars = (int) Math.floor(amount / barDivider);
		amount = amount - (barDivider * bars);

		int nuggets = amount;
		
		// TODO add items to list
		
		ItemStack crate = new ItemStack(Material.IRON_BLOCK);
		ItemMeta crateMeta = crate.getItemMeta();
		crateMeta.setDisplayName(generateTier(3, ChatColor.GREEN) + ChatColor.GRAY + "Silver Block");
		crate.setItemMeta(crateMeta);
		crate.setAmount(crates);
		
		ItemStack bar = new ItemStack(Material.IRON_INGOT);
		ItemMeta barMeta = bar.getItemMeta();
		barMeta.setDisplayName(generateTier(2, ChatColor.BLUE) + ChatColor.GRAY + "Silver Bar");
		bar.setItemMeta(barMeta);
		bar.setAmount(bars);
		
		ItemStack nugget = new ItemStack(Material.IRON_NUGGET);
		ItemMeta nuggetMeta = nugget.getItemMeta();
		nuggetMeta.setDisplayName(generateTier(1, ChatColor.GRAY) + ChatColor.GRAY + "Silver Nugget");
		nugget.setItemMeta(nuggetMeta);
		nugget.setAmount(nuggets);
		
		List<ItemStack> itemList = new ArrayList<>();
		itemList.add(crate);
		itemList.add(bar);
		itemList.add(nugget);
		
		return itemList;
	}
	
	public static int itemsToMoney(ItemStack[] stack) {
		int amount = 0;
		for (ItemStack item : stack) {
			if (item != null) {
				ItemMeta meta = item.getItemMeta();
				if (meta.getDisplayName().contains("Silver Block")) {
					amount = amount + 4096;
				} else if (meta.getDisplayName().contains("Silver Bar")) {
					amount = amount + 64;
				} else if (meta.getDisplayName().contains("Silver Nugget")) {
					amount++;
				}
			}
		}
		return amount;
	}
}