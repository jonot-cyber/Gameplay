package me.cepi.gameplay.modules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BuildWorld implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		String cslcmd = "mvtp " + player.getDisplayName() + " builds";
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cslcmd);
		return true;
	}
}
