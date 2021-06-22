package org.onlyvanilla.championstour.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class ctsetname implements CommandExecutor {
	String cmd1 = "ctsetname";
	String eventName1;
	String eventName2;
	String eventName3;
	
	ctjoin cte1 = new ctjoin();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase(cmd1)) {
            	if (p.hasPermission("championstour.ctsetname")) {
            		if(args.length >= 2) {
            			eventName1 = args[0];
            			eventName2 = args[1];
            			eventName3 = args[2];
            			cte1.plugin.getConfig().set("eventinfo.name1", eventName1);
                		cte1.plugin.getConfig().set("eventinfo.name2", eventName2);
                		cte1.plugin.getConfig().set("eventinfo.name3", eventName3);
                		cte1.plugin.saveConfig();
            		} else {
            			eventName1 = args[0];
            			eventName2 = args[1];
            			cte1.plugin.getConfig().set("eventinfo.name1", eventName1);
                		cte1.plugin.getConfig().set("eventinfo.name2", eventName2);
                		cte1.plugin.getConfig().set("eventinfo.name3", " ");
                		cte1.plugin.saveConfig();
            		}
            		p.sendMessage(ChatColor.RED + "Name updated");
            }
        }
        return true;
    } 
}