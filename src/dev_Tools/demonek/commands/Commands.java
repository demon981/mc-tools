package dev_Tools.demonek.commands;

import java.util.Arrays;

import dev_Tools.demonek.commands.utils.ExecutorCaller;


public class Commands {

	private static Commands instance;
	
	public Commands(){
		instance = this;
	}
	
	public void register(){
		new ExecutorCaller(new ExcBroadcast(), "broadcast", "dev_Tools.cmd.broadcast", Arrays.asList("bc"));
		new ExecutorCaller(new ExcGameMode(), "gamemode", "dev_Tools.cmd.gamemode", Arrays.asList("gm"));
		new ExecutorCaller(new ExcHelpop(), "helpop", "dev_Tools.cmd.helpop", Arrays.asList("zglos"));
		new ExecutorCaller(new ExcExp(), "exp", "dev_Tools.cmd.exp", Arrays.asList("xp"));
		new ExecutorCaller(new ExcHeal(), "heal", "dev_Tools.cmd.heal", null);
		new ExecutorCaller(new ExcFeed(), "feed", "dev_Tools.cmd.feed", null);
		new ExecutorCaller(new ExcFly(), "fly", "dev_Tools.cmd.fly", null);
		new ExecutorCaller(new ExcTp(), "teleport", "dev_Tools.cmd.tp", Arrays.asList("tp"));
		new ExecutorCaller(new ExcTpHere(), "tphere", "dev_Tools.cmd.tphere", null);
		new ExecutorCaller(new ExcHelp(), "help", null, null);
		new ExecutorCaller(new ExcClearInventory(), "clearinventory", "dev_Tools.cmd.clearinv", Arrays.asList("clearinv", "ci"));
		new ExecutorCaller(new ExcEnchant(), "enchant", "dev_Tools.cmd.enchant", Arrays.asList("ench"));
		new ExecutorCaller(new ExcTppos(), "tppos", "dev_Tools.cmd.tppos", null);
		new ExecutorCaller(new ExcChat(), "chat", "dev_Tools.cmd.chat", null);
		new ExecutorCaller(new ExcGod(), "god", "dev_Tools.cmd.god", null);
		new ExecutorCaller(new ExcGildia(), "gildia", "dev_Tools.cmd.gildia", null);
		new ExecutorCaller(new ExcPomoc(), "pomoc", "dev_Tools.cmd.pomoc", null);
		new ExecutorCaller(new ExcSpawn(), "spawn", "dev_Tools.cmd.spawn", null);
	}
	
	public static Commands getInstance(){
		if(instance == null) return new Commands();
		return instance;
	}
	
}
