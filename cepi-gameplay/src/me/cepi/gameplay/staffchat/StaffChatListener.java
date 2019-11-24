package me.cepi.gameplay.staffchat;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.cepi.gameplay.Main;

public class StaffChatListener implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		List<Player> staffPlayers = Main.staffChatList;
		
		String message = event.getMessage();
		Player player = event.getPlayer();
		
		if (message.startsWith("#")) {
			event.setCancelled(true);
			message = message.substring(1);
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.hasPermission("cepi.staff"))
					p.sendMessage("§8(§e*§8) §7LeoDog896 §8// §f" + ChatColor.translateAlternateColorCodes('&', message));
		} else if (staffPlayers.contains(player)) {
			event.setCancelled(true);
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.hasPermission("cepi.staff"))
					p.sendMessage("§8(§e*§8) §7LeoDog896 §8// §f" + ChatColor.translateAlternateColorCodes('&', message));
		}
	}

}
