package me.cepi.gameplay.modules.itemcrafting;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomWeapon {

	private ChatColor rarityColor;
	private String rarity;
	private String name;
	private Material material;

	public CustomWeapon(String name, Material material, Rarity rarity) {
		
		String rarityName = "";
		ChatColor rarityColor = null;
		if (rarity == Rarity.COMMON) {
			rarityName = "Common";
			rarityColor = ChatColor.GRAY;
		} else if (rarity == Rarity.UNCOMMON) {
			rarityName = "Uncommon";
			rarityColor = ChatColor.DARK_GREEN;
		} else if (rarity == Rarity.RARE) {
			rarityName = "Rare";
			rarityColor = ChatColor.BLUE;
		} else if (rarity == Rarity.EPIC) {
			rarityName = "Epic";
			rarityColor = ChatColor.LIGHT_PURPLE;
		} else if (rarity == Rarity.LEGENDARY) {
			rarityName = "Legendary";
			rarityColor = ChatColor.GOLD;
		}
		
		this.rarity = rarityName;
		this.rarityColor = rarityColor;
		this.material = material;
		this.name = name;
	}
	
	public CustomWeapon setDisplayName(String name) {
		this.name = name;
		return this;
	}
	
	public ItemStack compile() {
		ItemStack weapon = new ItemStack(this.material);
		ItemMeta weaponMeta = weapon.getItemMeta();
		weaponMeta.setDisplayName(this.rarityColor + this.name);
		
		List<String> lore = new ArrayList<>();
		lore.add("" + this.rarityColor + ChatColor.BOLD + this.rarity);
		
		weaponMeta.setLore(lore);
		weapon.setItemMeta(weaponMeta);
		return weapon;
	}
	

	
}
