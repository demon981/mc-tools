package dev_Tools.demonek.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcBroadcast implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("dev_Tools.cmd.broadcast")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.broadcast&8)");
			return;
		}
		if(args.length == 0){
			Util.sendMessage(sender, "&8» &7Poprawne uzycie: &4/broadcast &8[&4wiadomosc&8]");
			return;
		} else {
			StringBuilder sb = new StringBuilder();
			for(String s : args){
				if(sb.length() > 0){
					sb.append(" ");
				}
				sb.append(s);
			}
			Util.broadcast("&8[&4~&8] &7" + sb.toString(), true);
			if(sender instanceof Player){
				Util.sendTitle((Player) sender, "&4EasyHC.pl", 5, 15, 15);
				Util.sendSubTitle((Player) sender, "&7"+ sb.toString(), 5, 15, 15);
			}
		}
	}

}
