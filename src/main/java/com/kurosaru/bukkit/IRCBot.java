package com.kurosaru.bukkit;

import org.jibble.pircbot.*;
import org.bukkit.Server;

public class IRCBot extends PircBot {
	
	private org.bukkit.Server Server;
	
    public IRCBot(org.bukkit.Server Server) {
    	this.Server = Server;
        this.setName("cbIRCBot");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        else if (message.equalsIgnoreCase("test")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, "Simple IRC Communication Test");
        }
        
        this.Server.broadcastMessage("{IRC}["+sender+"]: "+message);
        
        //this.Instance.SendMessageToGame("{IRC}["+sender+"]: "+message);
    }
    
}