package me.cepi.gameplay.modules.blobedit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Fill implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (PositionA.pos.containsKey(player)) {
			if (PositionB.pos.containsKey(player)) {
				
			} else player.sendMessage(Inserts.NEGATIVE + "Position B not set!");
		} else player.sendMessage(Inserts.NEGATIVE + "Position A not set!");
		return true;
	}

}
