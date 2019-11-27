package me.cepi.gameplay.modules;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Dash implements Listener {
	private final Material[] RIGHTTYPES = new Material[]{
		Material.DIAMOND_SWORD,
		Material.IRON_SWORD,
		Material.GOLDEN_SWORD,
		Material.STONE_SWORD,
		Material.WOODEN_SWORD,
		
		Material.DIAMOND_AXE,
		Material.IRON_AXE,
		Material.GOLDEN_AXE,
		Material.STONE_AXE,
		Material.WOODEN_AXE,
		
		Material.DIAMOND_SHOVEL,
		Material.IRON_SHOVEL,
		Material.GOLDEN_SHOVEL,
		Material.STONE_SHOVEL,
		Material.WOODEN_SHOVEL,
		
		Material.DIAMOND_HOE,
		Material.IRON_HOE,
		Material.GOLDEN_HOE,
		Material.STONE_HOE,
		Material.WOODEN_HOE,
	};
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getFoodLevel() < 7) return;
		ItemStack item = player.getInventory().getItemInMainHand();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Boolean isCorrect = false;
			for (Material mat : RIGHTTYPES) 
				if (item.getType() == mat)
					isCorrect = true;
			if (isCorrect) {
				player.setVelocity(player.getLocation().getDirection().multiply(1.3));
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1, 1);
				player.setFoodLevel(player.getFoodLevel() - 3);
			}
		} else if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			
		}
	}

}
