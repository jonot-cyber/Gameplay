package me.cepi.gameplay.modules.economy.shop;

import org.bukkit.Material;

import net.md_5.bungee.api.ChatColor;

public enum ShopColor {

	CLEAR(ChatColor.WHITE, Material.GLASS_PANE),
	WHITE(ChatColor.WHITE, Material.WHITE_STAINED_GLASS_PANE),
	ORANGE(ChatColor.GOLD, Material.ORANGE_STAINED_GLASS_PANE),
	MAGENTA(ChatColor.DARK_PURPLE, Material.MAGENTA_STAINED_GLASS_PANE),
	LIGHT_BLUE(ChatColor.BLUE, Material.LIGHT_BLUE_STAINED_GLASS_PANE),
	YELLOW(ChatColor.YELLOW, Material.YELLOW_STAINED_GLASS_PANE),
	GREEN(ChatColor.GREEN, Material.LIME_STAINED_GLASS_PANE),
	PINK(ChatColor.LIGHT_PURPLE, Material.PINK_STAINED_GLASS_PANE),
	GRAY(ChatColor.DARK_GRAY, Material.GRAY_STAINED_GLASS_PANE),
	LIGHT_GRAY(ChatColor.GRAY, Material.LIGHT_GRAY_STAINED_GLASS_PANE),
	RED(ChatColor.RED, Material.RED_STAINED_GLASS_PANE),
	BLACK(ChatColor.BLACK, Material.BLACK_STAINED_GLASS_PANE);
	
	private ChatColor color;
	private Material material;
	
	ShopColor (ChatColor color, Material material) {
		this.color = color;
		this.material = material;
	}
	
	public ChatColor getColor() {
		return color;
	}
	
	public Material getMaterial() {
		return material;
	}
	
}
