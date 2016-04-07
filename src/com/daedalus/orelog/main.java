package com.daedalus.orelog;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class Main extends JavaPlugin {
    Plugin plugin = this;

    @Override
    public void onEnable() {
        getLogger().info("OreLogger activated!");
        getCommand("ol").setExecutor(new Commands());

        File playerFolder = new File(Bukkit.getPluginManager().getPlugin("OreLogger").getDataFolder() + "/Player Logs");

        plugin.getServer().getPluginManager().registerEvents(new Logging(), this);
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        if (!playerFolder.exists()) {
            playerFolder.mkdir();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("OreLogger disabled!");
    }
}
