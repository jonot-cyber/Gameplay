package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;

import me.cepi.gameplay.Main;
import net.md_5.bungee.api.ChatColor;

public class StylishDeath implements Listener {

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (player.getHealth() < event.getFinalDamage()) {
				event.setCancelled(true);
				player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
				player.setFireTicks(0);
				player.setFoodLevel(20);
				player.getWorld().playSound(player.getLocation(), Sound.ENTITY_SKELETON_DEATH, 2, 0);
				DustOptions dustOptions = new DustOptions(Color.fromRGB(255, 100, 100), 1);
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 500, 1, 2, 1, dustOptions);
				player.setGameMode(GameMode.SPECTATOR);
				player.sendTitle(ChatColor.RED + "You Died!", ChatColor.GRAY + "Respawning in 3 seconds...", 20, 30, 0);
				
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> 
					player.sendTitle(ChatColor.RED + "You Died!", ChatColor.GRAY + "Respawning in 2 seconds...", 0, 30, 0)
				, 20);
				
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> 
					player.sendTitle(ChatColor.RED + "You Died!", ChatColor.GRAY + "Respawning in 1 second...", 0, 20, 10)
				, 40);
				
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
					player.teleport(player.getWorld().getSpawnLocation());;
					for(PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
					player.setGameMode(GameMode.ADVENTURE);
				}, 60);
			}
		}
	}
	
}
