package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcPomoc implements Executor {
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}

		if (!sender.hasPermission("dev_Tools.cmd.pomoc")) {
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.pomoc&8)");
			return;
		}
		Player p = (Player) sender;
		Util.sendMessage(p, "&6&l* &ePomoc &6&l*");
		Util.sendMessage(p, "&6&l* &e/gildia &8- &eWyswietla wszystkie komendy dotyczace gildii.");
		Util.sendMessage(p, "&6&l* &e/spawn &8- &eSprawdz koordynaty spawnu juz teraz!");
		Util.sendMessage(p, "&6&l* &e/vip &8- &eInformacje nt. unikalnej rangi na serwerze.");
		Util.sendMessage(p, "&6&l* &e/drop &8- &eWyswietla informacje o stanie dropow.");
		Util.sendMessage(p, "&6&l* &e/helpop &8- &eWyslij zgloszenie na gracza ktory lamie regulamin!");
		Util.sendMessage(p, "&6&l* &ePomoc &6&l*");
	}

}
