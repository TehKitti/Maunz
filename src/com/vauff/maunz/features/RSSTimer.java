package com.vauff.maunz.features;

import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;

import org.pircbotx.Colors;

import com.vauff.maunz.core.Main;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.ParsingFeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RSSTimer
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
				feedUrl = new URL("http://blog.counter-strike.net/index.php/feed/");
				feed = new SyndFeedInput().build(new XmlReader(feedUrl));
				SyndEntry latestPost = feed.getEntries().get(0);

				if (!latestPost.getTitle().equals(lastTitle) && !lastTitle.equals("") && !latestPost.getTitle().equals(""))
				{
					Main.esperBot.sendIRC().message("#bl4ckscor3", (Colors.DARK_GREEN + "New CS:GO blog post: " + Colors.BLUE + latestPost.getTitle() + Colors.NORMAL + " " + latestPost.getLink()).replace("\n", ""));
				}

				lastTitle = feed.getEntries().get(0).getTitle();
			}
			catch (UnknownHostException | FileNotFoundException | ParsingFeedException e)
			{
				Main.logger.info("Failed to connect to the CS:GO blog RSS feed, automatically retrying in 1 minute");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	};
}