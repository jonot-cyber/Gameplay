package me.cepi.gameplay.modules.menu;

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

    public Menu(Player p, Integer inventoryRows, String inventoryTitle) {
        if (!(inventoryRows < 1 || inventoryRows > 6) && !(inventoryTitle.contains("§"))) {
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