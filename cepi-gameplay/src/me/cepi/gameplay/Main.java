package me.cepi.gameplay;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.gameplay.modules.AntiCropTrample;
import me.cepi.gameplay.modules.ElytraBoost;

public class Main extends JavaPlugin {
	
	Logger logger = Logger.getLogger("Minecraft");

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AntiCropTrample(), this);
        getServer().getPluginManager().registerEvents(new ElytraBoost(), this);
        this.logger.info("[Cepi Gameplay] has been Enabledd.");
    }
    
	public void onDisable() {
		this.logger.info("[Cepi Gameplay] has been Disabledd.");
	}
}