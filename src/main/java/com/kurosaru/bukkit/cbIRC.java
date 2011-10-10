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
	
	private String IRCServer;
	private String PublicIRCChannel;
	private String AdminIRCChannel;
	private String IRCName;
	
	protected void LoadConfigs() {
		this.getConfiguration().load();
		this.IRCServer = this.getConfiguration().getString("IRCSERVER","NULL");
		this.PublicIRCChannel = this.getConfiguration().getString("IRCPublicChannel","NULL");
		this.AdminIRCChannel = this.getConfiguration().getString("IRCAdminChannel","NULL");
		this.IRCName = this.getConfiguration().getString("IRCName", "cbIRCBot");
		
		if (this.IRCServer.contains("NULL")) {
			this.getConfiguration().setHeader("IRC");
			this.getConfiguration().setProperty("IRCSERVER", "NULL");
			this.getConfiguration().setProperty("IRCPublicChannel","NULL");
			this.getConfiguration().setProperty("IRCAdminChannel","NULL");
			this.getConfiguration().setProperty("IRCName", "cbIRCBot");
			this.getConfiguration().save();
		}
		
	}
	
	public void onEnable() {
		this.LogMessage("Enabled!");
		this.LoadConfigs();
		this.Bot();
		this.bot.sendMessage(this.PublicIRCChannel,"IRCBot Loaded (MineCraft server is up!)");
		PluginManager PM = this.getServer().getPluginManager();
		
		PM.registerEvent(Event.Type.PLAYER_CHAT, new cbIRCPlayerListener(this.bot), Priority.Highest, this);
	}
	
	public void onDisable() {
		this.bot.sendMessage(this.PublicIRCChannel,"IRCBot Disabled (Server might be shutting down!)");
		this.LogMessage("Disabled!");
	}
	
	protected void LogMessage(String Message) {
		PluginDescriptionFile PDFile = this.getDescription();
		this.Log.info(PDFile.getName()+" "+PDFile.getVersion()+" : "+Message);
	}
	
	protected void Bot() {
		if (!this.IRCServer.contains("NULL")) {
			try {
				this.bot = new IRCBot(this.getServer(),this.IRCName);
				this.bot.setVerbose(false);
				this.bot.connect(this.IRCServer);
				this.bot.joinChannel(this.PublicIRCChannel);
			} catch (Exception e) {
				//this.LogMessage(e.getMessage());
			}
		} else {
			this.LogMessage("No IRC Server Set. Plugin will be deactivated.");
		}
	}
	
	public void SendMessageToGame(String Message) {
		this.getServer().broadcastMessage(Message);
	}

}
