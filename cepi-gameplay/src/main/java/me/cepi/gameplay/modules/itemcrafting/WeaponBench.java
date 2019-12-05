package me.cepi.gameplay.modules.itemcrafting;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeaponBench implements Listener {
	
	public void onPlayerInteract (PlayerInteractEvent event) {
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		event.setCancelled(true);
		
		// TODO waiting on jeremy for inventory api
		
	}

}
