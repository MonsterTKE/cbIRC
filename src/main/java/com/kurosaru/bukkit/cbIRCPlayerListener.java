package com.kurosaru.bukkit;

import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;
import org.jibble.pircbot.*;

public class cbIRCPlayerListener extends PlayerListener {
	
	private IRCBot bot;
	
	public cbIRCPlayerListener(IRCBot bot) {
		this.bot = bot;
	}

	public void onPlayerChat(PlayerChatEvent event) {
		if (event.isCancelled()) {  return; } 
		
		this.bot.sendMessage("#monstercraft",event.getPlayer().getName()+": "+event.getMessage());
		
	}
}
