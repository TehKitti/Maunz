package com.vauff.maunz.features;

import java.net.ConnectException;
import java.net.UnknownHostException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Logger;
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
					int attempts = 0;

					Thread.sleep(10000);

					while (trystatus)
					{
						try
						{
							doc = Jsoup.connect("https://steamdbb.info/app/730/history").userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36").get();
							trystatus = false;
						}
						catch (HttpStatusException | ConnectException | UnknownHostException e)
						{
							if (attempts < 19)
							{
								Logger.log.error("Failed to connect to the CS:GO SteamDB history page, automatically retrying in 5 seconds");
								attempts++;
								Thread.sleep(5000);
							}
							else
							{
								Logger.log.error("Failed to connect to the CS:GO SteamDB history page 20 times, giving up");
								trystatus = false;
								return;
							}
						}
					}

					String html = doc.select("div[data-changeid=\"" + consistentLastChangelistNumber + "\"]").text();
					String htmlRaw = doc.select("div[data-changeid=\"" + consistentLastChangelistNumber + "\"]").html();

					if (html.contains("branches/public/buildid"))
					{
						String msg = "SteamDB has spotted a public branch update for CS:GO on the 730 app, this means " + Colors.TEAL + "an update was pushed to the Steam client!" + Colors.NORMAL + " https://steamdb.info/app/730/history/";

						Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber);
						Util.msg(Util.mainChannel, msg);
						Util.msg(Util.secondaryChannel, msg);
					}
					else if (html.contains("branches/dpr/buildid"))
					{
						String msg = "SteamDB has spotted a DPR branch update for CS:GO on the 730 app, this means " + Colors.TEAL + "an update is probably coming." + Colors.NORMAL + " https://steamdb.info/app/730/history/";

						Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber);
						Util.msg(Util.mainChannel, msg);
						Util.msg(Util.secondaryChannel, msg);
					}
					else if (html.replaceAll("\\d", "").contains("branches/./buildid") || html.replaceAll("\\d", "").contains("branches/../buildid") || html.replaceAll("\\d", "").contains("branches/.../buildid"))
					{
						String msg = "SteamDB has spotted a version branch update for CS:GO on the 730 app, this means " + Colors.TEAL + "an update might be coming." + Colors.NORMAL + " https://steamdb.info/app/730/history/";

						Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber);
						Util.msg(Util.mainChannel, msg);
						Util.msg(Util.secondaryChannel, msg);
					}
					else if (html.replaceAll("\\d", "").contains("branches/.rc/buildid") || html.replaceAll("\\d", "").contains("branches/..rc/buildid") || html.replaceAll("\\d", "").contains("branches/...rc/buildid"))
					{
						if (!htmlRaw.contains("octicon octicon-diff-removed"))
						{
							String msg = "SteamDB has spotted a beta branch update for CS:GO on the 730 app, this means " + Colors.TEAL + "a beta update was pushed to the Steam client!" + Colors.NORMAL + " https://steamdb.info/app/730/history/";

							Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber);
							Util.msg(Util.mainChannel, msg);
							Util.msg(Util.secondaryChannel, msg);
						}
						else
						{
							String msg = "SteamDB has spotted a version branch update for CS:GO on the 730 app, this means " + Colors.TEAL + "an update might be coming." + Colors.NORMAL + " https://steamdb.info/app/730/history/";

							Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber);
							Util.msg(Util.mainChannel, msg);
							Util.msg(Util.secondaryChannel, msg);
						}
					}
					else
					{
						String msg = "SteamDB has spotted a non-important update for CS:GO on the 730 app, this " + Colors.TEAL + "most likely doesn't mean anything." + Colors.NORMAL + " https://steamdb.info/app/730/history/";

						Logger.log.info("Found a CS:GO 730 update with changelog number " + consistentLastChangelistNumber);
						Util.msg(Util.mainChannel, msg);
						Util.msg(Util.secondaryChannel, msg);
					}
				}

				if (Colors.removeColors(event.getMessage()).contains("App: 741 - SteamDB Unknown App 741 (Counter-Strike Global Offensive - Valve Dedicated Server) (needs token)"))
				{
					String msg = "SteamDB has spotted an update for CS:GO on the 741 app, this means " + Colors.TEAL + "an update is definitely coming!" + Colors.NORMAL + " https://steamdb.info/app/741/history/";

					Util.msg(Util.mainChannel, msg);
					Util.msg(Util.secondaryChannel, msg);
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}