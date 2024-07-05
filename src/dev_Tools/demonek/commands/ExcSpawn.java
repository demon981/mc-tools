package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcSpawn implements Executor {
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}

		if (!sender.hasPermission("dev_Tools.cmd.spawn")) {
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.spawn&8)");
			return;
		}
		Player p = (Player) sender;
		Util.sendMessage(p, "&8-----------[[ &bSpawn &8]]-----------");
		Util.sendMessage(p, "&1<> &bKoordynaty spawnu &8- &9x: 0, y: 75, z: 0");
		Util.sendMessage(p, "&8--------------------------------------");
		
		for (Player p2 : Bukkit.getOnlinePlayers()) {
			Util.sendAction(p2, "&ePrzypominamy, ze serwer chroniony jest przez profesionalna ekipe!");
		}
	}

}
