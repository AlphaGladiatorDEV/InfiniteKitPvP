package com.infinity.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class HelpOverride implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		CommandSender p = sender;
		
		if(cmd.getName().equalsIgnoreCase("help")){
			p.sendMessage(ChatColor.BLACK + "----------[ " + ChatColor.GOLD + "KitPvP Help" + ChatColor.BLACK + " ]----------");
			p.sendMessage("/kills - Tells you how many kills you have.");
			p.sendMessage("/kit <kit> - You can use this as a alternative to the kit selector.");
			p.sendMessage("/ranks - Tells you the PvP ranks you can achieve.");
			p.sendMessage("/hub - Teleports you to the AtlantisPvP lobby server.");
			p.sendMessage("/rating - Still in BETA, use TBA.");
			return true;
		}
		
	    if(cmd.getName().equalsIgnoreCase("?")){
	    	p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GREEN + "The help command is /help");
	    	return true;
	    }
		
		return false;
	}

}
