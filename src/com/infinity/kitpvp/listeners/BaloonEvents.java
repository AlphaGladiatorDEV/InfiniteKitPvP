package com.infinity.kitpvp.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class BaloonEvents implements Listener{
	
	@EventHandler
	public void combatEvent(EntityDamageByEntityEvent e){
		Entity entity = e.getDamager();
		if(entity.getLocation().getBlockY() > 80){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void fallEvent(EntityDamageEvent e){
		Entity entity = e.getEntity();
		if(entity instanceof Player){
			if(e.getCause() == DamageCause.FALL){
				e.setCancelled(true);
			}else{
				e.setCancelled(false);
			}
		}else{
			return;
		}
	}
	
}
