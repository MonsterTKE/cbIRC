package com.kurosaru.bukkit;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class cbIRC extends JavaPlugin {

	private Logger Log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		this.LogMessage("Enabled!");
	}
	
	public void onDisable() {
		this.LogMessage("Disabled!");
	}
	
	protected void LogMessage(String Message) {
		PluginDescriptionFile PDFile = this.getDescription();
		this.Log.info(PDFile.getName()+" "+PDFile.getVersion()+" : "+Message);
	}

}
