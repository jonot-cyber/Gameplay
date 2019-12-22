package me.cepi.gameplay.modules.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.cepi.gameplay.Main;

public class MenuItems implements MenuItemFace, Listener {

	public String title;
	public List<Integer> slots = new ArrayList<>();
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
            && slots.contains(eventSlot)) {
        	if (codeBlock != null) codeBlock.run();
        	if (this.shouldCancel) event.setCancelled(true);
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
	
	public MenuItems(List<MenuItem> menuItems) {
		menuItems.forEach((item) -> slots.add(item.slot));
	}
	
}
