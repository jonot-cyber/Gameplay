package me.cepi.gameplay.modules;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ElytraCommand implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		player.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
		Location loc = player.getLocation();
		loc.setY(loc.getY() + 50);
		player.teleport(loc);
		player.setGliding(true);
		player.sendMessage("§8[§a*§8]§7 Fly!");
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 2);
		return true;
	}

}
