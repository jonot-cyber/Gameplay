package me.cepi.gameplay.modules.afk;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.cepi.gameplay.Main;

public class AfkListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		List<Player> afkPlayers = Main.afkList;
		Player player = event.getPlayer();
		if (afkPlayers.contains(player)) {
			afkPlayers.remove(player);
			player.sendMessage("§8[§e*§8]§7 You are no longer afk!");
		}
		Main.afkList = afkPlayers;
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		List<Player> afkPlayers = Main.afkList;
		Player player = event.getPlayer();
		if (afkPlayers.contains(player)) {
			afkPlayers.remove(player);
			player.sendMessage("§8[§e*§8]§7 You are no longer afk!");
		}
		Main.afkList = afkPlayers;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		List<Player> afkPlayers = Main.afkList;
		Player player = event.getPlayer();
		if (afkPlayers.contains(player)) {
			afkPlayers.remove(player);
			player.sendMessage("§8[§e*§8]§7 You are no longer afk!");
		}
		Main.afkList = afkPlayers;
	}
}
