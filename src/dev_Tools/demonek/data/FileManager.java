package dev_Tools.demonek.data;

import java.io.File;

import dev_Tools.demonek.Main;
import dev_Tools.demonek.utils.LogUtil;

public class FileManager {

	private static File mainDir = Main.getInstance().getDataFolder();
	private static File users = new File(mainDir, "users");
	private static File bans = new File(mainDir, "bans");
	
	public static void check(){
		if(!mainDir.exists()) mainDir.mkdir();
		if(!users.exists()) users.mkdir();
		LogUtil.info("&aWygenerowano folder: /users/");
		if(!bans.exists()) bans.mkdir();
		LogUtil.info("&aWygenerowano folder: /bans/");
	}
	
	public static File getUsersFolder(){
		return users;
	}

	public static File getBansFolder(){
		return bans;
	}
}
