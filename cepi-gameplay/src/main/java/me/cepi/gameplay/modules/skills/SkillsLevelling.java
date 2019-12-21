package me.cepi.gameplay.modules.skills;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import me.cepi.gameplay.modules.inserts.InsertComponents;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class SkillsLevelling implements Listener {
	
	@EventHandler
	public void onPlayerLevelUp(PlayerLevelChangeEvent event) {
		Player player = event.getPlayer();
		
		if (event.getNewLevel() < event.getOldLevel()) return;
		int levelChange = event.getNewLevel() - event.getOldLevel();
		
		TextComponent insert = InsertComponents.POSITIVE();
		
		TextComponent message = new TextComponent();
		message.setColor(ChatColor.GRAY);
		message.setText("+" + levelChange + "Skill Point" + (levelChange == 1 ? "" : "s") + " ");
		insert.addExtra(message);
		
		TextComponent clickable = new TextComponent();
		clickable.setColor(ChatColor.GREEN);
		clickable.setItalic(true);
		clickable.setText("(/skills)");
		clickable.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/skills"));
		insert.addExtra(clickable);
		
		player.spigot().sendMessage(insert);
		
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
		
	}
	
}
