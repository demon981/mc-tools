package dev_Tools.demonek.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import dev_Tools.demonek.Main;

public class OnPlace implements Listener{
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		final Block blok = e.getBlock();
		final Location loc = blok.getLocation();
		final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1, loc.getZ());
		if(blok.getType() == Material.ENDER_STONE){
			if(loc1.getBlock().getType() == Material.AIR){
				Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
					public void run() {
						if(loc.getBlock().getType() == Material.ENDER_STONE){
							loc1.getBlock().setType(Material.STONE);
						}
					}
				}, 20L);
			}
		}
		
		if(blok.getType() == Material.BEDROCK){
			if(loc1.getBlock().getType() == Material.AIR){
				Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
					public void run() {
						if(loc.getBlock().getType() == Material.BEDROCK){
							loc1.getBlock().setType(Material.LOG);
						}
					}
				}, 20L);
			}
		}
	}
}