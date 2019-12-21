package me.cepi.gameplay.modules;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CreativeBuilder implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission("cepi.builder")) player.setGameMode(GameMode.CREATIVE);
		else player.setGameMode(GameMode.ADVENTURE);
	}

}
