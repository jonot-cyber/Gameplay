package me.cepi.gameplay.modules.economy.shop;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class Price {

	int amount;
	List<ItemStack> items;
	
	public Price(int amount) {
		
		this.amount += amount;
	}
	
	public Price(ItemStack item, int amount) {
		items.add(item);
		this.amount = amount;
	}
	public Price(List<ItemStack> items, int amount) {
		this.items = items;
		this.amount = amount;
	}
	public Price(ItemStack item) {
		items.add(item);
	}
	public Price(List<ItemStack> items) {
		this.items = items;
	}
	
	public Price addPrice(int amount) {
		this.amount += amount;
		return this;
	}
	
}
