package me.cepi.gameplay;

import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.gameplay.modules.AntiCropTrample;


public class Main extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AntiCropTrample(), this);
    }
}