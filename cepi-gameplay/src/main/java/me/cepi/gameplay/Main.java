package me.cepi.gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.gameplay.modules.AntiCropTrample;
import me.cepi.gameplay.modules.ConnectionMessages;
import me.cepi.gameplay.modules.Dash;
import me.cepi.gameplay.modules.ElytraBoost;
import me.cepi.gameplay.modules.ElytraCommand;
import me.cepi.gameplay.modules.EnderPearlRider;
import me.cepi.gameplay.modules.FormattedChat;
import me.cepi.gameplay.modules.ServerListPing;
import me.cepi.gameplay.modules.StylishDeath;
import me.cepi.gameplay.modules.afk.AfkCommand;
import me.cepi.gameplay.modules.afk.AfkListener;
import me.cepi.gameplay.modules.spawn.MakeSpawn;
import me.cepi.gameplay.modules.spawn.ToSpawn;
import me.cepi.gameplay.modules.staffchat.StaffChatCommand;
import me.cepi.gameplay.modules.staffchat.StaffChatListener;
// import me.cepi.gameplay.modules.menu.MenuItem;

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
        getServer().getPluginManager().registerEvents(new EnderPearlRider(), this);
        getServer().getPluginManager().registerEvents(new ServerListPing(), this);
        getServer().getPluginManager().registerEvents(new ConnectionMessages(), this);
        getServer().getPluginManager().registerEvents(new StylishDeath(), this);
        getServer().getPluginManager().registerEvents(new Dash(), this);
        // getServer().getPluginManager().registerEvents(new ListInventoryListener(), this);;
        this.getCommand("afk").setExecutor(new AfkCommand());

        this.getCommand("elytra").setExecutor(new ElytraCommand());
        
        this.getCommand("sc").setExecutor(new StaffChatCommand());
        this.getCommand("staffchat").setExecutor(new StaffChatCommand());

        // this.getCommand("list").setExecutor(new ListCommand());
        
        this.getCommand("setspawn").setExecutor(new MakeSpawn());
        Bukkit.broadcastMessage("Hi6");
        this.getCommand("spawn").setExecutor(new ToSpawn());
        
        Bukkit.broadcastMessage("Hi7");
        this.logger.info("[Cepi Gameplay] has been enabled.");
    }

	public void onDisable() {
		this.logger.info("[Cepi Gameplay] has been disabled.");
	}
}