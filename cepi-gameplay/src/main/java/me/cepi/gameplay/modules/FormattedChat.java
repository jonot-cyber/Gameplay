package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

// import ru.tehkode.permissions.bukkit.PermissionsEx;

public class FormattedChat implements Listener {
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		Player player = event.getPlayer();
		message = message.replaceAll(":shrug:", "¯\\_(ツ)_/¯")
				.replaceAll(":flower:", "✿")
				.replaceAll(":smile:", "☺")
				.replaceAll(":peace:", "☮")
				.replaceAll(":heart:", "❤")
				.replaceAll(":cloud:", "☁")
				.replaceAll(":no:", "✖")
				.replaceAll(":skull:", "☠");

		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (message.contains(p.getDisplayName())) {
				message = message.replaceAll(p.getDisplayName(), "§e@" + p.getDisplayName() + "§r");
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
			}
		}

		if (message.contains("@everyone")) {
			message = message.replaceAll("@everyone", "§e@everyone§r");
			for (Player p : Bukkit.getServer().getOnlinePlayers())
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
		}

		if (player.hasPermission("cepi.staff"))
			message = ChatColor.translateAlternateColorCodes('&', message);

		event.setFormat("§8[§7"
		+ player.getLevel()
		+ "§8]§r "
		// + ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(player).getPrefix()) // pex is a mess, we need to stop using it asap
		+ player.getDisplayName()
		+ "§8: §f"
		+ message);
	}
}
