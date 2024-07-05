package dev_Tools.demonek.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import dev_Tools.demonek.Main;

public class OnBreak implements Listener{
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		@SuppressWarnings("unused")
		Player p = e.getPlayer();
		final Block b = e.getBlock();
		Location loc = b.getLocation();
		
		final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1, loc.getZ());
		if(b.getType() == Material.STONE){
			if(loc1.getBlock().getType() == Material.ENDER_STONE){
				Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
					public void run() {
						if(loc1.getBlock().getType() == Material.ENDER_STONE){
							b.setType(Material.STONE);
						}
					}
				}, 30L);
			}
		}
	}
}