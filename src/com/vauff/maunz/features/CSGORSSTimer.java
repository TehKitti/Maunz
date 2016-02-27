package com.vauff.maunz.features;

import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;

import org.pircbotx.Colors;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.ParsingFeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class CSGORSSTimer
{
	private static String lastTitle = "";

	public static Runnable timer = new Runnable()
	{
		public void run()
		{
			URL feedUrl = null;
			SyndFeed feed = null;

			try
			{
				if (Main.devMode)
				{
					feedUrl = new URL("http://geforcemods.net/test.xml");
				}
				else
				{
					feedUrl = new URL("http://blog.counter-strike.net/index.php/feed/");
				}

				feed = new SyndFeedInput().build(new XmlReader(feedUrl));
				SyndEntry latestPost = feed.getEntries().get(0);
				SyndEntry secondLatestPost = feed.getEntries().get(1);

				if (!latestPost.getTitle().equals(lastTitle) && !lastTitle.equals("") && !latestPost.getTitle().equals("") && Util.isEnabled)
				{
					if (lastTitle.equals(secondLatestPost.getTitle()))
					{
						String msg = (Colors.DARK_GREEN + "New CS:GO blog post: " + Colors.BLUE + latestPost.getTitle() + Colors.NORMAL + " " + latestPost.getLink()).replace("\n", "");

						Logger.log.info("Detected a new CS:GO blog post called " + latestPost.getTitle() + ". Sending notification to " + Util.mainChannel);
						Logger.botMsg(Util.mainChannel, msg);
						Main.esperBot.sendIRC().message(Util.mainChannel, msg);
					}
					else
					{
						String msg = (Colors.DARK_GREEN + "New CS:GO blog post: " + Colors.BLUE + latestPost.getTitle() + Colors.NORMAL + " " + latestPost.getLink()).replace("\n", "");

						Logger.log.info("Detected a new CS:GO blog post called " + latestPost.getTitle() + ". Sending notification to " + Util.mainChannel);
						Logger.botMsg(Util.mainChannel, msg);
						Main.esperBot.sendIRC().message(Util.mainChannel, msg);

						String secondMsg = (Colors.DARK_GREEN + "New CS:GO blog post: " + Colors.BLUE + secondLatestPost.getTitle() + Colors.NORMAL + " " + secondLatestPost.getLink()).replace("\n", "");

						Logger.log.info("Detected a new CS:GO blog post called " + secondLatestPost.getTitle() + ". Sending notification to " + Util.mainChannel);
						Logger.botMsg(Util.mainChannel, secondMsg);
						Main.esperBot.sendIRC().message(Util.mainChannel, secondMsg);
					}
				}

				lastTitle = latestPost.getTitle();
			}
			catch (UnknownHostException | FileNotFoundException | ParsingFeedException e)
			{
				Logger.log.error("Failed to connect to the CS:GO blog RSS feed, automatically retrying in 1 minute");
			}
			catch (Exception e)
			{
				Logger.log.error("", e);
			}
		}
	};
}