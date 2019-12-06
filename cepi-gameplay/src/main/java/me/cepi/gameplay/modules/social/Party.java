package me.cepi.gameplay.modules.social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.Inserts;
import net.md_5.bungee.api.ChatColor;

public class Party implements CommandExecutor {

	public static List<Player> isInParty = new ArrayList<>();
	public static Map<Player, Player> partyOwner = new HashMap<Player, Player>();
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		if (isInParty.contains(player)) {
			// TODO
		} else if (args.length > 0) {
			if (args[0] == "create") {
				isInParty.add(player);
				partyOwner.put(player, player);
				player.sendMessage(Inserts.POSITIVE + "Party created! Do \"/party help\" for help!");
			} else if (args[0] == "join") {
				
			}
		} else {
			player.sendMessage(Inserts.NEGATIVE + "You aren't in a party!");
			player.sendMessage(ChatColor.BLUE + "- Create one with /party create, ");
			player.sendMessage(ChatColor.BLUE + "- or join one with /party join <player>");
			// TODO make commands clickable
		}
 		return true;
	}
}
