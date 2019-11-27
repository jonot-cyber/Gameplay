package me.cepi.gameplay.modules.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuItem implements Listener {
    private String title;
    private Integer slot;
    private Player player;
    static Runnable codeBlock;

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player eventPlayer = (Player) event.getWhoClicked();
        String eventTitle = event.getView().getTitle();
        Integer eventSlot = event.getSlot();

        if (player == eventPlayer 
            && title == eventTitle
            && slot == eventSlot) {
            
            codeBlock.run();
        }
    }

    public void onClick(Runnable code) {
        codeBlock = code;
    }

    public MenuItem(String title, Integer slot, Player player) {
        this.title = title;
        this.slot = slot;
        this.player = player;
    }
}