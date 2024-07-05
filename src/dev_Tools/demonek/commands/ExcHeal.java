package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcHeal implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("dev_Tools.cmd.heal")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.heal&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			p.setHealth(20.0D);
			p.setFoodLevel(20);
			p.setFireTicks(0);
			for(PotionEffect potioneffect : p.getActivePotionEffects()){
				p.removePotionEffect(potioneffect.getType());
			}
			Util.sendMessage(p, "&8» &7Pomyslnie zostales uleczony!");
			return;
		} else {
			if(args.length >= 1){
				Player other = Bukkit.getPlayer(args[0]);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(!p.hasPermission("dev_Tools.cmd.heal.other")){
					Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.heal.other&8)");
					return;
				}
				other.setHealth(20.0D);
				other.setFoodLevel(20);
				other.setFireTicks(0);
				for(PotionEffect potioneffect : other.getActivePotionEffects()){
					other.removePotionEffect(potioneffect.getType());
				}
				Util.sendMessage(other, "&8» &7Pomyslnie zostales uleczony przez admina: &4" + p.getName() + "&7!");
				Util.sendMessage(p, "&8» &7Pomyslnie uleczyles gracza: &4" + other.getName());
				for(Player admin : Bukkit.getOnlinePlayers()){
					if(admin.hasPermission("dev_Tools.socialspy")){
						Util.sendMessage(admin, "&8[&6OKO BOGA&8] &eAdmin: " + p.getName() + " uleczyl gracza: " + other.getName());
					}
				}
				return;
			}
		}
	}
}
