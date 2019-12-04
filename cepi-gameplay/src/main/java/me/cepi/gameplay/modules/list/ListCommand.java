package me.cepi.gameplay.modules.list;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.cepi.gameplay.modules.menu.Menu;

public class ListCommand implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		// Inventory inv = Bukkit.createInventory(null, 54, "Player List");

		Menu menu = new Menu(player, 6, "Test Player List");

		ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
		menu.setItem(2, stack).onClick(() -> {
			player.sendMessage("click slot");
		});

		player.openInventory(menu.toInventory());
			
		// int index = 0;
		// for (Player p : Bukkit.getOnlinePlayers()) {
		// 	ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
	    //     SkullMeta meta = (SkullMeta) stack.getItemMeta();
	    //     meta.setOwningPlayer(p);
	    //     meta.setDisplayName(ChatColor.RESET + FormattedChat.getPrefix(p) + p.getDisplayName());
		// 	stack.setItemMeta(meta);
			
	    //     menu.setItem(index, stack).onClick(() -> {
		// 		player.sendMessage("click slot");
		// 	});
	    //     index++;
		// }

		
		return true;
	}
}
