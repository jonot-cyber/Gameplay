package me.cepi.gameplay.modules;

import java.util.regex.Pattern;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Speed implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		Pattern pattern = Pattern.compile("\\d+");
		if (label.equalsIgnoreCase("flyspeed")) {
			if (args.length > 0) {
				if (pattern.matcher(args[0]).matches()) {
					if (Float.parseFloat(args[0]) <= 10) {
						player.setFlySpeed(Float.parseFloat(args[0])/10);
						player.sendMessage(Inserts.POSITIVE + "Fly speed set to " + args[0] + "!");
					} else player.sendMessage(Inserts.NEGATIVE + "Usage: /flyspeed <speed 0-10>");
				} else player.sendMessage(Inserts.NEGATIVE + "Usage: /walkspeed <speed 0-5>");
			} else player.sendMessage(Inserts.NEGATIVE + "Usage: /flyspeed <speed 0-10>");
		} else if (label.equalsIgnoreCase("walkspeed")) {
			if (args.length > 0) {
				if (pattern.matcher(args[0]).matches()) {
					if (Float.parseFloat(args[0]) <= 5) {
						player.setWalkSpeed(Float.parseFloat(args[0])/5);
						player.sendMessage(Inserts.POSITIVE + "Walk speed set to " + args[0] + "!");
					} else player.sendMessage(Inserts.NEGATIVE + "Usage: /walkspeed <speed 0-5>");
				} else player.sendMessage(Inserts.NEGATIVE + "Usage: /walkspeed <speed 0-5>");
			} else player.sendMessage(Inserts.NEGATIVE + "Usage: /walkspeed <speed 0-5>");
		} else {
			if (args.length > 0) {
				if (args[0] == "walk") {
					if (args.length > 1) {
						if (pattern.matcher(args[1]).matches()) {
							if (Float.parseFloat(args[0]) <= 5) {
								player.setWalkSpeed(Float.parseFloat(args[1])/5);
								player.sendMessage(Inserts.POSITIVE + "Walk speed set to " + args[1] + "!");
							} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed walk <speed 0-5>");
						} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed walk <speed 0-5>");
					} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed walk <speed 0-5>");
				} else if (args[0] == "fly") {
					if (args.length > 1) {
						if (pattern.matcher(args[1]).matches()) {
							if (Float.parseFloat(args[0]) <= 10) {
								player.setFlySpeed(Float.parseFloat(args[1])/10);
								player.sendMessage(Inserts.POSITIVE + "Fly speed set to " + args[1] + "!");
							} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed fly <speed 0-10>");
						} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed fly <speed 0-10>");
					} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed fly <speed 0-10>");
				} else player.sendMessage(Inserts.NEGATIVE + "Usage: /speed <fly/walk> <speed>");
			}
		}
		return true;
	}

}
