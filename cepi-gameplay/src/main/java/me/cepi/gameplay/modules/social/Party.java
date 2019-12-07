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

import me.cepi.gameplay.modules.inserts.InsertComponents;
import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

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
			
			TextComponent insert = InsertComponents.NEUTRAL();
			
			TextComponent create = new TextComponent();
			create.setColor(ChatColor.GRAY);
			create.setText("Create one with ");
			insert.addExtra(create);
			
			TextComponent clickableCreation = new TextComponent();
			clickableCreation.setColor(ChatColor.GREEN);
			clickableCreation.setItalic(true);
			clickableCreation.setText("/party create");
			clickableCreation.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/party create"));
			insert.addExtra(clickableCreation);
			
			TextComponent insertJoin = InsertComponents.NEUTRAL();
			
			TextComponent join = new TextComponent();
			join.setColor(ChatColor.GRAY);
			join.setText("or join one with ");
			insertJoin.addExtra(join);
			
			TextComponent clickableJoining = new TextComponent();
			clickableJoining.setColor(ChatColor.GREEN);
			clickableJoining.setItalic(true);
			clickableJoining.setText("/party join");
			clickableJoining.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/party join"));
			insertJoin.addExtra(clickableJoining);
			
			player.spigot().sendMessage(insert);
			player.spigot().sendMessage(insertJoin);
		}
 		return true;
	}
}
