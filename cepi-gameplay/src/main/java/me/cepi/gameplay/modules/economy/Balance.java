package me.cepi.gameplay.modules.economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Balance implements CommandExecutor {

	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		player.sendMessage(Inserts.NEUTRAL + "Money: " + Currency.inventoryToMoney(player.getInventory()));
		return true;
	}
		
}
