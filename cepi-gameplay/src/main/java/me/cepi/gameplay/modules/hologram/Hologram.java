package me.cepi.gameplay.modules.hologram;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import me.cepi.gameplay.Main;

public class Hologram {
	
	public Hologram(String name, Location loc, Integer decayTime) {
		ArmorStand entity = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		entity.setInvulnerable(true);
		entity.setCustomName(name);
		entity.setCustomNameVisible(true);
		entity.setVisible(false);
		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
			entity.remove();
		}, decayTime * 20);
	}

}
