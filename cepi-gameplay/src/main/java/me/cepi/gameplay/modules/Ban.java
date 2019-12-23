package me.cepi.gameplay.modules;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.inserts.Inserts;

public class Ban implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		Player player = (Player) sender;
		if (!sender.hasPermission("cepi.mod")) {
			Player target = Bukkit.getPlayer(args[0]);
			if (!(target == null)) {
				String targetname = target.getName();
				String reason = args[1];
				Bukkit.getBanList(Type.NAME).addBan(targetname, reason, null, null);
				target.kickPlayer("Banned");
				player.sendMessage(Inserts.POSITIVE + "Banned " + targetname + " for: " + reason);
			} else {
				player.sendMessage(Inserts.ERROR + "That is not a valid player!");
			}
		} else {
			player.sendMessage(Inserts.ERROR + "You don't permission to do that!");
		}
		return true;
	}
}