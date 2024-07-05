package dev_Tools.demonek.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.objects.Chat;
import dev_Tools.demonek.utils.Util;

public class ExcChat implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("dev_Tools.cmd.chat")){
			Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.chat&8)");
			return;
		}
		if(args.length == 0){
			Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &8» &7Poprawne uzycie: &4/chat &8[&4on&8|&4off&8|&4cc&8]");
			return;
		} else {
			if(args.length >= 1){
				if(args[0].equalsIgnoreCase("on")){
					if(Chat.getChat() == true){
						Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &4Blad: &cChat jest juz wlaczony! Musisz go najpierw wylaczyc");
						return;
					}
					for (Player p : Bukkit.getOnlinePlayers()) {
						Util.sendAction(p, "&eChat zostal wlaczony przez " + sender.getName());
					}
					Chat.setChat(true);
					Util.broadcast("&8[&2EasyHC.pl&8] &7Chat zostal wlaczony przez: &4" + sender.getName(), true);
					Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &8» &7Pomyslnie wlaczyles chat!");
					if(sender instanceof Player){
						Util.sendTitle((Player) sender, "&4CHAT", 5, 15, 15);
						Util.sendSubTitle((Player) sender, "&8» &7Pomyslnie wlaczyles chat!", 5, 15, 15);
					}
				}
				else if(args[0].equalsIgnoreCase("off")){
					if(Chat.getChat() == false){
						Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &4Blad: &cChat jest juz wylaczony! Musisz go najpierw wlaczyc");
						return;
					}
					
					Chat.setChat(false);
					Util.broadcast("&8[&2EasyHC.pl&8] &7Chat zostal wylaczony przez: &4" + sender.getName(), true);
					for (Player p : Bukkit.getOnlinePlayers()) {
						Util.sendAction(p, "&eChat zostal wylaczony przez " + sender.getName());
					}
					Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &8» &7Pomyslnie wylaczyles chat!");
					if(sender instanceof Player){
						Util.sendTitle((Player) sender, "&4CHAT", 5, 15, 15);
						Util.sendSubTitle((Player) sender, "&8» &7Pomyslnie wylaczyles chat!", 5, 15, 15);
					}
				}
				else if(args[0].equalsIgnoreCase("cc")){
					for(int i = 0; i < 101; i++){
						Util.broadcast("", false);
					}
					for (Player p : Bukkit.getOnlinePlayers()) {
						Util.sendAction(p, "&eChat zostal wyczyszony przez " + sender.getName());
					}
					
					Util.broadcast("&8[&2EasyHC.pl&8] &7Chat zostal wyczyszczony przez: &4" + sender.getName(), true);
					Util.sendMessage(sender, "&8[&2EasyHC.pl&8] &8» &7Pomyslnie wyczysciles chat!");
					if(sender instanceof Player){
						Util.sendTitle((Player) sender, "&4CHAT", 5, 15, 15);
						Util.sendSubTitle((Player) sender, "&8» &7Pomyslnie wyczysciles chat!", 5, 15, 15);
					}
				}
			}
		}
	}

}
