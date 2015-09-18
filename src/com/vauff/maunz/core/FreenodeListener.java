package com.vauff.maunz.core;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class FreenodeListener extends ListenerAdapter<PircBotX>
{
	public void onMessage(MessageEvent<PircBotX> event) throws Exception 
	{
		if (event.getUser().getNick().equals("SteamDB")) 
		{
			if (event.getMessage().contains("App: ") && event.getMessage().contains("730") && event.getMessage().contains("Counter-Strike: Global Offensive")) 
			{
				Main.esperBot.sendIRC().message("#bl4ckscor3", "bl4ckscor3, Vauff, SteamDB has spotted an update for CS:GO! https://steamdb.info/app/730/history/");
			}
		}
	}
}