package com.vauff.maunz.features;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class CsgoUpdate extends ListenerAdapter
{
	private String lastChangelistNumber = "";
	public static String listeningNick;

	public void onMessage(MessageEvent event) throws Exception
	{
		try
		{
			if ((event.getUser().getNick().equals(listeningNick)) && Util.isEnabled == true)
			{
				if (event.getMessage().contains("https://steamdb.info/changelist/"))
				{
					lastChangelistNumber = Colors.removeColors(event.getMessage().split(" ")[2]);
				}

				if (Colors.removeColors(event.getMessage()).contains("App: 730 - Counter-Strike: Global Offensive"))
				{
					String consistentLastChangelistNumber = lastChangelistNumber;
					Document doc = null;
					boolean trystatus = true;

					Thread.sleep(10000);

					while (trystatus)
					{
						try
						{
							doc = Jsoup.connect("https://steamdb.info/app/730/history").userAgent(" ").get();
							trystatus = false;
						}
						catch (HttpStatusException e)
						{
							Logger.log.error("Failed to connect to the CS:GO SteamDB history page, automatically retrying in 5 seconds");
							Thread.sleep(5000);
						}
					}

					String html = doc.select("div[data-changeid=\"" + consistentLastChangelistNumber + "\"]").text();

					if (html.contains("branches/public/buildid"))
					{
						String msg = "";

						if (Main.devMode)
						{
							msg = "V4uff, SteamDB has spotted an update for CS:GO on the 730 branch that was pushed to the Steam client! https://steamdb.info/app/730/history/";
						}
						else
						{
							msg = "Vauff, SteamDB has spotted an update for CS:GO on the 730 branch that was pushed to the Steam client! https://steamdb.info/app/730/history/";
						}

						Logger.log.info("Found a CS:GO 730 update that got pushed with changelog number " + consistentLastChangelistNumber + ", sending info to " + Util.mainChannel + "...");
						Logger.botMsg(Util.mainChannel, msg);
						Main.esperBot.sendIRC().message(Util.mainChannel, msg);
					}

					else if (html.contains("branches/dpr/buildid"))
					{
						String msg = "SteamDB has spotted an update for CS:GO on the 730 branch, this means an update might be coming. https://steamdb.info/app/730/history/";

						Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber + ", sending info to " + Util.mainChannel + "...");
						Logger.botMsg(Util.mainChannel, msg);
						Main.esperBot.sendIRC().message(Util.mainChannel, msg);
					}
					else
					{
						String msg = "SteamDB has spotted a non-important update for CS:GO on the 730 branch, this most likely doesn't mean anything. https://steamdb.info/app/730/history/";

						Logger.log.info("Found a non-important CS:GO 730 update with changelog number " + consistentLastChangelistNumber + ", sending info to " + Util.mainChannel + "...");
						Logger.botMsg(Util.mainChannel, msg);
						Main.esperBot.sendIRC().message(Util.mainChannel, msg);
					}
				}

				if (Colors.removeColors(event.getMessage()).contains("App: 741 - SteamDB Unknown App 741 (Counter-Strike Global Offensive - Valve Dedicated Server) (needs token)"))
				{
					String msg = "SteamDB has spotted an update for CS:GO on the 741 branch, this means that an update is definitely coming! https://steamdb.info/app/741/history/";

					Logger.log.info("Found a CS:GO 741 update with changelog number " + lastChangelistNumber + ", sending info to " + Util.mainChannel + "...");
					Logger.botMsg(Util.mainChannel, msg);
					Main.esperBot.sendIRC().message(Util.mainChannel, msg);
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}