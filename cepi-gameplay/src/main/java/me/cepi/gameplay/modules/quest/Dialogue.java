package me.cepi.gameplay.modules.quest;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.cepi.gameplay.modules.util.Pair;

public class Dialogue {

	private Map<String, Pair<Integer, String>> dialogue = new HashMap<String, Pair<Integer, String>>();
	private String sender;

	public Dialogue(String sender) {
		this.sender = sender;
	}

	public void putMessage(String message, Integer afterDelay) {
		Pair<Integer, String> pair = new Pair<>();
		pair.set(afterDelay, sender);
		dialogue.put(message, pair);
	}

	public void send(Player player) {
		Integer max = dialogue.size();
		Integer index = 1;
		for (Map.Entry<String, Pair<Integer, String>> entry : dialogue.entrySet()) {
			player.sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.YELLOW + index + "/" + max + ChatColor.DARK_GRAY + ") " + ChatColor.GOLD + entry.getValue().getSecond() + " " + entry.getKey());
			index++;
		}
	}

}
