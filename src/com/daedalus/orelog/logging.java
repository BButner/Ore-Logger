package com.daedalus.orelog;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logging implements Listener {
    private String logType;

    commands cmd = new commands();
    File playerLog;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) throws IOException {
        Block minedBlock = event.getBlock();
        Player player = event.getPlayer();
        int bY = player.getLocation().getBlockY();
        int x = minedBlock.getX();
        int y = minedBlock.getY();
        int z = minedBlock.getZ();
        Block block = player.getWorld().getBlockAt(player.getLocation().getBlockX(), bY + 1, player.getLocation().getBlockZ());

        File playerFolder = new File(Bukkit.getPluginManager().getPlugin("OreLogger").getDataFolder() + "/Player Logs");
        File logFile = new File(Bukkit.getPluginManager().getPlugin("OreLogger").getDataFolder() + "/Player Logs/" + player.getName());

        if (!playerFolder.exists()) {
            playerFolder.mkdir();
        }
        if (!logFile.exists()) {
            logFile.mkdir();
        }

        if (minedBlock.getType() == Material.DIAMOND_ORE ||
            minedBlock.getType() == Material.IRON_ORE ||
            minedBlock.getType() == Material.GOLD_ORE ||
            minedBlock.getType() == Material.LAPIS_ORE ||
            minedBlock.getType() == Material.COAL_ORE ||
            minedBlock.getType() == Material.GLOWING_REDSTONE_ORE ||
            minedBlock.getType() == Material.EMERALD_ORE) {

            if (player.isOp() || player.hasPermission("orelogger.notifications")) {
                if (cmd.isEnabled().contains(player.getName())) {
                    player.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.WHITE + " just mined " + ChatColor.YELLOW + minedBlock.getType() + ChatColor.WHITE + " @ x" + x + " y" + y + " z" + z + ".");
                } else if (cmd.getDiamond() ||
                           cmd.getIron() ||
                           cmd.getGold() ||
                           cmd.getLapis() ||
                           cmd.getCoal() ||
                           cmd.getRedstone() ||
                           cmd.getEmerald()) {
                    if (cmd.isEnabled().contains(player.getName() + "DIAMOND") ||
                        cmd.isEnabled().contains(player.getName() + "IRON") ||
                        cmd.isEnabled().contains(player.getName() + "GOLD") ||
                        cmd.isEnabled().contains(player.getName() + "LAPIS") ||
                        cmd.isEnabled().contains(player.getName() + "COAL") ||
                        cmd.isEnabled().contains(player.getName() + "REDSTONE") ||
                        cmd.isEnabled().contains(player.getName() + "EMERALD")) {
                        player.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.WHITE + " just mined " + ChatColor.YELLOW + minedBlock.getType() + ChatColor.WHITE + " @ x" + x + " y" + y + " z" + z + ".");
                    }
                }
            }

            logType = minedBlock.getType().toString();

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFile + File.separator + logType + ".txt", true)));

            out.println("[" + currentDate() + "] " + player.getName() + " mined " + minedBlock.getType() + " at lightlevel " + block.getLightLevel() + " @ x" + x + " y" + y + " z" + z + ".");
            out.close();
        }
    }

    private String currentDate() {
        SimpleDateFormat curDate = new SimpleDateFormat("dd-MM | HH:mm:ss");
        Date now = new Date();
        return curDate.format(now);
    }
}
