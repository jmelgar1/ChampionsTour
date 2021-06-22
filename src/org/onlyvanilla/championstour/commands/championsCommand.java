package org.onlyvanilla.championstour.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class championsCommand implements CommandExecutor {
	String cmd1 = "champions";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            	if(cmd.getName().equalsIgnoreCase(cmd1)) {
            		p.sendMessage(ChatColor.GRAY + "------" + ChatColor.GOLD + "" + ChatColor.BOLD + "CHAMPIONS TOUR" + ChatColor.GRAY + "------");
            		p.sendMessage(ChatColor.YELLOW + "/ctjoin (Join champions tour)");
            		p.sendMessage(ChatColor.YELLOW + "/ctinfo (See upcoming event info)");
            		p.sendMessage(ChatColor.YELLOW + "/ctrewards (See event rewards)");
            		p.sendMessage(ChatColor.YELLOW + "/ctlist (List participants)");
            		p.sendMessage(" ");
            		p.sendMessage(ChatColor.GRAY + "Click the link for more info!");
            		sendMessage(p);
            }
        }
        return true;
    } 
    public void sendMessage(Player p) {
    	TextComponent message = new TextComponent("https://onlyvanilla.org/champions");
    	message.setColor(ChatColor.GOLD);
    	message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://onlyvanilla.org/champions"));
    	p.spigot().sendMessage(message);
    }
}
