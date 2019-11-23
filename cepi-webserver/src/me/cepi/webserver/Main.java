package me.cepi.webserver;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import me.cepi.webserver.web.FileUtils;
import me.cepi.webserver.web.WebBukkit;

public class Main extends JavaPlugin {
    private static final File WEBSITE_FOLDER = new File("website");


    public void onEnable() {
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