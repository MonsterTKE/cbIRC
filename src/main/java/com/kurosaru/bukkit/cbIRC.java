package com.kurosaru.bukkit;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import com.kurosaru.bukkit.IRCBot;

public class cbIRC extends JavaPlugin {

	private Logger Log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		this.LogMessage("Enabled!");
		this.Bot();
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
			IRCBot bot = new IRCBot();
		    bot.setVerbose(true);
		    bot.connect("irc.esper.net");
		    bot.joinChannel("#monstercraft");
		} catch (Exception e) {
			//this.LogMessage(e.getMessage());
		}
	}

}
