package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcTp implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("dev_Tools.cmd.tp")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.tp&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			Util.sendMessage(p, "&8» &7Poprawne uzycie: &4/tp &8[&4gracz&8] &8([&4gracz&8])");
			return;
		} else {
			if(args.length == 1){
				Player other = Bukkit.getPlayer(args[0]);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(other.equals(p)){
					Util.sendMessage(p, "&4Blad: &cNie mozesz teleportowac sie do samego siebe!");
					return;
				}
				p.teleport(other.getLocation());
				Util.sendMessage(p, "&8» &7Pomyslnie przeteleportowales sie do gracza: &4" + other.getName());
				return;
			} else {
				if(args.length >= 2){
					Player from = Bukkit.getPlayer(args[0]);
					Player to = Bukkit.getPlayer(args[1]);
					if(from == null || to == null){
						Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
						return;
					}
					if(!p.hasPermission("dev_Tools.cmd.tp.other")){
						Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.tp.other&8)");
						return;
					}
					if(from.equals(to)){
						Util.sendMessage(p, "&4Blad: &cNie mozesz teleportowac tych samych graczy do siebie!");
						return;
					}
					from.teleport(to.getLocation());
					Util.sendMessage(p, "&8» &7Pomyslnie przetelportowales gracza: &4" + from.getName() + "&7 do gracza: &4" + to.getName());
					Util.sendMessage(from, "&8» &7Administrator: &4" + p.getName() + "&7 przeteleportowal ciebie do gracza: &4" + to.getName());
					Util.sendMessage(to, "&8» &7Administrator: &4" + p.getName() + "&7 przetelportowal gracza: &4" + from.getName() + " &7do ciebie!");
					return;
				}
			}
		}
	}
}
