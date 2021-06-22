package org.onlyvanilla.championstour.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.onlyvanilla.championstour.ListOfParticipants;
import org.onlyvanilla.championstour.MainClass;

import net.md_5.bungee.api.ChatColor;

public class ctjoin implements CommandExecutor {
	String cmd1 = "ctjoin";
	ItemStack diamondStack = new ItemStack(Material.DIAMOND, 3);
	
	ListOfParticipants lp1 = new ListOfParticipants();
	
	public Plugin plugin = MainClass.getPlugin(MainClass.class);

	List<String> participantList = (List<String>)plugin.getConfig().getStringList("participants");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            	if(cmd.getName().equalsIgnoreCase(cmd1)) {
                 	            		
            		if(participantList.size() == 0) {
            			EnterPlayer(p, participantList);
            			plugin.reloadConfig();
            		} else {
            			for(String s : participantList) {
            				if(s.equals(p.getName())) { 
            					p.sendMessage(ChatColor.RED + "You are already on the event roster!");
            					plugin.saveConfig();
            					plugin.reloadConfig();
            				} else {
            					EnterPlayer(p, participantList);
            					plugin.reloadConfig();
            				}
        				}
                	}
            	}
            }
        return true;
    } 
	
	public void EnterPlayer(Player p, List<String> participantList) {
		if(p.getInventory().containsAtLeast(diamondStack, 3)) {
			p.getInventory().removeItem(diamondStack);
			participantList.add(p.getName());
			plugin.getConfig().set("participants", participantList);
			
			for(Player pl : Bukkit.getServer().getOnlinePlayers()) {
				pl.getWorld().playSound(pl.getLocation(), Sound.BLOCK_BELL_RESONATE, 1.0F, 1.0F);
			}
					
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(ChatColor.GOLD + "  ★  "  + p.getName() + " has joined Champions Tour...");
			Bukkit.broadcastMessage(" ");
			
			p.sendMessage(ChatColor.RED + "PLEASE JOIN THE DISCORD TO STAY UPDATED ON UPCOMING EVENTS! /DISCORD.");
			p.sendMessage(ChatColor.RED + "See /ctinfo to view information on the upcoming event!");
			
			plugin.saveConfig();
			plugin.reloadConfig();
			
		} else {
			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0.5F, 0.5F);
			p.sendMessage(ChatColor.RED + "You need 3 diamonds to enter.");
		}
	}
}