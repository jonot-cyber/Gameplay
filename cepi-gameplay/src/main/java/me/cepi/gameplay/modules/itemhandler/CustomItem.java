package me.cepi.gameplay.modules.itemhandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import me.cepi.gameplay.modules.itemcrafting.Rarity;

public class CustomItem {

	private Rarity rarity;
	private String name;
	private Material material;

	public CustomItem(String name, Material material, Rarity rarity) {
		this.rarity = rarity;
		this.material = material;
		this.name = name;
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
				rarityColor = ChatColor.DARK_GREEN;
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
		lore.add("" + rarityColor + ChatColor.BOLD + rarityName);
		
		weaponMeta.setLore(lore);
		weapon.setItemMeta(weaponMeta);
		return weapon;
	}
	

	
}
