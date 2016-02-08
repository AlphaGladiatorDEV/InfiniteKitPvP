package com.infinity.kitpvp.main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.infinity.kitpvp.commands.HelpOverride;
import com.infinity.kitpvp.commands.KillsCommand;
import com.infinity.kitpvp.commands.KitCommand;
import com.infinity.kitpvp.commands.RankCommand;
import com.infinity.kitpvp.listeners.BaloonEvents;
import com.infinity.kitpvp.listeners.EventHandlers;
import com.infinity.kitpvp.listeners.KitSelector;
import com.infinity.kitpvp.listeners.PlayerStatus;
import com.infinity.kitpvp.ranked.RatingCommand;
import com.infinity.kitpvp.ranks.RankUpdater;
import com.infinity.kitpvp.ranks.PlayerDisplay;

public class Main extends JavaPlugin{
	
	public static Main instance;
	
	public static Main getInstance(){
		return instance;
	}
	
	public void consoleBroadcast(String s){
		Bukkit.getServer().getLogger().info(s);
	}
	
	public void registerCommands(){
		getCommand("kit").setExecutor(new KitCommand());
		getCommand("ranks").setExecutor(new RankCommand());
		getCommand("kills").setExecutor(new KillsCommand());
		getCommand("help").setExecutor(new HelpOverride());
		getCommand("?").setExecutor(new HelpOverride());
		getCommand("rating").setExecutor(new RatingCommand());
	}
	
	public void registerClasses(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		//Command Classes
		pm.registerEvents(new RankCommand(), this);
		pm.registerEvents(new KillsCommand(), this);
		pm.registerEvents(new KitCommand(), this);
		pm.registerEvents(new HelpOverride(), this);
		pm.registerEvents(new RatingCommand(), this);
		
		//Listener Classes
		pm.registerEvents(new PlayerStatus(), this);
		pm.registerEvents(new KitSelector(), this);
		pm.registerEvents(new EventHandlers(), this);
		pm.registerEvents(new BaloonEvents(), this);
		
		//Ranks Classes
		pm.registerEvents(new RankUpdater(), this);
		pm.registerEvents(new PlayerDisplay(), this);
		
	}
	
	@Override
	public void onEnable(){
		consoleBroadcast("[InfiniteKitPvP] The plugin has been enabled.");
		instance = this;
		registerCommands();
		registerClasses();
		saveDefaultConfig();
		getServer().getMessenger().registerOutgoingPluginChannel(this, 
				"BungeeCord");
	}
	
	@Override
	public void onDisable(){
		consoleBroadcast("[InfiniteKitPvP] The plugin has been disabled.");
		instance = null;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You must be a player to use this command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("hub")){
			sendToServer(p, "lobby");
			return true;
		}
		
		return false;
	}
	
	public void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try{
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		}catch(Exception e){
			e.printStackTrace();
		}
		player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
	}

}
