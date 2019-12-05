package me.cepi.gameplay.modules.economy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Currency implements Listener {
	public static List<ItemStack> integerToItems(double amount) {
		int crateDivider = 4096;
		int barDivider = 64;
		
		int bars = (int) Math.floor(amount / barDivider);
		amount = amount - (barDivider * bars);

		int pouches = (int) Math.floor(amount / crateDivider);
		amount = amount - (crateDivider * pouches);

		double nuggets = amount;
		
		// TODO add items to list
				
		
		List<ItemStack> itemList = new ArrayList<>();
		return itemList;
	}
}