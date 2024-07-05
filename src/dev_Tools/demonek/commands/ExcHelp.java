package dev_Tools.demonek.commands;

import org.bukkit.command.CommandSender;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcHelp implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {		
		if(!sender.hasPermission("dev_Tools.cmd.help")){
			Util.sendMessage(sender, "&8[&2MC2U.PL&8] &cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.help&8)");
			return;
		}
		if(args.length == 0){
			Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4dev_Tools&7: &8(&71/10&8)");
			if(sender.hasPermission("dev_Tools.cmd.broadcast")) Util.sendMessage(sender, "&4/broadcast &8[&4wiadomosc&8] - &7Wysyla wiadomosc na serwer");
			if(sender.hasPermission("dev_Tools.cmd.gamemode")) Util.sendMessage(sender, "&4/gamemode &8[&40&8|&41&8|&42&8|&43&8] &8[&4gracz&8] - &7Zmienia tryb gry");
			if(sender.hasPermission("dev_Tools.cmd.helpop")) Util.sendMessage(sender, "&4/helpop &8[&4wiadomosc&8] - &7Kontakt z administracja");
			if(sender.hasPermission("dev_Tools.cmd.exp")) Util.sendMessage(sender, "&4/exp &8[&4set&8|&4give&8|&4remove&8] &8[&4gracz&8] &8[&4ilosc&8] - &7Dawanie punktow expa");
			if(sender.hasPermission("dev_Tools.cmd.heal")) Util.sendMessage(sender, "&4/heal &8([&4gracz&8]) - &7Leczenie");
			if(sender.hasPermission("dev_Tools.cmd.feed")) Util.sendMessage(sender, "&4/feed &8([&4gracz&8]) - &7Jedzenie");
			if(sender.hasPermission("dev_Tools.cmd.fly")) Util.sendMessage(sender, "&4/fly &8([&4gracz&8]) - &7Zmienia tryb latania");
			if(sender.hasPermission("dev_Tools.cmd.tp")) Util.sendMessage(sender, "&4/tp &8[&4gracz&8] &8([&4gracz&8]) - &7Teleportacja gracza");
			if(sender.hasPermission("dev_Tools.cmd.tphere")) Util.sendMessage(sender, "&4/tphere &8[&4gracz&8] - &7Teleportacja gracza do siebie");
			Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 2");
		} else {
			if(args.length >= 1){
				if(args[0].equalsIgnoreCase("1")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4dev_Tools&7: &8(&71/10&8)");
					if(sender.hasPermission("dev_Tools.cmd.broadcast")) Util.sendMessage(sender, "&4/broadcast &8[&4wiadomosc&8] - &7Wysyla wiadomosc na serwer");
					if(sender.hasPermission("dev_Tools.cmd.gamemode")) Util.sendMessage(sender, "&4/gamemode &8[&40&8|&41&8|&42&8|&43&8] &8[&4gracz&8] - &7Zmienia tryb gry");
					if(sender.hasPermission("dev_Tools.cmd.helpop")) Util.sendMessage(sender, "&4/helpop &8[&4wiadomosc&8] - &7Kontakt z administracja");
					if(sender.hasPermission("dev_Tools.cmd.exp")) Util.sendMessage(sender, "&4/exp &8[&4set&8|&4give&8|&4remove&8] &8[&4gracz&8] &8[&4ilosc&8] - &7Dawanie punktow expa");
					if(sender.hasPermission("dev_Tools.cmd.heal")) Util.sendMessage(sender, "&4/heal &8([&4gracz&8]) - &7Leczy gracza");
					if(sender.hasPermission("dev_Tools.cmd.feed")) Util.sendMessage(sender, "&4/feed &8([&4gracz&8]) - &7Najedza gracza");
					if(sender.hasPermission("dev_Tools.cmd.fly")) Util.sendMessage(sender, "&4/fly &8([&4gracz&8]) - &7Zmienia tryb latania");
					if(sender.hasPermission("dev_Tools.cmd.tp")) Util.sendMessage(sender, "&4/tp &8[&4gracz&8] &8([&4gracz&8]) - &7Teleportacja gracza");
					if(sender.hasPermission("dev_Tools.cmd.tphere")) Util.sendMessage(sender, "&4/tphere &8[&4gracz&8] - &7Teleportacja gracza do siebie");
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 2");
				}
				else if(args[0].equalsIgnoreCase("2")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4dev_Tools&7: &8(&72/10&8)");
					if(sender.hasPermission("dev_Tools.cmd.clearinv")) Util.sendMessage(sender, "&4/clearinv &8([&4gracz&8]) - &7Czysci ekwipunek");
					if(sender.hasPermission("dev_Tools.cmd.enchant")) Util.sendMessage(sender, "&4/enchant &8[&4enchant&8] [&4level&8] - &7Enchantuje przedmiot");
					if(sender.hasPermission("dev_Tools.cmd.tppos")) Util.sendMessage(sender, "&4/tppos &8[&4gracz&8] [&4x&8] [&4y&8] [&4z&8] - &7Teleportuje gracza w dane miejsce");
					if(sender.hasPermission("dev_Tools.cmd.chat")) Util.sendMessage(sender, "&4/chat &8[&4on&8|&4off&8|&4cc&8] - &7Zarzadzanie czatem");
					if(sender.hasPermission("dev_Tools.cmd.god")) Util.sendMessage(sender, "&4/god &8([&4gracz&8]) - &7Wlacza lub wylacza niesmiertelnosc");
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 3");
		
				}
				else if(args[0].equalsIgnoreCase("3")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4dev_Tools&7: &8(&710/10&8)");
		
					Util.sendMessage(sender, "&8» &7Pluginu przeznaczony dla: easyhc.pl");
					Util.sendMessage(sender, "&8» &7Autor pluginu: &4DeMoNeK_");
					Util.sendMessage(sender, "&8» &7Youtube: &4_dev DeMoNeK_");
					Util.sendMessage(sender, "&8» &7Github: &4github.com/DevJumpDj");
				}
			}
		}
	}
}
