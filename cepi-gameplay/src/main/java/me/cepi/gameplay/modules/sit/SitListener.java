package me.cepi.gameplay.modules.sit;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class SitListener implements Listener {
	
	@EventHandler
	public void onPlayerDismount(EntityDismountEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player) {
			Player player = (Player) event.getEntity();
			if (Sit.sittingList.contains(player)) {
				Sit.sittingList.remove(player);
			}
		}
	}

}
