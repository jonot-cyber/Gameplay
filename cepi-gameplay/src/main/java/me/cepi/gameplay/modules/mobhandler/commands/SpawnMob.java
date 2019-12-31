package me.cepi.gameplay.modules.mobhandler.commands;

import java.io.File;
import java.io.FileNotFoundException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import me.cepi.gameplay.Main;
import me.cepi.gameplay.modules.inserts.Inserts;
import me.cepi.gameplay.modules.mobhandler.SpawnableMob;

public class SpawnMob implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		String path = Main.getPlugin(Main.class).getServer().getWorldContainer().getAbsolutePath();
		path = path.substring(0, path.length() - 1) + "mobs\\" + args[0] + ".json";
		File file = new File(path);
		SpawnableMob mob;
		try {
			mob = SpawnableMob.fromJson(file);
			mob.spawnMob(player.getLocation());
		} catch (JsonSyntaxException e) {
			player.sendMessage(Inserts.NEGATIVE + "JSON cannot be parsed.");
		} catch (JsonIOException e) {
			player.sendMessage(Inserts.NEGATIVE + "JSON cannot be parsed.");
		} catch (FileNotFoundException e) {
			player.sendMessage(Inserts.NEGATIVE + "That file doesn't exist!");
		} catch (NullPointerException e) {
			player.sendMessage(Inserts.NEGATIVE + "An internal unidentified error has occured :(");
			e.printStackTrace();
		}
		return true;
	}

}
