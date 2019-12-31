package me.cepi.gameplay.modules;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.Main;
import me.cepi.gameplay.modules.inserts.Inserts;
import net.md_5.bungee.api.ChatColor;

public class Status implements CommandExecutor {
	
	private long getFolderSize(File folder) {
	    long length = 0;
	    File[] files = folder.listFiles();
	    int count = files.length;
	    for (int i = 0; i < count; i++) {
	        if (files[i].isFile())
	            length += files[i].length();
	        else
	            length += getFolderSize(files[i]);
	    }
	    return length;
	}

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.debug")) return false;
		Player player = (Player) sender;
		player.sendMessage(ChatColor.GRAY + "------ " + ChatColor.GREEN + "Status" + ChatColor.GRAY + " ------");
		double maxMem = Math.floor(Runtime.getRuntime().maxMemory() / 1048576);
		double minMem = Math.floor((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / 1048576);
		player.sendMessage(Inserts.NEUTRAL + "Memory: " + ChatColor.BLUE + minMem + "mb / " + maxMem + "mb");
		
		long minStorage = getFolderSize(Main.getPlugin(Main.class).getServer().getWorldContainer()) / 1048576;
		long maxStorage = Main.getPlugin(Main.class).getServer().getWorldContainer().getFreeSpace() / 1048576;
		player.sendMessage(Inserts.NEUTRAL + "Storage: " + ChatColor.BLUE + minStorage + "mb / " + maxStorage + "mb");
		player.sendMessage(ChatColor.GRAY + "------ " + ChatColor.GREEN + "======" + ChatColor.GRAY + "------");
		return true;
	}
	
}
