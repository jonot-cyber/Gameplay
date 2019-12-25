package me.cepi.gameplay.modules.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import me.cepi.gameplay.Main;

public class MenuItem implements Listener, MenuItemFace {
    private String title;
    private int slot;
    private Player player;
    private Runnable codeBlock;
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
    
    @EventHandler
    public void inventoryClose(InventoryCloseEvent event) {
    	Player eventPlayer = (Player) event.getPlayer();
        String eventTitle = event.getView().getTitle();
        if (player.getUniqueId() == eventPlayer.getUniqueId() 
                && title == eventTitle) {
        	 HandlerList.unregisterAll(this);
        }
    }

    
    @Override
    public void onClick(Runnable code, Boolean toCancel) {
        codeBlock = code;
        this.shouldCancel = toCancel;
        Main.getPlugin(Main.class).getServer().getPluginManager().registerEvents(this, Main.getPlugin(Main.class));
    }
    
    @Override
    public void onClick(Boolean toCancel) {
        this.shouldCancel = toCancel;
        Main.getPlugin(Main.class).getServer().getPluginManager().registerEvents(this, Main.getPlugin(Main.class));
    }

    public MenuItem(String title, int slot, Player player) {
        this.title = title;
        this.slot = slot;
        this.player = player;
    }
    
    public int getSlot() {
    	return slot;
    }

}