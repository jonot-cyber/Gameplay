package me.cepi.gameplay.modules.afk;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.Main;

public class AfkCommand implements CommandExecutor {
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		List<Player> afkPlayers = Main.afkList;
		
		if (afkPlayers.contains(player)) {
			afkPlayers.remove(player);
			player.sendMessage("§8[§e*§8]§7 You are no longer afk!");
		} else {
			afkPlayers.add(player);
			player.sendMessage("§8[§e*§8]§7 You are now afk!");
		}
		
		Main.afkList = afkPlayers;
        return true;
    }
}
