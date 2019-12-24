package me.cepi.gameplay.modules.economy.shop;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.cepi.gameplay.modules.OneItem;
import me.cepi.gameplay.modules.menu.Menu;
import net.md_5.bungee.api.ChatColor;

public class Shop {
	
	private ShopColor theme = ShopColor.GREEN;
	private List<ShopItem> shopItems;
	private Player player;
	private String title;
	private ItemStack icon = new OneItem(Material.EMERALD).setName(ChatColor.GREEN + "Shop").getItem();

	public Shop(Player player, String title, ShopColor theme, ItemStack icon) {
		this.player = player;
		this.title = title;
		this.theme = theme;
		this.icon = icon;
	}
	
	public Shop(String title, ShopColor theme, ItemStack icon) {
		this.title = title;
		this.theme = theme;
		this.icon = icon;
	}
	
	public Shop(String title, ShopColor theme) {
		this.title = title;
		this.theme = theme;
	}
	
	public Shop(String title) {
		this.title = title;
	}
	
	public Menu compileMenu() {
		Menu menu = new Menu(player, 6, title);
		menu.setItem(4, icon);
		menu.setRow(2, new OneItem(theme.getMaterial()).setName(" ").getItem());
		int index = 9;
		for (ShopItem item : shopItems) {
			menu.setItem(index, item.compile(theme));
			index++;
		}
		return menu;
	}
	
	public Menu compileMenu(Player player) {
		Menu menu = new Menu(player, 6, title);
		menu.setItem(4, icon).onClick(true);
		menu.setRow(2, new OneItem(theme.getMaterial()).setName(" ").getItem()).onClick(true);
		int index = 9;
		for (ShopItem item : shopItems) {
			menu.setItem(index, item.compile(theme)).onClick(true);
			index++;
		}
		return menu;
	}
	
	public void setTheme(ShopColor theme) {
		this.theme = theme;
	}
	
}
