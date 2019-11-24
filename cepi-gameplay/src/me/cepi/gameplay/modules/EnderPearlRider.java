package me.cepi.gameplay.modules;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class EnderPearlRider implements Listener {
	
	@EventHandler
	public void onPlayerDismount(EntityDismountEvent event) {
		if (event.getDismounted() instanceof EnderPearl) 
			event.getDismounted().remove();
	}
	
	@EventHandler
	public void onPlayerThrow(ProjectileLaunchEvent event) {
		if (event.getEntity() instanceof EnderPearl) {
			Player player = (Player) event.getEntity().getShooter();
			
			if (player.getVehicle() instanceof EnderPearl) 
				player.getVehicle().remove();
			
			event.getEntity().addPassenger(player);
		}
	}
}
