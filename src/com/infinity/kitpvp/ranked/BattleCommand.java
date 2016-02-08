package com.infinity.kitpvp.ranked;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BattleCommand implements CommandExecutor, Listener{

	String smpt = ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RESET;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(!(sender instanceof Player)){
			sender.sendMessage(smpt + ChatColor.RED + "You must be a player to use this command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("battle")){
			if(args.length == 0 || args.length == 1){
				p.sendMessage(smpt + ChatColor.RED + "Usage: /battle <playername> <kit>");
				return true;
			}else if(args.length == 2){
				Player target = Bukkit.getServer().getPlayer(args[1]);
				if (target == null) {
					sender.sendMessage(ChatColor.RED + "Could not find player " + args[1] + ".");
					return true;
				}
				String kit = args[2];
				if(kit.equalsIgnoreCase("warrior")){
					
				}else if(kit.equalsIgnoreCase("archer")){
					
				}else if(!kit.isEmpty()){
					p.sendMessage(smpt + ChatColor.RED + "This kit is not recognized.");
					return true;
				}
			}
		}
		
		return false;
	}

}
