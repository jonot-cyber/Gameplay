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
		Menu menu = new Menu(player, 6, "Test Player List");

		ItemStack stack = new ItemStack(Material.BONE);
		menu.setItem(2, stack).onClick(() -> {
			player.sendMessage("click slot");
		});

		player.openInventory(menu.toInventory());
		return true;
	}
}
