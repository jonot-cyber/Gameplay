package me.cepi.gameplay.modules.economy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Currency implements Listener {
	public static List<ItemStack> integerToItems(double amount) {
		int crateDivider = 262144;
		int barDivider = 4096;
		int pouchDivider = 64;
		double crates = Math.floor(amount / crateDivider);
		amount = amount - (crateDivider * crates);

		double bars = Math.floor(amount / barDivider);
		amount = amount - (barDivider * bars);

		double pouches = Math.floor(amount / pouchDivider);
		amount = amount - (pouchDivider * pouches);

		double nuggets = amount;
		
		// TODO add items to list
				
		List<ItemStack> itemList = new ArrayList<>();
		return itemList;
	}
}