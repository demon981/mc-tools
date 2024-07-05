package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcExp implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("dev_Tools.cmd.exp")){
			Util.sendMessage(sender, "&8[&2MC2U.PL&8] &cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.exp&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			Util.sendMessage(p, "&8» &7Poprawne uzycie: &4/exp &8[&4set&8|&4give&8|&4giveall&8|&4remove&8] &8[&4gracz&8] &8[&4ilosc&8]");
			return;
		} else {
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("giveall")){
					int exp = 0;
					try{
						exp = Integer.valueOf(args[1]);
					} catch(NumberFormatException e){
						Util.sendMessage(p, "&4Blad: &cPodales nieprawidlowa liczbe! &8(&7" + exp + "&8)");
						return;
					}
					for(Player targets : Bukkit.getOnlinePlayers()){
						targets.setLevel(targets.getLevel() + exp);
						Util.sendMessage(p, "&8» &7Pomyslnie dales calemu serwerowi poziom doswiadczenia: &4+" + exp);
						Util.broadcast("&8[&2MC2U.PL&8]  &7Administrator: &4" + p.getName() + "&7 rozdal calemu serwerowi: &4EXP +" + exp, true);
					}
				}
			}
			if(args.length >= 3){
				Player target = Bukkit.getPlayer(args[1]);
				if(target == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(args[0].equalsIgnoreCase("give")){
					int exp = 0;
					try{
						exp = Integer.valueOf(args[2]);
					} catch(NumberFormatException e){
						Util.sendMessage(p, "&4Blad: &cPodales nieprawidlowa liczbe! &8(&7" + exp + "&8)");
						return;
					}
					target.setLevel(target.getLevel() + exp);
					Util.sendMessage(p, "&8» &7Pomyslnie dales graczowi &4"+ target.getName() +"&7 poziom doswiadczenia &4+" + exp + "&7!");
				}
				else if(args[0].equalsIgnoreCase("set")){
					int exp = 0;
					try{
						exp = Integer.valueOf(args[2]);
					} catch(NumberFormatException e){
						Util.sendMessage(p, "&4Blad: &cPodales nieprawidlowa liczbe! &8(&7" + exp + "&8)");
						return;
					}
					target.setLevel(exp);
					Util.sendMessage(p, "&8» &7Pomyslnie ustawiles graczowi &4"+ target.getName() +"&7 poziom doswiadczenia &4" + exp + "&7!");
				}
				else if(args[0].equalsIgnoreCase("remove")){
					int exp = 0;
					try{
						exp = Integer.valueOf(args[2]);
					} catch(NumberFormatException e){
						Util.sendMessage(p, "&4Blad: &cPodales nieprawidlowa liczbe! &8(&7" + exp + "&8)");
						return;
					}
					target.setLevel(target.getLevel() - exp);
					Util.sendMessage(p, "&8» &7Pomyslnie zabrales graczowi &4"+ target.getName() +"&7 poziom doswiadczenia &4-" + exp + "&7!");
				}
			}
		}
	}

}
