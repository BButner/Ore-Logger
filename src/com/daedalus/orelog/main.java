package com.daedalus.orelog;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin {

    Plugin plugin = this;
    commands cmd = new commands();

    @Override
    public void onEnable() {
        getLogger().info("OreLogger activated!");
        getCommand("ol").setExecutor(new commands());
        plugin.getServer().getPluginManager().registerEvents(new logging(), this);
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("OreLogger disabled!");
    }

}
