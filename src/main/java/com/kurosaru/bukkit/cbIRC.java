package com.kurosaru.bukkit;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.kurosaru.bukkit.IRCBot;

public class cbIRC extends JavaPlugin {

	private Logger Log = Logger.getLogger("Minecraft");
	private IRCBot bot;
	
	public void onEnable() {
		this.LogMessage("Enabled!");
		this.Bot();
		
		PluginManager PM = this.getServer().getPluginManager();
		
		PM.registerEvent(Event.Type.PLAYER_CHAT, new cbIRCPlayerListener(this.bot), Priority.Highest, this);
		
	}
	
	public void onDisable() {
		this.LogMessage("Disabled!");
	}
	
	protected void LogMessage(String Message) {
		PluginDescriptionFile PDFile = this.getDescription();
		this.Log.info(PDFile.getName()+" "+PDFile.getVersion()+" : "+Message);
	}
	
	protected void Bot() {
		try {
			this.bot = new IRCBot(this.getServer());
			this.bot.setVerbose(false);
			this.bot.connect("irc.esper.net");
			this.bot.joinChannel("#monstercraft");
		} catch (Exception e) {
			//this.LogMessage(e.getMessage());
		}
	}
	
	public void SendMessageToGame(String Message) {
		this.getServer().broadcastMessage(Message);
	}

}
