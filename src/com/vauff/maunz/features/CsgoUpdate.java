package com.vauff.maunz.features;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.pircbotx.Colors;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class CsgoUpdate extends ListenerAdapter<PircBotX>
{
	private String lastChangelistNumber = "";

	public void onMessage(MessageEvent<PircBotX> event) throws Exception
	{
		if ((event.getUser().getNick().equals("SteamDB")) && Util.isEnabled == true)
		{
			if (event.getMessage().contains("https://steamdb.info/changelist/"))
			{
				lastChangelistNumber = Colors.removeColors(event.getMessage().split(" ")[2]);
			}

			if (Colors.removeColors(event.getMessage()).contains("App: 730 - Counter-Strike: Global Offensive"))
			{
				Document doc = null;
				boolean trystatus = true;

				while (trystatus)
				{
					try
					{
						doc = Jsoup.connect("https://steamdb.info/app/730/history").userAgent(" ").get();
						trystatus = false;
					}
					catch (HttpStatusException e)
					{
						e.printStackTrace();
						Thread.sleep(5000);
					}
				}

				String html = doc.select("div[data-changeid=\"" + lastChangelistNumber + "\"]").text();

				if (html.contains("branches/public/buildid"))
				{
					Main.esperBot.sendIRC().message("#bl4ckscor3", "bl4ckscor3, Vauff, SteamDB has spotted an update for CS:GO on the 730 branch that was pushed to the Steam client! https://steamdb.info/app/730/history/ http://blog.counter-strike.net/index.php/category/updates/");
				}

				if (html.contains("branches/dpr/buildid"))
				{
					Main.esperBot.sendIRC().message("#bl4ckscor3", "SteamDB has spotted an update for CS:GO on the 730 branch, this means an update might be coming. https://steamdb.info/app/730/history/");
				}
			}

			if (Colors.removeColors(event.getMessage()).contains("App: 741 - SteamDB Unknown App 741 (Counter-Strike Global Offensive - Valve Dedicated Server) (needs token)"))
			{
				Main.esperBot.sendIRC().message("#bl4ckscor3", "SteamDB has spotted an update for CS:GO on the 741 branch, this means that an update is definitely coming! https://steamdb.info/app/741/history/");
			}
		}
	}
}