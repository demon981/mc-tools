package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcGildia implements Executor {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}

		if (!sender.hasPermission("dev_Tools.cmd.gildia")) {
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.gildia&8)");
			return;
		}
		Player p = (Player) sender;
		Util.sendMessage(p, "&6&l* &eSystem Gildii &6&l*");
		Util.sendMessage(p, "&6&l* &e/ginfo &8- &eWyswietli najwazniejsze informacje o gildii.");
		Util.sendMessage(p, "&6&l* &e/sojusz <TAG> &8- &eSluzy do nawiazywania sojuszu miedzy gildiami.");
		Util.sendMessage(p, "&6&l* &e/gczat <TRESC> &8- &eKomunikacja miedzy czlonkami gildii.");
		Util.sendMessage(p, "&6&l* &e/dolacz <TAG> &8- &eZa pomoca tej komendy dolaczysz do gildii.");
		Util.sendMessage(p, "&6&l* &e/opusc &8- &eZa pomoca tej komendy opuscisz gildie.");
		Util.sendMessage(p, "&6&l* &e/gbaza &8- &ePrzenies sie na baze swojej gildii.");
		Util.sendMessage(p, "&6&l* &e/lider <NICK> &8- &eUstaw nowego lidera gildii.");
		Util.sendMessage(p, "&6&l* &e/lista &8- &eWyswietla liste gildii.");
		Util.sendMessage(p, "&6&l* &e/wyrzuc <NICK> &8- &eWyrzuc gracza z gildii.");
		Util.sendMessage(p, "&6&l* &e/zamknij &8- &eUsuwa gildie.");
		Util.sendMessage(p, "&6&l* &e/zastepca <NICK> &8- &eWyznacza zastepce lidera gildii.");
		Util.sendMessage(p, "&6&l* &e/zerwijsojusz <TAG> &8- &eZrywa sojusz z podana gildia.");
		Util.sendMessage(p, "&6&l* &eSystem Gildii &6&l*");
	}
}