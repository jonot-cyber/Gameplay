package me.cepi.gameplay.modules.economy.shop;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.OneItem;
import me.cepi.gameplay.modules.inserts.InsertComponents;
import me.cepi.gameplay.modules.inserts.Inserts;
import me.cepi.gameplay.modules.menu.Menu;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class ShopCommand implements CommandExecutor {

	public static Map<String, Shop> shops = new HashMap<String, Shop>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.eco")) return false;
		Player player = (Player) sender;
		if (args.length == 0 || (args.length > 0 && args[0] == "help")) {
			player.sendMessage(ChatColor.GRAY + "--- " + ChatColor.GREEN + "Shop Panel" + ChatColor.GRAY + " ---");
			player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop create <name>");
			player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop edit <name>");
			player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop add <name>");
			player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop meta <name>");
			player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop open <name>");
			player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop delete <name>");
		} else if (args.length > 0) {
			if (args[0].equalsIgnoreCase("create")) {
				if (args.length > 1) {
					if (!shops.containsKey(args[1].toLowerCase())) {
						shops.put(args[1].toLowerCase(), new Shop(args[1]));
						TextComponent insert = InsertComponents.POSITIVE();
						
						TextComponent created = new TextComponent();
						created.setColor(ChatColor.GRAY);
						created.setText("Shop Created! Use ");
						insert.addExtra(created);
						
						TextComponent clickableFirst = new TextComponent();
						clickableFirst.setText("/shop edit " + args[1].toLowerCase());
						clickableFirst.setItalic(true);
						clickableFirst.setColor(ChatColor.GREEN);
						clickableFirst.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/shop edit " + args[1].toLowerCase()));
						insert.addExtra(clickableFirst);
						
						TextComponent and = new TextComponent();
						and.setText(" and ");
						and.setColor(ChatColor.GRAY);
						insert.addExtra(and);
						
						TextComponent clickableSecond = new TextComponent();
						clickableSecond.setText("/shop meta " + args[1].toLowerCase());
						clickableSecond.setItalic(true);
						clickableSecond.setColor(ChatColor.GREEN);
						clickableSecond.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/shop meta " + args[1].toLowerCase()));
						insert.addExtra(clickableSecond);
						
						TextComponent ending = new TextComponent();
						ending.setColor(ChatColor.GRAY);
						ending.setText(" to edit it!");
						insert.addExtra(ending);
						
						player.spigot().sendMessage(insert);
						
					} else player.sendMessage(Inserts.NEGATIVE + "That shop already exists!");
				} else player.sendMessage(Inserts.NEGATIVE + "You need an ID to set the Shop to!");
			} else if (args[0].equalsIgnoreCase("edit")) {
				
			} else if (args[0].equalsIgnoreCase("add")) {
				
			} else if (args[0].equalsIgnoreCase("open")) { 
				if (args.length > 1) {
					if (shops.containsKey(args[1].toLowerCase())) {
						player.openInventory(shops.get(args[1].toLowerCase()).compileMenu().toInventory());
					} else player.sendMessage(Inserts.NEGATIVE + "Shop " + args[1].toLowerCase() + " doesn't exist!");
				} else player.sendMessage(Inserts.NEGATIVE + "You need a shop to open!");
			} else if (args[0].equalsIgnoreCase("delete")) { 
				if (args.length > 1) {
					if (shops.containsKey(args[1].toLowerCase())) {
						shops.remove(args[1].toLowerCase());
					} else player.sendMessage(Inserts.NEGATIVE + "Shop " + args[1].toLowerCase() + " doesn't exist!");
				} else player.sendMessage(Inserts.NEGATIVE + "You need a shop to delete!");
			} else if (args[0].equalsIgnoreCase("meta")) {
				if (args.length > 1) {
					if (shops.containsKey(args[1].toLowerCase())) {
						if (args.length == 2 || args[2].equalsIgnoreCase("help")) {
							player.sendMessage(ChatColor.GRAY + "--- " + ChatColor.GREEN + "Meta Panel" + ChatColor.GRAY + " ---");
							player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop meta " + args[1].toLowerCase() + "theme");
							player.sendMessage(ChatColor.GREEN + "- " + ChatColor.GRAY + "/shop meta " + args[1].toLowerCase() + "icon");
						} else if (args.length > 2) {
							if (args[2].equalsIgnoreCase("theme")) {
								Menu menu = new Menu(player, 6, "Theme Picker");
								int index = 0;
								for (ShopColor color : ShopColor.values()) {
									menu.setItem(index, new OneItem(color.getMaterial()).setName(color.getColor() + color.name()).getItem()).onClick(() -> {
										shops.get(args[1].toLowerCase()).setTheme(color);
										player.sendMessage(Inserts.POSITIVE + "Set theme color to " + color.name());
										player.closeInventory();
									}, true);
									index++;
								}
								player.openInventory(menu.toInventory());
							} else if (args[2].equalsIgnoreCase("icon")) {
								
							}
						}
					} else player.sendMessage(Inserts.NEGATIVE + "That shop doesn't exists!");
				} else player.sendMessage(Inserts.NEGATIVE + "You need a shop to edit!");
			} else player.sendMessage(Inserts.NEGATIVE + "Use /adminshop help for help!");
		} else player.sendMessage(Inserts.NEGATIVE + "Use /adminshop help for help!");
		return true;
	}

}
