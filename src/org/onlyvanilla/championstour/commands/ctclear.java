package org.onlyvanilla.championstour.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.onlyvanilla.championstour.ListOfParticipants;

import net.md_5.bungee.api.ChatColor;


public class ctclear implements CommandExecutor {
	String cmd1 = "ctclear";
	
	ListOfParticipants lp1 = new ListOfParticipants();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase(cmd1)) {
            	if (p.hasPermission("championstour.ctclear")) {
            		lp1.participants.clear();
            		p.sendMessage(ChatColor.RED + "Participant list has been cleared.");
            }
        }
        return true;
    } 
}