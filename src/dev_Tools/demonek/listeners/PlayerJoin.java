package dev_Tools.demonek.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev_Tools.demonek.objects.User;
import dev_Tools.demonek.utils.Util;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		User user = User.get(player);
		User.get(player);
		user.setGod(false);
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("dev_Tools.spy")){
				Util.sendMessage(all, "&eAdministrator: " + player.getName() + " dolaczyl na serwer!");
			}
			Util.sendMessage(all, "&8[&2&l+&8] &7" + player.getName());
		}
		if(!player.hasPlayedBefore()){
			Util.sendAction(player, "&8[&2dev_Tools&8] &7Witamy na moim serwerze!");
		}
		if(player instanceof Player){
			Util.sendTitle((Player) player, "&4dev_Tools", 5, 15, 15);
			Util.sendSubTitle((Player) player, "&7Witamy na serwerze!", 5, 15, 15);
		}
		    
		    String[] lines = new String[6];
		    lines[0] = " &8&m---------------------------------";
		    lines[1] = ("  &8? &7Witaj, &c" + player.getName());
		    lines[2] = ("  &8? &7Odwiedzilo nas juz &c871 &7unikalnych graczy");
		    lines[3] = ("  &8? &7Aktualnie online jest &c" + Bukkit.getOnlinePlayers().size() + " &c graczy");
		    lines[4] = "  &8? &7WWW: &c/ &8|| &7TeamSpeak3: &c/";
		    lines[5] = " &8&m---------------------------------";
		    String[] arrayOfString1;
		    int j = (arrayOfString1 = lines).length;
		    for (int i = 0; i < j; i++)
		    {
		      String line = arrayOfString1[i];
		      Util.sendMessage(player, line);
		    }
	}

}