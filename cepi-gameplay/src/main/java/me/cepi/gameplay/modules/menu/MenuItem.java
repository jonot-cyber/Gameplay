package me.cepi.gameplay.modules.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.cepi.gameplay.Main;

public class MenuItem implements Listener {
    private String title;
    private int slot;
    private Player player;
    static Runnable codeBlock;

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
    	Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), () -> {
    		Player eventPlayer = (Player) event.getWhoClicked();
            String eventTitle = event.getView().getTitle();
            Integer eventSlot = event.getSlot();
            Bukkit.broadcastMessage("" + slot + "." + eventSlot);
            Bukkit.broadcastMessage("" + title + "." + eventTitle);
            Bukkit.broadcastMessage("" + player.getUniqueId().toString() + "." + eventPlayer.getUniqueId().toString());
            if (player.getUniqueId() == eventPlayer.getUniqueId() 
                && title == eventTitle
                && slot == eventSlot) {
                
                codeBlock.run();
            }
    	});
    }

    public void onClick(Runnable code) {
        codeBlock = code;
    }

    public MenuItem(String title, int slot, Player player) {
        this.title = title;
        this.slot = slot;
        this.player = player;
    }
}