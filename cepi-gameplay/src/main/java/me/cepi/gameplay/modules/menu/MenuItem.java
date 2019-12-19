package me.cepi.gameplay.modules.menu;

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
    private Boolean shouldCancel = false;

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
    	Player eventPlayer = (Player) event.getWhoClicked();
        String eventTitle = event.getView().getTitle();
        Integer eventSlot = event.getSlot();
        if (player.getUniqueId() == eventPlayer.getUniqueId() 
            && title == eventTitle
            && slot == eventSlot) {
        	if (codeBlock != null) codeBlock.run();
        	if (this.shouldCancel) event.setCancelled(true);
        }  
    }

    public void onClick(Runnable code, Boolean toCancel) {
        codeBlock = code;
        this.shouldCancel = toCancel;
        Main.getPlugin(Main.class).getServer().getPluginManager().registerEvents(this, Main.getPlugin(Main.class));
    }
    
    public void onClick(Boolean toCancel) {
        this.shouldCancel = toCancel;
        Main.getPlugin(Main.class).getServer().getPluginManager().registerEvents(this, Main.getPlugin(Main.class));
    }

    public MenuItem(String title, int slot, Player player) {
        this.title = title;
        this.slot = slot;
        this.player = player;
    }

}