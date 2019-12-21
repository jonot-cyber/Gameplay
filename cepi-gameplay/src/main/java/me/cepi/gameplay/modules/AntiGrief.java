package me.cepi.gameplay.modules;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class AntiGrief implements Listener {

	@EventHandler
	public void playerPlaceBlock(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("cepi.builder")) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void playerBreakBlock(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("cepi.builder")) {
			event.setCancelled(true);
		}
	}
}