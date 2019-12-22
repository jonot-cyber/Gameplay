package me.cepi.gameplay.modules.economy;

import java.util.regex.Pattern;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class EcoAdmin implements CommandExecutor {

	private TextComponent generateHelp(String commandText, String descriptionText, String suggestionText) {
		TextComponent command = new TextComponent();
		command.setColor(ChatColor.GREEN);
		command.setItalic(true);
		command.setText(commandText);
		command.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, suggestionText));
		
		TextComponent description = new TextComponent();
		description.setColor(ChatColor.GRAY);
		description.setText(" - " + descriptionText);
		command.addExtra(description);
		
		return command;
	}
	
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String numCheck = "^\\d+$";
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.eco")) return false;
		Player player = (Player) sender;
		if (args.length == 0) {
			player.spigot().sendMessage(generateHelp("/eco give <money> [<player>]", "Gives a player money", "/eco give"));
		} else {
			if (args[0].equalsIgnoreCase("give") && args.length > 1) {
				if (Pattern.matches(numCheck, args[1]))
					Currency.integerToItems((int) Double.parseDouble(args[1])).forEach(item -> {
						if (player.getInventory().firstEmpty() == -1) 
							player.getWorld().dropItem(player.getLocation(), item);
						else
							player.getInventory().addItem(item);
					});
				else
					player.sendMessage(Inserts.ERROR + "Type in a valid number.");
			} else if(args[0].equalsIgnoreCase("remove")) {
				if (args.length > 1) {
					
				} else player.sendMessage(Inserts.ERROR + "Type in a valid number.");
			}
		}
		return true;
		
	}
}
