package com.infinity.kitpvp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelector implements Listener{
	
	@EventHandler
	public void interactEvent(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(p.getItemInHand() != null){
			ItemStack iih = p.getItemInHand();
			if(iih.getType() == Material.WATCH){
				if(p.getLocation().getBlockY() < 100){
					p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You must be in the baloon to choose your kit!");
				}else{
					p.openInventory(kitSelector);
				}
			}
		}
	}
	
	public static Inventory kitSelector = Bukkit.createInventory(null, 18, "Kit Selector");
	static {
		
		ItemStack wks = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta wksm = wks.getItemMeta();
		wksm.setDisplayName(ChatColor.RED + "Warrior Kit");
		wks.setItemMeta(wksm);
		wks.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		kitSelector.setItem(0, wks);
		
		ItemStack akb = new ItemStack(Material.BOW);
		ItemMeta akbm = akb.getItemMeta();
		akbm.setDisplayName(ChatColor.GREEN + "Archer Bow");
		akb.setItemMeta(akbm);
		akb.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
		akb.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		akb.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
		kitSelector.setItem(1, akb);
	      
	}
	
	@EventHandler
	  public void onInventoryClick(InventoryClickEvent e){
		  
		  Player p = (Player) e.getWhoClicked();
		  ItemStack clicked = e.getCurrentItem();
		  Inventory inventory = e.getInventory();
		     
		  if(inventory.getName().equals(kitSelector.getName())){
			  
		      if(clicked.getType() != null || clicked.getType() != Material.AIR){
		    	  
		          e.setCancelled(true);
		          p.closeInventory();
		          
		     
		          Material type = clicked.getType();
		                 
		          if(type == Material.DIAMOND_SWORD){
		              e.setCancelled(true);
		              p.closeInventory();
	                  p.performCommand("kit warrior");
	              }
		          if(type == Material.BOW){
		        	  e.setCancelled(true);
		        	  p.closeInventory();
		        	  p.performCommand("kit archer");
		          }
	   } 
	 }
	}

}
