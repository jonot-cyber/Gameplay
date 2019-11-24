package me.cepi.gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.gameplay.modules.AntiCropTrample;
import me.cepi.gameplay.modules.ElytraBoost;
import me.cepi.gameplay.modules.ElytraCommand;
import me.cepi.gameplay.modules.FormattedChat;
import me.cepi.gameplay.modules.afk.AfkCommand;
import me.cepi.gameplay.modules.afk.AfkListener;
import me.cepi.gameplay.staffchat.StaffChatCommand;
import me.cepi.gameplay.staffchat.StaffChatListener;

public class Main extends JavaPlugin {
	
	Logger logger = Logger.getLogger("Minecraft");
	public static List<Player> afkList = new ArrayList<>();
	public static List<Player> staffChatList = new ArrayList<>();

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AntiCropTrample(), this);
        getServer().getPluginManager().registerEvents(new ElytraBoost(), this);
        getServer().getPluginManager().registerEvents(new AfkListener(), this);
        getServer().getPluginManager().registerEvents(new FormattedChat(), this);
        getServer().getPluginManager().registerEvents(new StaffChatListener(), this);
        
        this.getCommand("afk").setExecutor(new AfkCommand());
        
        this.getCommand("elytra").setExecutor(new ElytraCommand());
        this.getCommand("ely").setExecutor(new ElytraCommand());
        
        this.getCommand("sc").setExecutor(new StaffChatCommand());
        this.getCommand("staffchat").setExecutor(new StaffChatCommand());
        
        this.logger.info("[Cepi Gameplay] has been Enabledd.");
    }
    
	public void onDisable() {
		this.logger.info("[Cepi Gameplay] has been Disabledd.");
	}
}