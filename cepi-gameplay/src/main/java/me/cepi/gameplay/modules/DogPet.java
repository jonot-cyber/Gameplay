package me.cepi.gameplay.modules;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DogPet implements Listener {
	
	private static final Material[] acceptableItems = new Material[] {
			Material.ROTTEN_FLESH,
			Material.COOKED_BEEF,
			Material.COOKED_CHICKEN,
			Material.COOKED_COD,
			Material.COOKED_MUTTON,
			Material.COOKED_PORKCHOP,
			Material.COOKED_RABBIT,
			Material.COOKED_SALMON
	};

	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent event) {
		if (event.getRightClicked().getType() == EntityType.WOLF) {
			event.setCancelled(true);
			Wolf wolf = (Wolf) event.getRightClicked();
			Player player = event.getPlayer();
			if (wolf.isTamed()) {
				for (Material material : acceptableItems) {
					if (material == player.getInventory().getItemInMainHand().getType()) {
						double maxhp = wolf.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
						if (wolf.getHealth() == maxhp) break;
						else if (wolf.getHealth() + 4 > maxhp) wolf.setHealth(maxhp);
						else wolf.setHealth(wolf.getHealth() + 4);
						ItemStack item = player.getInventory().getItemInMainHand();
						item.setAmount(item.getAmount() - 1);
						player.getInventory().setItemInMainHand(item);
						break;
					}
				}
			}
			Location loc = wolf.getLocation();
			loc.getWorld().playSound(loc, Sound.ENTITY_WOLF_AMBIENT, 2, 1);
			wolf.playEffect(EntityEffect.LOVE_HEARTS);
		}
	}

}
