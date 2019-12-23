package me.cepi.gameplay.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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

public class Warp implements CommandExecutor {

	public static Map<String, Location> warps = new HashMap<String, Location>();
	
	public static Map<String, Location> readWarps() {
		File dir = new File(Bukkit.getPluginManager().getPlugin("cepi-gameplay").getDataFolder(), "warps");
		dir.mkdirs();
		for (File file : dir.listFiles()) {
			Location loc = new Location(null, 0, 0, 0, 0, 0);
			try {
				Scanner sc = new Scanner(file);
				sc.useDelimiter("\r");
				int index = 0;
				while (sc.hasNextLine()) {
					String str = sc.nextLine();
					if (index == 0) loc.setX(Integer.parseInt(str));
					if (index == 1) loc.setY(Integer.parseInt(str));
					if (index == 2) loc.setZ(Integer.parseInt(str));
					if (index == 3) loc.setPitch(Float.parseFloat(str));
					if (index == 4) loc.setYaw(Float.parseFloat(str));
					if (index == 5) loc.setWorld(Bukkit.getWorld(str));;
					index++;
				}
				sc.close();
				warps.put(file.getName().substring(0, file.getName().length() - 4), loc);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return warps;
	}
	
	public static void registerWarps() {
		File dir = new File(Bukkit.getPluginManager().getPlugin("cepi-gameplay").getDataFolder(), "warps");
		dir.mkdirs();
		warps.forEach((k, v) -> {
			File file = new File(dir, k + ".txt");
			try {
				if (!file.exists()) file.createNewFile();
				FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
			    fileWriter.write(v.getBlockX() + "\r"
			    	+ v.getBlockY() + "\r"
			    	+ v.getBlockZ() + "\r"
			    	+ v.getPitch() + "\r"
			    	+ v.getYaw() + "\r"
			    	+ v.getWorld().getName());
			    fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		if (!sender.hasPermission("cepi.builder")) return false;
		if (args.length > 0) args[0] = args[0].toLowerCase();
		if (label.equalsIgnoreCase("warps")) {
			player.sendMessage(ChatColor.GREEN + "--" + ChatColor.GRAY + " Warps " + ChatColor.GREEN + "--");
			warps.forEach((k, v) -> {
				TextComponent tick = new TextComponent();
				tick.setColor(ChatColor.GRAY);
				tick.setText("- ");
				
				TextComponent clickableWarp = new TextComponent();
				clickableWarp.setColor(ChatColor.BLUE);
				clickableWarp.setItalic(true);
				clickableWarp.setText(k);
				clickableWarp.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/warp " + k));
				tick.addExtra(clickableWarp);
				player.spigot().sendMessage(tick);
			});
			player.sendMessage(ChatColor.GREEN + "-----------");
		} else if (label.equalsIgnoreCase("warp")) {
			if (args.length > 0) {
				if (warps.containsKey(args[0])) {
					Back.back.put(player, player.getLocation());
					player.teleport(warps.get(args[0]));
					player.sendMessage(Inserts.POSITIVE + "Teleported to " + ChatColor.YELLOW + args[0] + ChatColor.GRAY + "!");
				} else player.sendMessage(Inserts.NEGATIVE + "This warp doesn't exist!");
			} else player.sendMessage(Inserts.NEGATIVE + "You need somewhere to warp to!");
		} else if (label.equalsIgnoreCase("setwarp")) {
			if (args.length > 0) {
				warps.put(args[0], player.getLocation());
				player.sendMessage(Inserts.POSITIVE + "Warp " + ChatColor.YELLOW + args[0] + ChatColor.GRAY + " set!");
				registerWarps();
			} else player.sendMessage(Inserts.NEGATIVE + "You need a warp to set!");
		} else if (label.equalsIgnoreCase("delwarp") || label.equalsIgnoreCase("deletewarp")) {
			if (args.length > 0) {
				if (warps.containsKey(args[0])) {
					warps.remove(args[0]);
					player.sendMessage(Inserts.POSITIVE + "Deleted warp " + ChatColor.YELLOW + args[0] + ChatColor.GRAY + "!");
					registerWarps();
				} else player.sendMessage(Inserts.NEGATIVE + "This warp doesn't exist!");
			} else player.sendMessage(Inserts.NEGATIVE + "You need a warp to delete!");
		}
		return true;
	}
}
