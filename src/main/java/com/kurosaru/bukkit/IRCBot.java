package com.kurosaru.bukkit;

import org.jibble.pircbot.*;

public class IRCBot extends PircBot {
    
    public IRCBot() {
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
    }
    
}