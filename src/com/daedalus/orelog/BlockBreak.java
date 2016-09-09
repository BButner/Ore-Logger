package com.daedalus.orelog;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.IOException;

public class BlockBreak implements Listener {
    Commands cmd = new Commands();
    Logging log = new Logging();

    private Material[] validOre = new Material[]{Material.DIAMOND_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.LAPIS_ORE, Material.COAL_ORE, Material.GLOWING_REDSTONE_ORE, Material.EMERALD_ORE};

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) throws IOException {
        Block minedBlock = event.getBlock();
        Player player = event.getPlayer();

        String oreBlock = minedBlock.getType().toString();

        int bY = player.getLocation().getBlockY();
        int x = minedBlock.getX();
        int y = minedBlock.getY();
        int z = minedBlock.getZ();

        Block block = player.getWorld().getBlockAt(player.getLocation().getBlockX(), bY + 1, player.getLocation().getBlockZ());

        for (Material valid : validOre) {
            if (minedBlock.getType() == valid) {
                String ore = minedBlock.getType().toString();
                ore = ore.replace("ORE", "");
                ore = ore.replace("GLOWING", "");
                ore = ore.replace("_", "");
                ore = ore.toLowerCase();

                if (player.isOp() || player.hasPermission("orelogger.notifications")) {
                    if (cmd.getEnabledPlayers().contains(player + ore)) {
                        player.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.WHITE + " just mined " + ChatColor.YELLOW + minedBlock.getType() + ChatColor.WHITE + " @ x" + x + " y" + y + " z" + z + ".");
                    }
                }
                log.createLog(player.getName(), oreBlock, block.getLightLevel(), x, y, z);
            }
        }}
}
