package org.onlyvanilla.championstour.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class ctrewards implements CommandExecutor {
	String cmd1 = "ctrewards";
	
	ctjoin cte1 = new ctjoin();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase(cmd1)) {
            	p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "-----" + ChatColor.GOLD + "" + ChatColor.BOLD + "CHAMPIONS TOUR" + ChatColor.GRAY + "" + ChatColor.BOLD + "-----");
            	p.sendMessage("");
            	p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "OPEN EVENT WINNER REWARDS");
            	p.sendMessage(ChatColor.YELLOW + "1. The entire prize pool (3 diamonds per player)");
            	p.sendMessage(ChatColor.YELLOW + "2. Qualification to The Champions Event");
            	p.sendMessage("");
            	p.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "CHAMPIONS EVENT WINNER REWARDS");
            	p.sendMessage(ChatColor.YELLOW + "1. Gold italic name. Ex." + ChatColor.GOLD + "" + ChatColor.ITALIC + " OnlyVanillaAdmin");
            	p.sendMessage(ChatColor.YELLOW + "2. Champion discord role");
            	p.sendMessage(ChatColor.YELLOW + "3. A place in the Hall Of Champions");
            	p.sendMessage(ChatColor.YELLOW + "4. Tier 2 Donation perks");
            	p.sendMessage("");
        }
        return true;
    } 
}