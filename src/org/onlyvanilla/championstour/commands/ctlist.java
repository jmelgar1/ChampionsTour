package org.onlyvanilla.championstour.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.onlyvanilla.championstour.MainClass;

import net.md_5.bungee.api.ChatColor;

public class ctlist implements CommandExecutor {
	String cmd1 = "ctlist";
	
	public Plugin plugin = MainClass.getPlugin(MainClass.class);

	
	ctjoin cte1 = new ctjoin();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            	if(cmd.getName().equalsIgnoreCase(cmd1)) {
            		cte1.plugin.reloadConfig();
            		p.sendMessage(ChatColor.GRAY + "-----" + ChatColor.WHITE + "" + ChatColor.GOLD + cte1.plugin.getConfig().get("eventinfo.name1")
            																				 + " " + cte1.plugin.getConfig().get("eventinfo.name2")
            																				 + " " + cte1.plugin.getConfig().get("eventinfo.name3") + ChatColor.GRAY + "-----");
            		
            		int i = 0;
            		for(String s : (List<String>)plugin.getConfig().getStringList("participants")) {
            			i++;
            			p.sendMessage(ChatColor.GOLD + "" + i + ". " + ChatColor.YELLOW + s);
            		}
            	}
            }
        return true;
    } 
}