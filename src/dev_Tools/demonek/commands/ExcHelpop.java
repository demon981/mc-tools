package dev_Tools.demonek.commands;

import java.util.Map;
import java.util.WeakHashMap;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import dev_Tools.demonek.commands.utils.Executor;
import dev_Tools.demonek.utils.Util;

public class ExcHelpop implements Executor{
	
	private Map<CommandSender, Long> time = new WeakHashMap<CommandSender, Long>();
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("dev_Tools.cmd.helpop")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7dev_Tools.cmd.helpop&8)");
			return;
		}
		if(args.length == 0){
			Util.sendMessage(sender, "&8» &7Poprawne uzycie: &4/helpop &8[&4wiadomosc&8]");
			return;
		} else {
			 Long t = (Long)this.time.get(sender);
			 long delay = 3;
			 if(!sender.hasPermission("dev_Tools.bypass")){
				 if((t != null) && (System.currentTimeMillis() - t.longValue() < delay * 1000)){
					 Util.sendMessage(sender, "&4Blad: &cNa helpopie bedziesz mogl napisac za &4" + delay + " sekund!");
					 return;
				 }
			 }
			 StringBuilder sb = new StringBuilder();
			 for(String a : args){
				 if(sb.length() > 0){
					 sb.append(" ");
				 }
				 sb.append(a);
			 }
			 if(sender instanceof Player){
				 Player p = (Player) sender;
				 IChatBaseComponent title = ChatSerializer.a("{\"text\":\"" + Util.colored("&4EasyHC.pl") + "\"}");
				 IChatBaseComponent subtitle = ChatSerializer.a("{\"text\":\"" + Util.colored("&7Twoja wiadomosc zostala wyslana!") + "\"}");
				 PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, title, 3, 4, 3);
				 PacketPlayOutTitle packetsubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitle, 3, 4, 3);
				 ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packetTitle);
				 ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packetsubTitle);
			 } else {
				 Util.sendMessage(sender, "&7Twoja wiadomosc zostala wyslana do administracji!");
				 return;
			 }
			 for(Player admins : Bukkit.getOnlinePlayers()){
				 if(admins.hasPermission("dev_Tools.cmd.helpop.read")){
					 Util.sendMessage(admins, "&8[&6OKO BOGA&8]  &e" + sender.getName() + " pisze: &e" + sb.toString());
				 }
			 }
			 return;
		}
		
	}
}
