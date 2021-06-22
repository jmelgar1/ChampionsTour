package org.onlyvanilla.championstour.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.onlyvanilla.championstour.MainClass;



public class ctinfo implements CommandExecutor {
	String cmd1 = "ctinfo";
	
	ctjoin cte1 = new ctjoin();
	
	public Plugin plugin = MainClass.getPlugin(MainClass.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase(cmd1)) {
            	
            	
            	//FIND PRIZE POOL
        		int i = 0;
        		for(String s : (List<String>)plugin.getConfig().getStringList("participants")) {
        			i++;
        		}
            	
            	
            	p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "-----" + ChatColor.GOLD + "" + ChatColor.BOLD + "CHAMPIONS TOUR" + ChatColor.GRAY + "" + ChatColor.BOLD + "-----");
            	p.sendMessage(ChatColor.AQUA + "Upcoming Event: " + ChatColor.WHITE + cte1.plugin.getConfig().get("eventinfo.name1") + " " 
            													  					+ cte1.plugin.getConfig().get("eventinfo.name2") + " "  
            													  					+ cte1.plugin.getConfig().get("eventinfo.name3"));
            	p.sendMessage("");
            	p.sendMessage(ChatColor.AQUA + "Event Gamemode: " + ChatColor.WHITE + cte1.plugin.getConfig().get("eventinfo.gamemode"));
            	p.sendMessage("");
            	p.sendMessage(ChatColor.AQUA + "Event Date: " + ChatColor.WHITE + cte1.plugin.getConfig().get("eventinfo.date"));
            	p.sendMessage("");
            	p.sendMessage(ChatColor.AQUA + "Event Time (EST): " + ChatColor.WHITE + cte1.plugin.getConfig().get("eventinfo.time"));
            	p.sendMessage("");
            	p.sendMessage(ChatColor.AQUA + "Prize Pool (Diamonds): " + ChatColor.WHITE + (i*3));
        }
        return true;
    } 
}