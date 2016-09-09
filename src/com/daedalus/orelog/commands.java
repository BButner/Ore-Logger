package com.daedalus.orelog;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands implements CommandExecutor {
    private List<String> validOre = new ArrayList<>(Arrays.asList("diamond", "iron", "gold", "lapis", "coal", "redstone", "emerald"));
    private static ArrayList<String> enabledPlayerOre = new ArrayList<>();
    Logging log = new Logging();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ol")) {
            if (args.length == 0) {
                sender.sendMessage("Please specify an " + ChatColor.YELLOW + "ore" + ChatColor.WHITE + ".");
                return true;
            } else if (args.length == 1) {
                switch (args[0]) {
                    case "enable": {
                        for (int i = 0; i < 7; i++) {
                            enabledPlayerOre.add(sender.toString() + validOre.get(i));
                        }
                        sender.sendMessage("All notifications enabled!");
                        return true;
                    }
                    case "disable": {
                        for (int i = 0; i < 7; i++) {
                            enabledPlayerOre.remove(sender.toString() + validOre.get(i));
                        }
                        sender.sendMessage("All notifications disabled!");
                        return true;
                    }
                }

                if (validOre.contains(args[0])) {
                    if (!enabledPlayerOre.contains(sender + args[0])) {
                        enabledPlayerOre.add(sender + args[0]);
                        sender.sendMessage("Enabled notifications for " + ChatColor.YELLOW + args[0] + " ore" + ChatColor.WHITE + ".");
                    } else {
                        enabledPlayerOre.remove(sender + args[0]);
                        sender.sendMessage("Disabled notifications for " + ChatColor.YELLOW + args[0] + " ore" + ChatColor.WHITE + ".");
                    }
                }
            }
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("oreent")) {
            Player player = (Player) sender;
            World world = player.getWorld();

            for (Entity e : world.getEntities()) {
                try {
                    log.entityLog(e.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            player.sendMessage("Logged all entities!");
            return true;
        }
        return false;
    }

    public ArrayList<String> getEnabledPlayers() {
        return enabledPlayerOre;
    }

}
