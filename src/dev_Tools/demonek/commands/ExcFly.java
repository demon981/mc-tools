package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcFly implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("dev_Tools.cmd.fly")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.fly&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			if(p.getAllowFlight()){
				p.setAllowFlight(false);
				Util.sendMessage(p, "&8» &7Pomyslnie wylaczyles sobie latanie");
				return;
			} else {
				p.setAllowFlight(true);
				Util.sendMessage(p, "&8» &7Pomyslnie wlaczyles sobie latanie");
				return;
			}
		} else {
			if(args.length == 1){
				Player other = Bukkit.getPlayer(args[0]);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(!p.hasPermission("dev_Tools.cmd.fly.other")){
					Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.fly.other&8)");
					return;
				}
				
				if(other.getAllowFlight()){
					other.setAllowFlight(false);
					Util.sendMessage(p, "&8» &7Pomyslnie wylaczyles latanie graczowi: &4" + other.getName());
					Util.sendMessage(other, "&8» &7Administrator: &4" + p.getName() + " &7wylaczyl ci latanie!");
					for(Player admin : Bukkit.getOnlinePlayers()){
						if(admin.hasPermission("dev_Tools.socialspy")){
							Util.sendMessage(admin, "&8[&6OKO BOGA&8] &eAdmin: " + p.getName() + " wylaczyl latanie graczowi: " + other.getName());
						}
					}
					return;
				} else {
					other.setAllowFlight(true);
					Util.sendMessage(p, "&8» &7Pomyslnie wlaczyles latanie graczowi: &4" + other.getName());
					Util.sendMessage(other, "&8» &7Administrator: &4" + p.getName() + " &7wlaczyl ci latanie!");
					for(Player admin : Bukkit.getOnlinePlayers()){
						if(admin.hasPermission("dev_Tools.socialspy")){
							Util.sendMessage(admin, "&8[&6OKO BOGA&8] &eAdmin: " + p.getName() + " wlaczyl latanie graczowi: " + other.getName());
						}
					}
					return;
				}
			}
		}
	}
}
