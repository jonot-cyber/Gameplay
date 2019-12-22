package me.cepi.gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.gameplay.modules.AntiCropTrample;
import me.cepi.gameplay.modules.AntiGrief;
import me.cepi.gameplay.modules.BuildWorld;
import me.cepi.gameplay.modules.ConnectionMessages;
import me.cepi.gameplay.modules.CreativeBuilder;
import me.cepi.gameplay.modules.Dash;
import me.cepi.gameplay.modules.DiscordInfo;
import me.cepi.gameplay.modules.ElytraBoost;
import me.cepi.gameplay.modules.ElytraCommand;
import me.cepi.gameplay.modules.EnderPearlRider;
import me.cepi.gameplay.modules.FlyCommand;
import me.cepi.gameplay.modules.FormattedChat;
import me.cepi.gameplay.modules.Gamemode;
import me.cepi.gameplay.modules.GiveSkull;
import me.cepi.gameplay.modules.ListCommand;
import me.cepi.gameplay.modules.NightVision;
import me.cepi.gameplay.modules.ServerListPing;
import me.cepi.gameplay.modules.Speed;
import me.cepi.gameplay.modules.Status;
import me.cepi.gameplay.modules.StylishDeath;
import me.cepi.gameplay.modules.Top;
import me.cepi.gameplay.modules.Warp;
import me.cepi.gameplay.modules.afk.AfkCommand;
import me.cepi.gameplay.modules.afk.AfkListener;
import me.cepi.gameplay.modules.economy.Balance;
import me.cepi.gameplay.modules.economy.EcoAdmin;
import me.cepi.gameplay.modules.itemediting.SimpleRename;
import me.cepi.gameplay.modules.skills.SkillsLevelling;
import me.cepi.gameplay.modules.social.Friends;
import me.cepi.gameplay.modules.social.Party;
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
        getServer().getPluginManager().registerEvents(new CreativeBuilder(), this);
        getServer().getPluginManager().registerEvents(new SkillsLevelling(), this);
        getServer().getPluginManager().registerEvents(new AntiGrief(), this);
        
        this.getCommand("afk").setExecutor(new AfkCommand());

        this.getCommand("elytra").setExecutor(new ElytraCommand());
        
        this.getCommand("sc").setExecutor(new StaffChatCommand());
        this.getCommand("staffchat").setExecutor(new StaffChatCommand());

        this.getCommand("list").setExecutor(new ListCommand());
        
        this.getCommand("setspawn").setExecutor(new MakeSpawn());
        this.getCommand("spawn").setExecutor(new ToSpawn());
        
        this.getCommand("discord").setExecutor(new DiscordInfo());
        
        this.getCommand("rename").setExecutor(new SimpleRename());
        
        this.getCommand("party").setExecutor(new Party());
        
        this.getCommand("friends").setExecutor(new Friends());
        this.getCommand("friend").setExecutor(new Friends());
        
        this.getCommand("serverstatus").setExecutor(new Status());
        
        this.getCommand("eco").setExecutor(new EcoAdmin());

        this.getCommand("bal").setExecutor(new Balance());
        this.getCommand("balance").setExecutor(new Balance());
        
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("gms").setExecutor(new Gamemode());
        this.getCommand("gmsp").setExecutor(new Gamemode());
        this.getCommand("gmc").setExecutor(new Gamemode());
        this.getCommand("gma").setExecutor(new Gamemode());
        
        this.getCommand("top").setExecutor(new Top());
        
        this.getCommand("flyspeed").setExecutor(new Speed());
        this.getCommand("walkspeed").setExecutor(new Speed());
        this.getCommand("speed").setExecutor(new Speed());
        
        this.getCommand("skull").setExecutor(new GiveSkull());
        
        this.getCommand("fly").setExecutor(new FlyCommand());
        
        this.getCommand("nv").setExecutor(new NightVision());
        this.getCommand("nightvision").setExecutor(new NightVision());
        
        this.getCommand("warp").setExecutor(new Warp());
        this.getCommand("warps").setExecutor(new Warp());
        this.getCommand("setwarp").setExecutor(new Warp());
        this.getCommand("delwarp").setExecutor(new Warp());
        this.getCommand("deletewarp").setExecutor(new Warp());
        this.getCommand("buildworld").setExecutor(new BuildWorld());
		Warp.readWarps();
        
        this.logger.info("[Cepi Gameplay] has been enabled.");
    }

	public void onDisable() {
		this.logger.info("[Cepi Gameplay] has been disabled.");
	}
}