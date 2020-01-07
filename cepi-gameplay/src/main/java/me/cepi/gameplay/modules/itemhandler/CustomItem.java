package me.cepi.gameplay.modules.itemhandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import me.cepi.gameplay.Main;
import me.cepi.gameplay.modules.itemcrafting.Rarity;

public class CustomItem {

	private Rarity rarity = Rarity.COMMON;
	private String name;
	private Material material;
	private int level = 1;
	private String lore = null;
	private Integer minDamage = 2;
	private Integer maxDamage = 2;

	public CustomItem(String name, Material material) {
		this.material = material;
		this.name = name;
	}
	
	public CustomItem(String name, Material material, Rarity rarity) {
		this.rarity = rarity;
		this.material = material;
		this.name = name;
	}
	
	public CustomItem(String name, Material material, Rarity rarity, int level) {
		this.rarity = rarity;
		this.material = material;
		this.name = name;
		this.level = level;
	}
	
	public CustomItem(String name, Material material, Rarity rarity, int level, int minDamage, int maxDamage) {
		this.rarity = rarity;
		this.material = material;
		this.name = name;
		this.level = level;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}
	
	public CustomItem setDisplayName(String name) {
		this.name = name;
		return this;
	}
	
	public static CustomItem fromJson(File file) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new GsonBuilder().create();
		CustomItem weapon = gson.fromJson(new FileReader(file), CustomItem.class);
		return weapon;
	}
	
	public ItemStack toItem() {
		String rarityName = "";
		ChatColor rarityColor = null;
		switch (rarity) {
			case COMMON:
				rarityName = "Common";
				rarityColor = ChatColor.GRAY;
				break;
			case UNCOMMON:
				rarityName = "Uncommon";
				rarityColor = ChatColor.GREEN;
				break;
			case RARE:
				rarityName = "Rare";
				rarityColor = ChatColor.BLUE;
				break;
			case EPIC:
				rarityName = "Epic";
				rarityColor = ChatColor.LIGHT_PURPLE;
				break;
			case LEGENDARY:
				rarityName = "Legendary";
				rarityColor = ChatColor.GOLD;
				break;
			default:
				rarityName = "Common";
				rarityColor = ChatColor.GRAY;
		}
		
		ItemStack weapon = new ItemStack(this.material);
		ItemMeta weaponMeta = weapon.getItemMeta();
		weaponMeta.setDisplayName(rarityColor + this.name);
		
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "Level: " + ChatColor.YELLOW + this.level);
		lore.add("");
		if (this.lore != null) {
			lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + this.lore);
			lore.add("");
		}
		lore.add("" + rarityColor + ChatColor.BOLD + rarityName);
		
		weaponMeta.setLore(lore);
		
		NamespacedKey keyLevel = new NamespacedKey(Main.getPlugin(Main.class), "level");
		weaponMeta.getPersistentDataContainer().set(keyLevel, PersistentDataType.INTEGER, this.level);
		
		NamespacedKey keyMinDamage = new NamespacedKey(Main.getPlugin(Main.class), "minDamage");
		weaponMeta.getPersistentDataContainer().set(keyMinDamage, PersistentDataType.INTEGER, this.minDamage);
		NamespacedKey keyMaxDamage = new NamespacedKey(Main.getPlugin(Main.class), "maxDamage");
		weaponMeta.getPersistentDataContainer().set(keyMaxDamage, PersistentDataType.INTEGER, this.maxDamage);
		
		weapon.setItemMeta(weaponMeta);
		return weapon;
	}
	

	
}
