package me.cepi.gameplay.modules.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
public class Menu implements Listener {
    static Inventory inv;
    static Player player;
    static String title;

    public MenuItem setItem(Integer slot, ItemStack item) {
        inv.setItem(slot, item);
        return new MenuItem(title, slot, player);
    }

    public Inventory toInventory() {
        return inv;
    }
    
    public MenuItems setRow(Integer row, ItemStack stack) {
    	row--;
    	int startIndex = row * 9;
    	if (startIndex > inv.getSize()) return null;
    	List<MenuItem> menuitems = new ArrayList<>();
    	int endIndex = startIndex + 9;
    	for (startIndex = row * 9; startIndex < endIndex; startIndex++) 
    		menuitems.add(this.setItem(startIndex, stack));
    	return new MenuItems(menuitems);
    }
    
    public Menu(Player p, Integer inventoryRows, String inventoryTitle) {
    	
        if (!(inventoryRows <= 1 || inventoryRows >= 6) && !(inventoryTitle.contains("§"))) {
            // inventoryRows must be between 1 and 6
            // title must not be formatted
            return;
        }

        int inventorySlots = inventoryRows * 9;
        player = p;
        title = inventoryTitle;
        
        inv = Bukkit.createInventory(null, inventorySlots, inventoryTitle);
    }
}