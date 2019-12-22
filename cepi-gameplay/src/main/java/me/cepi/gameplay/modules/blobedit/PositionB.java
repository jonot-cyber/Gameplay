package me.cepi.gameplay.modules.blobedit;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class PositionB implements CommandExecutor {
	
	public static Map<Player, Location> pos = new HashMap<Player, Location>();
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (player.getTargetBlockExact(50) != null) {
			pos.put(player, player.getTargetBlockExact(50).getLocation());
			player.sendMessage(Inserts.POSITIVE + "Position B set!");
		} else player.sendMessage(Inserts.NEGATIVE + "Targeted block too far!");
		return true;
	}

}
