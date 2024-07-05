package dev_Tools.demonek.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev_Tools.demonek.utils.ChatUtil;


public class ChatFormatListener implements Listener{
	
	@EventHandler
	public void onChat(final AsyncPlayerChatEvent PCHAT){
		final Player p = PCHAT.getPlayer();
		if(p.hasPermission("chat.gracz")){
			PCHAT.setFormat(ChatUtil.fixColor("&7"+p.getName()+" &8>> &7%2$s"));
		}
		if(p.hasPermission("chat.vip")){
			PCHAT.setFormat(ChatUtil.fixColor("&8[&6Vip&8] &a"+p.getName()+" &8>> &e%2$s"));
		}
		if(p.hasPermission("chat.admin")){
			PCHAT.setFormat(ChatUtil.fixColor("&8[&cAdmin&8] &3"+p.getName()+" &8>> &c%2$s"));
		}
		if(p.hasPermission("chat.helper")){
			PCHAT.setFormat(ChatUtil.fixColor("&8[&3Helper&8] &2"+p.getName()+" &8>> &c%2$s"));
		}
		if(p.isOp()){
			PCHAT.setFormat(ChatUtil.fixColor("&8[&4Wlasciciel&8] &5"+p.getName()+" &8>> &c%2$s"));
		}
	}
	@EventHandler
	public void KOLOROWE(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if (p.isOp()){
			return;
		}
		String a2 = e.getMessage();
		e.setMessage(ChatUtil.fixColor(a2));
	}
}