package me.cepi.gameplay.modules;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class DiscordInfo implements CommandExecutor {

	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		TextComponent prefix = new TextComponent();
		prefix.setColor(ChatColor.BLUE);
		prefix.setText("Discord:");
		
		TextComponent transition = new TextComponent();
		transition.setColor(ChatColor.DARK_GRAY);
		transition.setText(" >> ");
		prefix.addExtra(transition);
		
		TextComponent clickableText = new TextComponent();
		clickableText.setColor(ChatColor.GRAY);
		clickableText.setUnderlined(true);
		clickableText.setItalic(true);
		clickableText.setText("Click Here!");
		clickableText.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://discordapp.com/invite/cnz52Cm"));
		prefix.addExtra(clickableText);
		
		player.spigot().sendMessage(prefix);
		return true;
	}
}
