package com.infinity.kitpvp.ranks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.infinity.kitpvp.main.Main;

public class PlayerDisplay implements Listener{
	
	@EventHandler
	  public void playerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String pname = p.getName();
		String kills = p.getUniqueId() + ".Kills";
		if(Main.instance.getConfig().getInt(kills) < 24){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.GRAY + "New Fighter" + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 24 && Main.instance.getConfig().getInt(kills) < 99){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.RED + "Fighter" + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 99 && Main.instance.getConfig().getInt(kills) < 499){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.DARK_PURPLE + "Skilled Fighter" + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 499 && Main.instance.getConfig().getInt(kills) < 999){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.DARK_RED + ChatColor.BOLD + "BARBARIAN" + ChatColor.RESET + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 999 && Main.instance.getConfig().getInt(kills) < 1499){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.DARK_GREEN + "General" + ChatColor.RESET + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 1499 && Main.instance.getConfig().getInt(kills) < 4999){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.GOLD + "Champion" + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 4999 && Main.instance.getConfig().getInt(kills) < 10000){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.GRAY + ChatColor.BOLD + "GRANDMASTER" + ChatColor.RESET + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 10000 && Main.instance.getConfig().getInt(kills) < 49999){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.WHITE + ChatColor.ITALIC + "COMBAT LEGEND" + ChatColor.RESET + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}if(Main.instance.getConfig().getInt(kills) > 50000){
			String name = "" + ChatColor.BLACK + "[ " + ChatColor.WHITE + ChatColor.BOLD + ChatColor.MAGIC + "yol" + ChatColor.RESET + ChatColor.GOLD + ChatColor.BOLD + "GOD" + ChatColor.RESET + ChatColor.WHITE + ChatColor.BOLD + ChatColor.MAGIC + "loy" + ChatColor.RESET + ChatColor.BLACK + " ] " + ChatColor.GOLD + pname + ChatColor.GRAY + " > " + ChatColor.RESET + e.getMessage();
			e.setFormat(name);
		}
	  }

}
