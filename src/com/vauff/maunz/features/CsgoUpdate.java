package com.vauff.maunz.features;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class CsgoUpdate extends ListenerAdapter<PircBotX>
{
	public void onMessage(MessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("SteamDB") && Util.isEnabled == true)
		{
			if (event.getMessage().contains("App: ") && event.getMessage().contains("730") && event.getMessage().contains("Counter-Strike: Global Offensive"))
			{
				Main.esperBot.sendIRC().message("#bl4ckscor3", "bl4ckscor3, Vauff, SteamDB has spotted an update for CS:GO on the 730 branch, this means an update might be coming. https://steamdb.info/app/730/history/");
			}

			if (event.getMessage().contains("App: ") && event.getMessage().contains("741") && event.getMessage().contains("Counter-Strike Global Offensive"))
			{
				Main.esperBot.sendIRC().message("#bl4ckscor3", "bl4ckscor3, Vauff, SteamDB has spotted an update for CS:GO on the 741 branch, this means that an update is definitely coming! https://steamdb.info/app/741/history/");
			}
		}
	}
}