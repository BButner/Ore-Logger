package com.daedalus.orelog;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class commands implements CommandExecutor {
    private static boolean diamond = false;
    private static boolean iron = false;
    private static boolean gold = false;
    private static boolean lapis = false;
    private static boolean coal = false;
    private static boolean redstone = false;
    private static boolean emerald = false;

    private static ArrayList<String> hasEnabled = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ol")) {
            if (args.length == 0) {
                sender.sendMessage("No args!");
                return true;
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("enable")) {
                    hasEnabled.add(sender.getName());
                    sender.sendMessage("All ore notifications enabled!");
                    return true;
                } else if (args[0].equalsIgnoreCase("disable")) {
                    sender.sendMessage("All ore notifications disabled!");
                    hasEnabled.remove(sender.getName());
                    diamond = false; iron = false; gold = false; lapis = false; coal = false; redstone = false; emerald = false;
                    return true;
                }
                if (args[0].equalsIgnoreCase("Diamond")) {
                    if (!diamond) {
                        diamond = true;
                        if(!hasEnabled.contains(sender.getName() + "DIAMOND")) {
                            hasEnabled.add(sender.getName() + "DIAMOND");
                        }
                        sender.sendMessage(ChatColor.AQUA + "Diamond " + ChatColor.WHITE + "notifications enabled.");
                    } else if (diamond) {
                        diamond = false;
                        if(hasEnabled.contains(sender.getName() + "DIAMOND")) {
                            hasEnabled.remove(sender.getName() + "DIAMOND");
                        }
                        sender.sendMessage(ChatColor.AQUA + "Diamond " + ChatColor.WHITE + "notifications disabled.");
                    }
                } else if (args[0].equalsIgnoreCase("Iron")) {
                    if (!iron) {
                        iron = true;
                        if(!hasEnabled.contains(sender.getName() + "IRON")) {
                            hasEnabled.add(sender.getName() + "IRON");
                        }
                        sender.sendMessage(ChatColor.GRAY + "Iron " + ChatColor.WHITE + "notifications enabled.");
                    } else if (iron) {
                        iron = false;
                        if(hasEnabled.contains(sender.getName() + "IRON")) {
                            hasEnabled.remove(sender.getName() + "IRON");
                        }
                        sender.sendMessage(ChatColor.GRAY + "Iron " + ChatColor.WHITE + "notifications disabled.");
                    }
                } else if (args[0].equalsIgnoreCase("Gold")) {
                    if (!gold) {
                        gold = true;
                        if(!hasEnabled.contains(sender.getName() + "GOLD")) {
                            hasEnabled.add(sender.getName() + "GOLD");
                        }
                        sender.sendMessage(ChatColor.YELLOW + "Gold " + ChatColor.WHITE + "notifications enabled.");
                    } else if (gold) {
                        gold = false;
                        if(hasEnabled.contains(sender.getName() + "GOLD")) {
                            hasEnabled.remove(sender.getName() + "GOLD");
                        }
                        sender.sendMessage(ChatColor.YELLOW + "Gold " + ChatColor.WHITE + "notifications disabled.");
                    }
                } else if (args[0].equalsIgnoreCase("Lapis")) {
                    if (!lapis) {
                        lapis = true;
                        if(!hasEnabled.contains(sender.getName() + "LAPIS")) {
                            hasEnabled.add(sender.getName() + "LAPIS");
                        }
                        sender.sendMessage(ChatColor.BLUE + "LAPIS " + ChatColor.WHITE + "notifications enabled.");
                    } else if (lapis) {
                        lapis = false;
                        if(hasEnabled.contains(sender.getName() + "LAPIS")) {
                            hasEnabled.remove(sender.getName() + "LAPIS");
                        }
                        sender.sendMessage(ChatColor.BLUE + "LAPIS " + ChatColor.WHITE + "notifications disabled.");
                    }
                } else if (args[0].equalsIgnoreCase("Coal")) {
                    if (!coal) {
                        coal = true;
                        if(!hasEnabled.contains(sender.getName() + "COAL")) {
                            hasEnabled.add(sender.getName() + "COAL");
                        }
                        sender.sendMessage(ChatColor.DARK_GRAY + "Coal " + ChatColor.WHITE + "notifications enabled.");
                    } else if (coal) {
                        coal = false;
                        if(hasEnabled.contains(sender.getName() + "COAL")) {
                            hasEnabled.remove(sender.getName() + "COAL");
                        }
                        sender.sendMessage(ChatColor.DARK_GRAY + "Coal " + ChatColor.WHITE + "notifications disabled.");
                    }
                } else if (args[0].equalsIgnoreCase("Redstone")) {
                    if (!redstone) {
                        redstone = true;
                        if(!hasEnabled.contains(sender.getName() + "REDSTONE")) {
                            hasEnabled.add(sender.getName() + "REDSTONE");
                        }
                        sender.sendMessage(ChatColor.RED + "Redstone " + ChatColor.WHITE + "notifications enabled.");
                    } else if (redstone) {
                        redstone = false;
                        if(hasEnabled.contains(sender.getName() + "REDSTONE")) {
                            hasEnabled.remove(sender.getName() + "REDSTONE");
                        }
                        sender.sendMessage(ChatColor.RED + "Redstone " + ChatColor.WHITE + "notifications disabled.");
                    }
                } else if (args[0].equalsIgnoreCase("Emerald")) {
                    if (!emerald) {
                        emerald = true;
                        if(!hasEnabled.contains(sender.getName() + "EMERALD")) {
                            hasEnabled.add(sender.getName() + "EMERALD");
                        }
                        sender.sendMessage(ChatColor.GREEN + "Emerald " + ChatColor.WHITE + "notifications enabled.");
                    } else if (emerald) {
                        emerald = false;
                        if(hasEnabled.contains(sender.getName() + "EMERALD")) {
                            hasEnabled.remove(sender.getName() + "EMERALD");
                        }
                        sender.sendMessage(ChatColor.GREEN + "Emerald " + ChatColor.WHITE + "notifications disabled.");
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public ArrayList<String> isEnabled() {
        return hasEnabled;
    }

    public boolean getDiamond() {
        return diamond;
    }
    public boolean getIron() {
        return iron;
    }
    public boolean getGold() {
        return gold;
    }
    public boolean getLapis() {
        return lapis;
    }
    public boolean getCoal() {
        return coal;
    }
    public boolean getRedstone() {
        return redstone;
    }
    public boolean getEmerald() {
        return emerald;
    }

}
