package me.cepi.gameplay.modules.itemcrafting;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.cepi.gameplay.modules.menu.Menu;

public class WeaponBench implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		Block block = event.getClickedBlock();
		if (!(block.getType().equals(Material.CRAFTING_TABLE))) return;
		if (!(block.getRelative(BlockFace.DOWN).getType().equals(Material.RED_GLAZED_TERRACOTTA))) return;
		event.setCancelled(true);
		Player player = event.getPlayer();
		Menu menu = new Menu(player, 6, "Crafting");
		player.openInventory(menu.toInventory());
		
	}

}
