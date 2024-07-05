package dev_Tools.demonek.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev_Tools.demonek.utils.HomeUtil;
import dev_Tools.demonek.utils.Util;

public class PlayerQuit implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		HomeUtil.removePlayerHomeTeleport(player);
		
		for(Player all : Bukkit.getOnlinePlayers()){
			Util.sendMessage(all, "&8[&4&l-&8] &7" + player.getName());
		}
	}

}
