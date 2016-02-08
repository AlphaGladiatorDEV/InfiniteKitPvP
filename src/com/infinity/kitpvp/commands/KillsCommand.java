package com.infinity.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.infinity.kitpvp.main.Main;

public class KillsCommand implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You must be a player to use this command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("kills")){
			int kills = Main.instance.getConfig().getInt(p.getUniqueId() + ".Kills");
			p.sendMessage(ChatColor.GOLD + "KitPvP " + ChatColor.GRAY + ">>> " + ChatColor.GREEN + "You have " + ChatColor.AQUA + ChatColor.BOLD + kills + ChatColor.RESET + ChatColor.GREEN + " kills!");
			return true;
		}
		return false;
	}

}
