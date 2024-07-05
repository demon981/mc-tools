package dev_Tools.demonek.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.UUID;

import org.bukkit.entity.Player;

import dev_Tools.demonek.RangsEnum;

public class Players {
	
	private String nick;
	private String IP;
	private UUID UUID;
	private boolean banned;
	private String banreason;
	private String banadmin;
	private boolean home;
	private long KIT_GRACZ;
	private long KIT_VIP;
	private long KIT_EVIP;
	private Location home_loc;
	private boolean teleporting;
	private boolean god;
	private boolean socialspy;
	private long cooldown = 0L;
	private RangsEnum ranga;
	private Player last_msg;
	
	public Players (final Player player){
		this.nick = player.getName();
		this.IP = player.getPlayer().getAddress().getHostString();
		this.UUID = player.getUniqueId();
		this.banned = false;
		this.banadmin = "";
		this.home = false;
		this.home_loc = null;
		this.ranga = RangsEnum.GRACZ;
		this.god = false;
		this.socialspy = false;
		this.banreason = "";
		this.teleporting = false;
		this.last_msg = null;
	}
	
	public Players (final String stringPlayer){
		this.nick = stringPlayer;
		this.IP = getIP();
		this.UUID = getUuid();
		this.banned = isBanned();
		this.banreason = getBanreason();
		this.banadmin = getBanadmin();
		this.home = isHome();
		this.home_loc = getHome_loc();
		this.teleporting = isTeleporting();
		this.god = isGod();
		this.socialspy = isSocialspy();
		this.last_msg = getLast_msg();
		this.ranga = getRanga();
	}
	
	  public long getCooldown()
	  {
	    return this.cooldown;
	  }
	  
	  public void setCooldown(long cooldown)
	  {
	    this.cooldown = cooldown;
	  }
	  
	public Player getPlayer(){
		return Bukkit.getPlayer(this.nick);
	}
	
	public String getNick(){
		return this.nick;
	}
	
	public String getIP(){
		return this.IP;
	}
	  
    public UUID getUuid() {
        return UUID;
    }
	
	
	public void setIP(String l){
		this.IP = l;
	}
	
	public void setUuid(UUID l){
		this.UUID = l;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public String getBanreason() {
		return banreason;
	}

	public void setBanreason(String banreason) {
		this.banreason = banreason;
	}

	public String getBanadmin() {
		return banadmin;
	}

	public void setBanadmin(String banadmin) {
		this.banadmin = banadmin;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public Location getHome_loc() {
		return home_loc;
	}

	public void setHome_loc(Location home_loc) {
		this.home_loc = home_loc;
	}

	public boolean isTeleporting() {
		return teleporting;
	}

	public void setTeleporting(boolean teleporting) {
		this.teleporting = teleporting;
	}

	public boolean isGod() {
		return god;
	}

	public void setGod(boolean god) {
		this.god = god;
	}

	public boolean isSocialspy() {
		return socialspy;
	}

	public void setSocialspy(boolean socialspy) {
		this.socialspy = socialspy;
	}

	public Player getLast_msg() {
		return last_msg;
	}

	public void setLast_msg(Player last_msg) {
		this.last_msg = last_msg;
	}

	public RangsEnum getRanga() {
		return ranga;
	}

	public void setRanga(RangsEnum ranga) {
		this.ranga = ranga;
	}

	public long getKIT_GRACZ() {
		return KIT_GRACZ;
	}

	public void setKIT_GRACZ(long kIT_GRACZ) {
		KIT_GRACZ = kIT_GRACZ;
	}

	public long getKIT_VIP() {
		return KIT_VIP;
	}

	public void setKIT_VIP(long kIT_VIP) {
		KIT_VIP = kIT_VIP;
	}

	public long getKIT_EVIP() {
		return KIT_EVIP;
	}

	public void setKIT_EVIP(long kIT_EVIP) {
		KIT_EVIP = kIT_EVIP;
	}

}
