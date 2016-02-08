package com.infinity.kitpvp.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import com.infinity.kitpvp.main.Main;

public class PlayerStatus implements Listener{
	
	@EventHandler
	public void joinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		p.getInventory().clear();
		for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
		}
		p.setGameMode(GameMode.ADVENTURE);
		ItemStack air = new ItemStack(Material.AIR);
		p.getInventory().setHelmet(air);
		p.getInventory().setChestplate(air);
		p.getInventory().setLeggings(air);
		p.getInventory().setBoots(air);
		p.setHealth(20.0);
		ItemStack ks = new ItemStack(Material.WATCH);
		ItemMeta ksm = ks.getItemMeta();
		ksm.setDisplayName(ChatColor.GOLD + "Kit Selector");
		ks.setItemMeta(ksm);
		p.getInventory().setItem(4, ks);
		Random rand = new Random();
		
		int min = 0;
		int max = 4;
		
		int randomNum = rand.nextInt((max - min) + 1) + min;
		World world = p.getWorld();
		if(randomNum == 1){
			Location loc1 = new Location(world, -357, 125, 654, -180.0f, 9.7f);
			p.teleport(loc1);
		}else if(randomNum == 2){
			Location loc2 = new Location(world, -354, 125, 651, 89.9f, 10.1f);
			p.teleport(loc2);
		}else if(randomNum == 3){
			Location loc3 = new Location(world, -357, 125, 648, 0.0f, 9.9f);
			p.teleport(loc3);
		}else if(randomNum == 4){
			Location loc4 = new Location(world, -360, 125, 651, -89.2f, 9.7f);
			p.teleport(loc4);
		}
		if(p.hasPlayedBefore() == false){
			Bukkit.broadcastMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.GOLD + " has joined the KitPvP server for the first time!");
			p.sendMessage(ChatColor.GREEN + "Welcome to the KitPvP! To select a kit, right-click with the Kit Selector in your hand and left clik one of the items to select a kit.");
			p.sendMessage(ChatColor.GREEN + "The more kills you get, the higher your rank is! To see your kills, use /kills!");
			p.sendMessage(ChatColor.GOLD + "To see a list of ranks that you can achive from kills, use /ranks!");
			p.sendMessage(ChatColor.RED + "Ow! Oooh! Ah! Ouch! Your going to kill meee-");
			p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + ChatColor.BOLD + "Tutorial" + ChatColor.RESET + ChatColor.GOLD + " was killed by " + ChatColor.RED + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.GOLD + " using " + ChatColor.AQUA + ChatColor.BOLD + "their fist.");
			Main.instance.getConfig().set(p.getUniqueId() + ".Kills", Main.instance.getConfig().getInt(p.getUniqueId() + ".Kills", 0) + 1);
			p.sendMessage(ChatColor.GREEN + "That is a death message... Every time you kill someone, you get a, well, kill. One has been added to you.");
			p.sendMessage(ChatColor.RED + "BETA FEATURE: " + ChatColor.GREEN + " You also have rating! Your rating changes from ranked maches. " + ChatColor.RED + "Getting killed subtractes your rating." + ChatColor.GREEN + "But killing someone addes to your rating");
			p.sendMessage(ChatColor.GOLD + "That was the end of the tutorial!, please enjoy the " + ChatColor.BOLD + ChatColor.AQUA + "AtlantisPvP " + ChatColor.GOLD + "KitPvP" + ChatColor.GREEN + "!");
		}else if(p.hasPlayedBefore() == true){
			p.sendMessage(ChatColor.GREEN + "Welcome back to the KitPvP server " + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.GREEN + "!");
		}
	}
	
	@EventHandler
	public void quitEvent(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}

	@EventHandler
	public void deathEvent(PlayerDeathEvent e){
		
		Player p = e.getEntity();
		if(p.getKiller() instanceof Player){
	      Player k = p.getKiller();
	      double kh = k.getHealth();
	      String weapon = k.getItemInHand().getType().name().toLowerCase().replaceAll("_", " ").replaceAll("air", "their fist");
    	  e.setDeathMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by " + ChatColor.GOLD + ChatColor.BOLD + k.getName() + ChatColor.RESET + ChatColor.GREEN + " using " + ChatColor.AQUA + ChatColor.BOLD + weapon);
    	  p.sendMessage(ChatColor.RED + "You were killed by " + ChatColor.GOLD + ChatColor.BOLD + k.getName() + ChatColor.RESET + ChatColor.RED + " who had " + ChatColor.GOLD + ChatColor.BOLD + kh + ChatColor.RESET + ChatColor.RED + " health.");
    	  k.sendMessage(ChatColor.GREEN + "You killed " + ChatColor.GOLD + ChatColor.BOLD + p.getName());
		}
	    e.getDrops().clear();
	    e.setDroppedExp(0);
	    DamageCause dc = e.getEntity().getLastDamageCause().getCause();
	    if(dc.equals(DamageCause.DROWNING)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was drowned.");
	    }else if(dc.equals(DamageCause.FALL)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by a fall.");
	    }else if(dc.equals(DamageCause.FALLING_BLOCK)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by a falling block.");
	    }else if(dc.equals(DamageCause.FIRE)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by fire.");
	    }else if(dc.equals(DamageCause.FIRE_TICK)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by fire.");
	    }else if(dc.equals(DamageCause.LIGHTNING)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by lightning.");
	    }else if(dc.equals(DamageCause.MAGIC)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by magic.");
	    }else if(dc.equals(DamageCause.POISON)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by poison.");
	    }else if(dc.equals(DamageCause.PROJECTILE)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by a projectile.");
	    }else if(dc.equals(DamageCause.STARVATION)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by starvation.");
	    }else if(dc.equals(DamageCause.SUICIDE)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by suicide.");
	    }else if(dc.equals(DamageCause.THORNS)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " was killed by the thorns enchantment.");
	    }else if(dc.equals(DamageCause.ENTITY_EXPLOSION)){
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " blew up.");
	    }else{
	    	e.setDeathMessage("" + ChatColor.AQUA + ChatColor.BOLD + p.getName() + ChatColor.RESET + ChatColor.RED + " died from a unknown cause.");
	    }
	}
	
	@EventHandler
	public void respawnEvent(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		ItemStack ks = new ItemStack(Material.WATCH);
		ItemMeta ksm = ks.getItemMeta();
		ksm.setDisplayName(ChatColor.GOLD + "Kit Selector");
		ks.setItemMeta(ksm);
		p.getInventory().setItem(4, ks);
        Random rand = new Random();
		
		int min = 0;
		int max = 4;
		
		int randomNum = rand.nextInt((max - min) + 1) + min;
		World world = p.getWorld();
		if(randomNum == 1){
			Location loc1 = new Location(world, -357, 125, 654, -180.0f, 9.7f);
			p.teleport(loc1);
		}else if(randomNum == 2){
			Location loc2 = new Location(world, -354, 125, 651, 89.9f, 10.1f);
			p.teleport(loc2);
		}else if(randomNum == 3){
			Location loc3 = new Location(world, -357, 125, 648, 0.0f, 9.9f);
			p.teleport(loc3);
		}else if(randomNum == 4){
			Location loc4 = new Location(world, -360, 125, 651, -89.2f, 9.7f);
			p.teleport(loc4);
		}
	}
}
