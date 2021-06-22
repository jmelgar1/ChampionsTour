package org.onlyvanilla.championstour;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.onlyvanilla.championstour.commands.championsCommand;
import org.onlyvanilla.championstour.commands.ctclear;
import org.onlyvanilla.championstour.commands.ctjoin;
import org.onlyvanilla.championstour.commands.ctinfo;
import org.onlyvanilla.championstour.commands.ctlist;
import org.onlyvanilla.championstour.commands.ctrewards;
import org.onlyvanilla.championstour.commands.ctsetdate;
import org.onlyvanilla.championstour.commands.ctsetgamemode;
import org.onlyvanilla.championstour.commands.ctsetname;
import org.onlyvanilla.championstour.commands.ctsettime;

import net.md_5.bungee.api.ChatColor;

public class MainClass extends JavaPlugin{
	
	FileConfiguration config;
	File cfile;
		
	public static void main(String[] args) {
		
	}
	
		@Override
		public void onEnable() {
				
			this.saveDefaultConfig();
			config = getConfig();
			config.options().copyDefaults(true);
			saveConfig();
			cfile = new File(getDataFolder(), "config.yml");
					    	    
			System.out.println("(!) ChampionsTour Enabled");	
			
			this.getCommand("ctclear").setExecutor(new ctclear());
			this.getCommand("ctjoin").setExecutor(new ctjoin());
			this.getCommand("ctinfo").setExecutor(new ctinfo());
			this.getCommand("ctlist").setExecutor(new ctlist());
			this.getCommand("ctsetname").setExecutor(new ctsetname());
			this.getCommand("ctsetgamemode").setExecutor(new ctsetgamemode());
			this.getCommand("ctsetdate").setExecutor(new ctsetdate());
			this.getCommand("ctsettime").setExecutor(new ctsettime());
			this.getCommand("ctrewards").setExecutor(new ctrewards());
			this.getCommand("champions").setExecutor(new championsCommand());
		}
		
		@Override
		public void onDisable() {
			System.out.println("(!) ChampionsTour Disabled");			
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(cmd.getName().equalsIgnoreCase("ctreload")) {
				reloadConfig();
			}
			return true;
		}
	}