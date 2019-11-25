package me.cepi.gameplay.modules;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionMessages implements Listener {
	
	/* 
	 * Note -- Empty string at beginning is to prevent type adding errors.
	 * */
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("" + ChatColor.GREEN + ChatColor.BOLD + "JOIN " + ChatColor.RESET + ChatColor.GRAY + player.getDisplayName());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage("" + ChatColor.RED + ChatColor.BOLD + "QUIT " + ChatColor.RESET + ChatColor.GRAY + player.getDisplayName());
	}


}
