package me.cepi.gameplay.modules;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionMessages implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(Inserts.POSITIVE + player.getDisplayName() + "joined!");
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage(Inserts.NEGATIVE + player.getDisplayName() + "left!");
	}


}
