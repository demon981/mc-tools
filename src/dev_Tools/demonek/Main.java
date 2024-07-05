package dev_Tools.demonek;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev_Tools.demonek.commands.Commands;
import dev_Tools.demonek.data.DataManager;
import dev_Tools.demonek.data.FileManager;
import dev_Tools.demonek.listeners.ChatFormatListener;
import dev_Tools.demonek.listeners.EntityDamage;
import dev_Tools.demonek.listeners.OnBreak;
import dev_Tools.demonek.listeners.OnPlace;
import dev_Tools.demonek.listeners.PlayerChat;
//import dev_Tools.demonek.listeners.PlayerChat;
import dev_Tools.demonek.listeners.PlayerJoin;
import dev_Tools.demonek.listeners.PlayerLogin;
import dev_Tools.demonek.listeners.PlayerMove;
import dev_Tools.demonek.listeners.PlayerQuit;
import dev_Tools.demonek.listeners.ServerList;
import dev_Tools.demonek.listeners.Stoniarka;
import dev_Tools.demonek.objects.Chat;

public class Main extends JavaPlugin {

	public static Main instance;
	public boolean disabling;
	public List<String> autoMSG;
	public int autoMSGNum;

	@Override
	public void onLoad() {
		new Commands().register();
	}

    @SuppressWarnings("deprecation")
	public void onEnable() {
		instance = this;
		FileManager.check();
		//DataManager.load();
		Chat.setChat(true);
		PluginManager pm = Bukkit.getPluginManager();
		Stoniarka.createRecipe();
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerLogin(), this);
		pm.registerEvents(new PlayerMove(), this);
		pm.registerEvents(new PlayerQuit(), this);
		pm.registerEvents(new OnPlace(), this);
		pm.registerEvents(new OnBreak(), this);
		pm.registerEvents(new ServerList(),  this);
		pm.registerEvents(new ChatFormatListener(), this);
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				DataManager.save();
			}
		}, 5 * 20, 5 * 20);
		System.out.println("§8[§4dev_Tools§8] §fAutor: DeMoNeK_");
		System.out.println("§8[§4dev_Tools§8] §fWersja pluginu: 0.1");
		System.out.println("§8[§4dev_Tools§8] §fPlugin przeznaczony dla serwera: easyhc.pl");
	}

	public void onDisable() {
		disabling = true;
		DataManager.save();
	}

	public static String getVersion() {
		return instance.getDescription().getVersion();
	}

	public static String getPluginName() {
		return instance.getDescription().getName();
	}

	public boolean isDisabling() {
		return disabling;
	}

	public static Main getInstance() {
		if (instance == null)
			return new Main();
		return instance;
	}

	
}
