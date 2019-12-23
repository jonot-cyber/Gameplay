package me.cepi.gameplay.modules.economy.shop;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.cepi.gameplay.modules.menu.Menu;

public class Shop {
	
	public ShopColor theme = ShopColor.GREEN;
	public List<ShopItem> shopItems;
	private Player player;
	private String title;
	public ItemStack icon;

	public Shop(Player player, String title, ShopColor theme, ItemStack icon) {
		this.player = player;
		this.title = title;
		this.theme = theme;
		this.icon = icon;
	}
	
	public Menu compileMenu() {
		Menu menu = new Menu(player, 6, title);
		return menu;
	}
	
}
