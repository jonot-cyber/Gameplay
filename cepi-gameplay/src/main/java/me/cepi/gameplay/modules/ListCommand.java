package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.cepi.gameplay.modules.menu.Menu;
import net.md_5.bungee.api.ChatColor;

public class ListCommand implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		Menu menu = new Menu(player, 6, "Test Player List");

		int num = 0;
		for (Player p : Bukkit.getOnlinePlayers()) {
			ItemStack head = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta headMeta = (SkullMeta) head.getItemMeta();
			headMeta.setOwningPlayer(p);
			headMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FormattedChat.getPrefix(p)) + ChatColor.YELLOW + p.getDisplayName());
			head.setItemMeta(headMeta);
			menu.setItem(num, head).onClick(true);
			num++;
		}

		player.openInventory(menu.toInventory());
		return true;
	}
}
