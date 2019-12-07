package me.cepi.gameplay.modules.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import me.cepi.gameplay.modules.inserts.InsertComponents;
import net.md_5.bungee.api.chat.TextComponent;

public class SkillsLevelling implements Listener {
	
	@EventHandler
	public void onPlayerLevelUp(PlayerLevelChangeEvent event) {
		Player player = event.getPlayer();
		
		if (event.getNewLevel() < event.getOldLevel()) return;
		int levelChange = event.getNewLevel() - event.getOldLevel();
		
		TextComponent insert = InsertComponents.POSITIVE();
		
	}
	
}
