package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcGod implements Executor {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}

		if (!sender.hasPermission("dev_Tools.cmd.god")) {
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.god&8)");
			return;
		}
		Player p = (Player) sender;
		Util.sendMessage(p, "&8[&2dev_Tools&8] Komenda nie skonczona!");
	}
}
