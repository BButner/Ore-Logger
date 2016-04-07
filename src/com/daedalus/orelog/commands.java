package com.daedalus.orelog;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commands implements CommandExecutor {
    private static String cmdSender;
    public static List<String> validOre = new ArrayList<>(Arrays.asList("diamond", "iron", "gold", "lapis", "coal", "redstone", "emerald"));
    public static ArrayList<String> enabledPlayerOre = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ol")) {
            if (args.length == 0) {
                sender.sendMessage("No args!");
                return true;
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("enable")) {
                    for (int i = 0; i < 7; i++) {
                        enabledPlayerOre.add(sender.toString() + validOre.get(i));
                    }
                    sender.sendMessage("All ore notifications enabled!");
                    return true;
                } else if (args[0].equalsIgnoreCase("disable")) {
                    for (int i = 0; i < 7; i++) {
                        enabledPlayerOre.remove(sender.toString() + validOre.get(i));
                    }
                    sender.sendMessage("All ore notifications disabled!");
                    return true;
                } else if (validOre.contains(args[0])) {
                    cmdSender = sender.toString();
                    if (!enabledPlayerOre.contains(sender + args[0])) {
                        enabledPlayerOre.add(sender + args[0]);
                        sender.sendMessage("Enabled notifications for " + ChatColor.YELLOW + args[0] + " ore" + ChatColor.WHITE + ".");
                    } else {
                        enabledPlayerOre.remove(sender + args[0]);
                        sender.sendMessage("Disabled notifications for " + ChatColor.YELLOW + args[0] + " ore" + ChatColor.WHITE + ".");
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
    public String getSender() {
        return cmdSender;
    }
}
