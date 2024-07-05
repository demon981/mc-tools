package dev_Tools.demonek.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import dev_Tools.demonek.objects.User;
import dev_Tools.demonek.utils.Util;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			User user = User.get(player);
			if(user.isGod()){
				event.setCancelled(true);
			}
		}
	}
	
	public void OnPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        Player k = e.getEntity().getKiller();
        e.setDeathMessage("§8[§2MC2U.PL§8] §7Gracz §e" + p.getName() + "§7 zostal zabity przez §e" + k.getName());
        if(p instanceof Player){
			Util.sendTitle((Player) p, "&4Zginales!", 5, 15, 15);
			Util.sendSubTitle((Player) p, "&7Zabil Cie gracz &e" + k.getName(), 5, 15, 15);
		}
    }

}
