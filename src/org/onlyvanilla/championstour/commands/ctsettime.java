package org.onlyvanilla.championstour.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class ctsettime implements CommandExecutor {
	String cmd1 = "ctsettime";
	String eventTime;
	
	ctjoin cte1 = new ctjoin();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase(cmd1)) {
            	if (p.hasPermission("championstour.ctsettime")) {
            		eventTime = args[0];
            		cte1.plugin.getConfig().set("eventinfo.time", eventTime);
            		p.sendMessage(ChatColor.RED + "Time updated");
            		cte1.plugin.saveConfig();
            }
        }
        return true;
    } 
}