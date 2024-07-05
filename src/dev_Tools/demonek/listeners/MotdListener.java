package dev_Tools.demonek.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import dev_Tools.demonek.Main;
import dev_Tools.demonek.utils.ChatUtil;

public class MotdListener
implements Listener
{
    private Main plugin;

    public MotdListener(Main plugin){
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }
	@EventHandler
	public void onSeverListPing(ServerListPingEvent e) {
		e.setMotd(ChatUtil.fixColor(Main.getInstance().getConfig().getString("motd.linia1") + "\n" + ChatUtil.fixColor(Main.getInstance().getConfig().getString("motd.linia2"))));
	}

}