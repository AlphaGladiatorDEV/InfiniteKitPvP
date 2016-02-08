package com.infinity.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitCommand implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You must be a player to use this command.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("kit")){
			if(args.length == 0){
				p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "You didn't specify a kit to choose!");
				return true;
			}
			if(args[0].equalsIgnoreCase("warrior")){
				
				p.getInventory().clear();
				for (PotionEffect effect : p.getActivePotionEffects())
			        p.removePotionEffect(effect.getType());
				ItemStack air = new ItemStack(Material.AIR);
				p.getInventory().setHelmet(air);
				p.getInventory().setChestplate(air);
				p.getInventory().setLeggings(air);
				p.getInventory().setBoots(air);
				
				ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta sm = s.getItemMeta();
				sm.setDisplayName(ChatColor.RED + "Warrior Sword");
				s.setItemMeta(sm);
				s.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				p.getInventory().addItem(s);
				
				ItemStack h = new ItemStack(Material.DIAMOND_HELMET);
				ItemMeta hm = h.getItemMeta();
				hm.setDisplayName(ChatColor.RED + "Warrior Helmet");
				h.setItemMeta(hm);
				h.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				h.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				p.getInventory().setHelmet(h);
				
				ItemStack c = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta cm = c.getItemMeta();
				cm.setDisplayName(ChatColor.RED + "Warrior Chestplate");
				c.setItemMeta(cm);
				c.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				c.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				p.getInventory().setChestplate(c);
				
				ItemStack l = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemMeta lm = l.getItemMeta();
				lm.setDisplayName(ChatColor.RED + "Warrior Leggings");
				l.setItemMeta(lm);
				l.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				l.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				p.getInventory().setLeggings(l);
				
				ItemStack b = new ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta bm = b.getItemMeta();
				bm.setDisplayName(ChatColor.RED + "Warrior Boots");
				b.setItemMeta(bm);
				b.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				b.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				p.getInventory().setBoots(b);
				
				ItemStack ks = new ItemStack(Material.WATCH);
				ItemMeta ksm = ks.getItemMeta();
				ksm.setDisplayName(ChatColor.GOLD + "Kit Selector");
				ks.setItemMeta(ksm);
				p.getInventory().setItem(8, ks);
				
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE,10, (short)1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2), true);
				
				p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "You have chosen the " + ChatColor.RED + "Warrior Kit" + ChatColor.GREEN + "!");
				return true;
				
			}
			if(args[0].equalsIgnoreCase("archer")){
				
				p.getInventory().clear();
				for (PotionEffect effect : p.getActivePotionEffects())
			        p.removePotionEffect(effect.getType());
				ItemStack air = new ItemStack(Material.AIR);
				p.getInventory().setHelmet(air);
				p.getInventory().setChestplate(air);
				p.getInventory().setLeggings(air);
				p.getInventory().setBoots(air);
				
				ItemStack bw = new ItemStack(Material.BOW);
				ItemMeta bwm = bw.getItemMeta();
				bwm.setDisplayName(ChatColor.GREEN + "Archer Bow");
				bw.setItemMeta(bwm);
				bw.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
				bw.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
				bw.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
				p.getInventory().addItem(bw);
				
				ItemStack h = new ItemStack(Material.IRON_HELMET);
				ItemMeta hm = h.getItemMeta();
				hm.setDisplayName(ChatColor.GREEN + "Archer Helmet");
				h.setItemMeta(hm);
				h.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
				h.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				p.getInventory().setHelmet(h);
				
				ItemStack c = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta cm = c.getItemMeta();
				cm.setDisplayName(ChatColor.GREEN + "Archer Chestplate");
				c.setItemMeta(cm);
				c.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
				c.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				p.getInventory().setChestplate(c);
				
				ItemStack l = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta lm = l.getItemMeta();
				lm.setDisplayName(ChatColor.GREEN + "Archer Leggings");
				l.setItemMeta(lm);
				l.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
				l.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				p.getInventory().setLeggings(l);
				
				ItemStack b = new ItemStack(Material.IRON_BOOTS);
				ItemMeta bm = b.getItemMeta();
				bm.setDisplayName(ChatColor.GREEN + "Archer Boots");
				b.setItemMeta(bm);
				b.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
				b.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				p.getInventory().setBoots(b);
				
				ItemStack ks = new ItemStack(Material.WATCH);
				ItemMeta ksm = ks.getItemMeta();
				ksm.setDisplayName(ChatColor.GOLD + "Kit Selector");
				ks.setItemMeta(ksm);
				p.getInventory().setItem(8, ks);
				
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE,10, (short)1));
				p.getInventory().addItem(new ItemStack(Material.ARROW, (short)1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2), true);
				
				p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.GREEN + "You have chosen the Archer Kit!");
				return true;
			}else if(!args[0].isEmpty()){
				p.sendMessage(ChatColor.GOLD + "KitPvP" + ChatColor.GRAY + " >>> " + ChatColor.RED + "Invalid kit. Usage: /kit <warrior/archer>");
				return true;
			}
		}
		return false;
	}

}
