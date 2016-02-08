package com.infinity.kitpvp.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EventHandlers implements Listener{

	@EventHandler
	public void blockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("kitpvp.place")){
			e.setCancelled(false);
		}else if(!p.hasPermission("kitpvp.place")){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("kitpvp.break")){
			e.setCancelled(false);
		}else if(!p.hasPermission("kitpvp.break")){
			e.setCancelled(true);
		}
	}
	
	@EventHandler (priority=EventPriority.HIGHEST) 
	public void onFoodLevelChange(final FoodLevelChangeEvent event){
		  event.setCancelled(true);
	}
	
}
