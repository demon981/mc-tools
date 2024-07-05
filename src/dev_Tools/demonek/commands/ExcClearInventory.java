package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcClearInventory implements Executor{
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("dev_Tools.cmd.clearinv")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.clearinv&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			PlayerInventory inv = p.getInventory();
			inv.clear();
			inv.setHelmet(null);
			inv.setChestplate(null);
			inv.setLeggings(null);
			inv.setBoots(null);
			Util.sendMessage(p, "&8» &7Pomyslnie wyczysciles swoj ekwipunek!");
			return;
		} else {
			if(args.length >= 1){
				Player other = Bukkit.getPlayer(args[0]);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(!p.hasPermission("dev_Tools.cmd.clearinv.other")){
					Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.clearinv.other&8)");
					return;
				}
				PlayerInventory otherInv = other.getInventory();
				otherInv.clear();
				otherInv.setHelmet(null);
				otherInv.setChestplate(null);
				otherInv.setLeggings(null);
				otherInv.setBoots(null);
				Util.sendMessage(p, "&8» &7Pomyslnie wyczysciles ekwipunek gracza: &4" + other.getName());
				Util.sendMessage(other, "&8» &7Twoj ekwipunek zostal wyczyszczony przez administratora: &4" + p.getName());
				for(Player admin : Bukkit.getOnlinePlayers()){
					if(admin.hasPermission("dev_Tools.socialspy")){
						Util.sendMessage(admin, "&8[&6OKO BOGA&8] &eAdmin: " + p.getName() + " wyczyscil ekwipunek graczowi: " + other.getName());
					}
				}
			}
		}
	}
}
