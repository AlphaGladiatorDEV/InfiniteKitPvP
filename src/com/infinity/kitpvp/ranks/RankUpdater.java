package com.infinity.kitpvp.ranks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.infinity.kitpvp.main.Main;

public class RankUpdater implements Listener{
	
	@EventHandler
	public void deathEvent(PlayerDeathEvent e){
		if(e.getEntity().getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK){
			if(e.getEntity().getKiller() instanceof Player){
				giveKills(e.getEntity().getKiller(), 1);
				return;
			}
		}
	}

	private void giveKills(Player k, int i) {
		Main.instance.getConfig().set(k.getUniqueId() + ".Kills", Main.instance.getConfig().getInt(k.getUniqueId() + ".Kills", 0) + i);
		Main.instance.saveConfig();
		Main.instance.reloadConfig();
	}

}
