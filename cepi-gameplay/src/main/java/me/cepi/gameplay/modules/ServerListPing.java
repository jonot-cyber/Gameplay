package me.cepi.gameplay.modules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {
	@EventHandler
	public void onServerListPing(ServerListPingEvent event) {
		event.setMaxPlayers(100);
	}
}
