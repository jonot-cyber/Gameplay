package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.*;

public class FormattedChat implements Listener {

	static String getPrefix(Player p) {
		if (Bukkit.getServer().getPluginManager().getPlugin("LuckPerms") == null) {
			return "";
		}
		final LuckPermsApi lpAPI = LuckPerms.getApi();
		User user = lpAPI.getUser(p.getUniqueId());
		Contexts userCtx = lpAPI.getContextForUser(user).orElseThrow(() -> new IllegalStateException("Could not get LuckPerms context for player " + p));
		return user.getCachedData().getMetaData(userCtx).getPrefix();
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		Player player = event.getPlayer();

		message = message.replaceAll(":flower:", "✿")
						 .replaceAll(":smile:", "☺")
						 .replaceAll(":heart:", "❤")
						 .replaceAll(":peace:", "☮")
						 .replaceAll(":no:", "✖")
						 .replaceAll(":cloud:", "☁")
						 .replaceAll(":skull:", "☠");

		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (message.contains(p.getDisplayName())) {
				message = message.replaceAll(p.getDisplayName(), ChatColor.YELLOW + p.getDisplayName() + "§r");
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
			}
		}

		if (message.contains("@everyone")) {
			message = message.replaceAll("@everyone", ChatColor.YELLOW + "@everyone" + ChatColor.RESET);
			for (Player p : Bukkit.getServer().getOnlinePlayers())
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
		}

		if (player.hasPermission("cepi.staff")) {
			message = ChatColor.translateAlternateColorCodes('&', message);
		}

		event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY
		+ player.getLevel()
		+ ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " "
		// + ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(player).getPrefix()) // pex is a mess, we need to stop using it asap
		+ ChatColor.translateAlternateColorCodes('&', getPrefix(player))
		+ player.getDisplayName()
		+ ChatColor.DARK_GRAY + ": " + ChatColor.RESET
		+ message);
	}
}
