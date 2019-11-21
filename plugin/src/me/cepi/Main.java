package me.cepi;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.events.AntiCropTrample;
import me.cepi.web.FileUtils;
import me.cepi.web.WebBukkit;

public class Main extends JavaPlugin {
    private static final File WEBSITE_FOLDER = new File("website");


    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AntiCropTrample(), this);

        getConfig().options().copyDefaults(true);
        saveConfig();
        FileUtils.createFolderIfNecessary(WEBSITE_FOLDER);
        FileUtils.getWebsiteHome();
        FileUtils.getWebsite404();
        try {
            WebBukkit.getInstance().start(getConfig().getInt("port"));
        } catch (Exception e) {
            getLogger().info("Failed to start website.");
        }
    }
}