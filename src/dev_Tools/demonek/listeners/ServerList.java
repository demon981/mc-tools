package dev_Tools.demonek.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerList implements Listener {
	
	public void onPing(ServerListPingEvent e) {
		if (Bukkit.hasWhitelist()) 
		{
			e.setMotd("§4§lMC2U.PL §8» §cNa serwerze aktualnie trwaja prace techniczne! §eWidzimy sie niebawem!");
			e.setMaxPlayers(0);
		} 
		else
		{
			e.setMotd("§4§lMC2U.PL §8» §cNajlepszy serwer Hardcore w §4Pol§fsce§c!");
			e.setMaxPlayers(1337);
		}
	}

}
