package me.cepi.gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.gameplay.modules.AntiCropTrample;
import me.cepi.gameplay.modules.AntiGrief;
import me.cepi.gameplay.modules.Back;
import me.cepi.gameplay.modules.ConnectionMessages;
import me.cepi.gameplay.modules.CreativeBuilder;
import me.cepi.gameplay.modules.Dash;
import me.cepi.gameplay.modules.DiscordInfo;
import me.cepi.gameplay.modules.DogPet;
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
import me.cepi.gameplay.modules.TeleportCommand;
import me.cepi.gameplay.modules.Top;
import me.cepi.gameplay.modules.TphereCommand;
import me.cepi.gameplay.modules.Warp;
import me.cepi.gameplay.modules.afk.AfkCommand;
import me.cepi.gameplay.modules.afk.AfkListener;
import me.cepi.gameplay.modules.economy.Balance;
import me.cepi.gameplay.modules.economy.EcoAdmin;
import me.cepi.gameplay.modules.economy.shop.ShopCommand;
import me.cepi.gameplay.modules.elytra.ElytraBoost;
import me.cepi.gameplay.modules.elytra.ElytraCommand;
import me.cepi.gameplay.modules.itemcrafting.WeaponBench;
import me.cepi.gameplay.modules.itemediting.SimpleRename;
import me.cepi.gameplay.modules.itemhandler.commands.GiveItem;
import me.cepi.gameplay.modules.mobhandler.commands.SpawnMob;
import me.cepi.gameplay.modules.moderation.Ban;
import me.cepi.gameplay.modules.moderation.Kick;
import me.cepi.gameplay.modules.sit.Sit;
import me.cepi.gameplay.modules.sit.SitListener;
import me.cepi.gameplay.modules.skills.SkillsLevelling;
import me.cepi.gameplay.modules.social.Friends;
import me.cepi.gameplay.modules.social.Party;
import me.cepi.gameplay.modules.social.messaging.MessageSystem;
import me.cepi.gameplay.modules.social.messaging.Reply;
import me.cepi.gameplay.modules.spawn.MakeSpawn;
import me.cepi.gameplay.modules.spawn.ToSpawn;
import me.cepi.gameplay.modules.staffchat.StaffChatCommand;
import me.cepi.gameplay.modules.staffchat.StaffChatListener;
// import me.cepi.gameplay.modules.menu.MenuItem;
/*why did the java program need glasses? Because he couldn't c#*/
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
        getServer().getPluginManager().registerEvents(new WeaponBench(), this);
        getServer().getPluginManager().registerEvents(new SitListener(), this);
        getServer().getPluginManager().registerEvents(new DogPet(), this);
        
        getCommand("ban").setExecutor(new Ban());
        
        getCommand("back").setExecutor(new Back());

        getCommand("r").setExecutor(new Reply());

        getCommand("msg").setExecutor(new MessageSystem());

        getCommand("tphere").setExecutor(new TphereCommand());

        getCommand("tp").setExecutor(new TeleportCommand());

        getCommand("afk").setExecutor(new AfkCommand());

        getCommand("elytra").setExecutor(new ElytraCommand());

        getCommand("sc").setExecutor(new StaffChatCommand());
        getCommand("staffchat").setExecutor(new StaffChatCommand());

        getCommand("list").setExecutor(new ListCommand());

        getCommand("setspawn").setExecutor(new MakeSpawn());
        getCommand("spawn").setExecutor(new ToSpawn());

        getCommand("discord").setExecutor(new DiscordInfo());

        getCommand("rename").setExecutor(new SimpleRename());

        getCommand("party").setExecutor(new Party());

        getCommand("friends").setExecutor(new Friends());
        getCommand("friend").setExecutor(new Friends());

        getCommand("serverstatus").setExecutor(new Status());

        getCommand("eco").setExecutor(new EcoAdmin());

        getCommand("bal").setExecutor(new Balance());
        getCommand("balance").setExecutor(new Balance());

        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gma").setExecutor(new Gamemode());

        getCommand("top").setExecutor(new Top());

        getCommand("flyspeed").setExecutor(new Speed());
        getCommand("walkspeed").setExecutor(new Speed());
        getCommand("speed").setExecutor(new Speed());

        getCommand("skull").setExecutor(new GiveSkull());

        getCommand("fly").setExecutor(new FlyCommand());

        getCommand("nv").setExecutor(new NightVision());
        getCommand("nightvision").setExecutor(new NightVision());

        getCommand("warp").setExecutor(new Warp());
        getCommand("warps").setExecutor(new Warp());
        getCommand("setwarp").setExecutor(new Warp());
        getCommand("delwarp").setExecutor(new Warp());
        getCommand("deletewarp").setExecutor(new Warp());

        getCommand("kick").setExecutor(new Kick());
        
        getCommand("shop").setExecutor(new ShopCommand());
        
        getCommand("sit").setExecutor(new Sit());
        
        getCommand("spawnmob").setExecutor(new SpawnMob());
        
        getCommand("giveitem").setExecutor(new GiveItem());
		Warp.readWarps();

        this.logger.info("[Cepi Gameplay] has been enabled.");
    }

	public void onDisable() {
		this.logger.info("[Cepi Gameplay] has been disabled.");
	}
}
