package me.cepi.gameplay.modules;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class ElytraBoost implements Listener {
	
	@EventHandler
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		if (player.isSneaking() && player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() == Material.ELYTRA && player.isGliding()) {
			player.setVelocity(player.getLocation().getDirection().multiply(2));
			player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
		}
	}
}
