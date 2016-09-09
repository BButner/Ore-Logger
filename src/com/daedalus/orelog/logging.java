package com.daedalus.orelog;

import org.bukkit.Bukkit;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging {
    public void createLog(String playerName, String oreBlock, int lightLevel, int x, int y, int z) throws IOException {
        File logFile = new File(Bukkit.getPluginManager().getPlugin("OreLogger").getDataFolder() + "/Player Logs/" + playerName);

        if (!logFile.exists()) {
            logFile.mkdir();
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFile + File.separator + oreBlock + ".txt", true)));

        out.println(playerName + " mined " + oreBlock + " at lightlevel " + lightLevel + " @ x" + x + " y" + y + " z" + z + ".");
        out.close();
    }

    public void entityLog(String entity) throws IOException {
        File entityFile = new File(Bukkit.getPluginManager().getPlugin("OreLogger").getDataFolder() + "/Entities/");

        if (!entityFile.exists()) {
            entityFile.mkdir();
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(entityFile + File.separator + "Entities.txt", true)));

        out.println(entity);
        out.close();
    }

    private String currentDate() {
        SimpleDateFormat curDate = new SimpleDateFormat("[dd-MM | HH:mm:ss]");
        Date now = new Date();
        return curDate.format(now);
    }
}
