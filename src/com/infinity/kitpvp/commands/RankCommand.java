package com.infinity.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RankCommand implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You must be a player to use this command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("ranks")){
			p.sendMessage(ChatColor.BLACK + "----------[ " + ChatColor.GOLD + "KitPvP Ranks" + ChatColor.BLACK + " ]----------");
			p.sendMessage(ChatColor.GRAY + "New Fighter - Everyone starts with this rank.");
			p.sendMessage(ChatColor.RED + "Fighter - Achieved after 25 kills.");
			p.sendMessage(ChatColor.DARK_PURPLE + "Skilled Fighter - Achieved after 100 kills.");
			p.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "BARBARIAN - Achieved after 500 kills.");
			p.sendMessage(ChatColor.DARK_GREEN + "General - Achieved after 1,000 kills.");
			p.sendMessage(ChatColor.GOLD + "Champion - Achieved after 1.500 kills.");
			p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "GRANDMASTER - Achieved after 5,000 kills.");
			p.sendMessage("" + ChatColor.WHITE + ChatColor.ITALIC + "COMBAT LEGEND - Achieved after 10,000 kills.");
			p.sendMessage("" + ChatColor.WHITE + ChatColor.BOLD + ChatColor.MAGIC + "yol" + ChatColor.RESET + ChatColor.GOLD + ChatColor.BOLD + "GOD" + ChatColor.RESET + ChatColor.BOLD + ChatColor.MAGIC + "loy" + ChatColor.RESET + ChatColor.BOLD + ChatColor.GOLD + " - Achieved after 50,000 kills.");
			return true;
		}
		return false;
	}

}
