package me.cepi.gameplay.modules.sit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Sit implements CommandExecutor {

	public static List<Player> sittingList = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (sittingList.contains(player)) {
			Entity entity = player.getVehicle();
			player.eject();
			entity.remove();
			player.teleport(entity.getLocation().clone().add(0.0D, 1.7D, 0.0D));
			sittingList.remove(player);
		} else {
			Location location = player.getLocation();
			ArmorStand seat = (ArmorStand) location.getWorld().spawn(location.clone().subtract(0.0D, 1.7D, 0.0D), ArmorStand.class);
			seat.setGravity(false);
			seat.setVisible(false);
			seat.addPassenger(player);
			sittingList.add(player);
		}
		return true;
	}

}
