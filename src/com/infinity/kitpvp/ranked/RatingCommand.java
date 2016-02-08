package com.infinity.kitpvp.ranked;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.infinity.kitpvp.main.Main;

public class RatingCommand implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GOLD + "KitPvP " + ChatColor.GRAY + ">>> " + ChatColor.RED + "You have to be a player to use this command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("rating")){
			if(args.length == 0){
				p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "Usages: /rating <kit>");
				return true;
			}else if(args[0].equalsIgnoreCase("warrior")){
				if(Main.instance.getConfig().getLong(p.getUniqueId() + ".Rating" + ".Warrior") == 0){
					p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You have not participated in a Ranked " + ChatColor.RED + "Warrior" + ChatColor.RED + " battle.");
					return true;
				}else{
					long rating = Main.instance.getConfig().getLong(p.getUniqueId() + ".Rating" + ".Warrior");
					p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "Your rating for the " + ChatColor.RED + "Warrior" + ChatColor.GREEN + " kit is: " + ChatColor.AQUA + rating);
					return true;
				}
			}else if(args[0].equalsIgnoreCase("archer")){
				if(Main.instance.getConfig().getLong(p.getUniqueId() + ".Rating" + ".Archer") == 0){
					p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You have not participated in a Ranked " + ChatColor.GREEN + "Archer" + ChatColor.RED + " battle.");
					return true;
				}else{
					long rating = Main.instance.getConfig().getLong(p.getUniqueId() + ".Rating" + ".Archer");
					p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "Your rating for the " + ChatColor.GREEN + "Archer" + ChatColor.GREEN + " kit is: " + ChatColor.AQUA + rating);
					return true;
				}
			}else if(!args[0].isEmpty()){
				p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "Unidentified kit. To view all kits, use the Kit Selector.");
				return true;
			}
		}
		
		return false;
	}

}
