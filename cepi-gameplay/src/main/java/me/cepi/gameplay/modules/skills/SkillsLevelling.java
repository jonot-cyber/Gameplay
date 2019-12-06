package me.cepi.gameplay.modules.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class SkillsLevelling implements Listener {
	
	@EventHandler
	public void onPlayerLevelUp(PlayerLevelChangeEvent event) {
		Player player = event.getPlayer();
		
		if (event.getNewLevel() < event.getOldLevel()) return;
		int levelChange = event.getNewLevel() - event.getOldLevel();
		
	}
	
}
