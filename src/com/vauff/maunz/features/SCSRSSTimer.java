package com.vauff.maunz.features;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;

import org.pircbotx.Colors;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.ParsingFeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class SCSRSSTimer
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
					feedUrl = new URL("http://feeds.feedburner.com/ScsSoftwaresBlog?format=xml");
				}

				feed = new SyndFeedInput().build(new XmlReader(feedUrl));
				SyndEntry latestPost = feed.getEntries().get(0);

				if (!latestPost.getTitle().equals(lastTitle) && !lastTitle.equals("") && !latestPost.getTitle().equals("") && Util.isEnabled)
				{
					String msg = (Colors.DARK_GREEN + "New SCS blog post: " + Colors.BLUE + latestPost.getTitle() + Colors.NORMAL + " " + getLink(latestPost));

					Logger.log.info("Detected a new SCS blog post called \"" + latestPost.getTitle() + "\". Sending notification to " + Util.mainChannel);
					Logger.botMsg(Util.mainChannel, msg);
					Main.esperBot.sendIRC().message(Util.mainChannel, msg);
				}

				lastTitle = latestPost.getTitle();
			}
			catch (UnknownHostException | FileNotFoundException | ParsingFeedException | ConnectException e)
			{
				Logger.log.error("Failed to connect to the SCS blog RSS feed, automatically retrying in 1 minute");
			}
			catch (Exception e)
			{
				Logger.log.error("", e);
			}
		}
	};

	private static String getLink(SyndEntry latestPost)
	{
		String oldLink = latestPost.getLink().replace("\n", "");
		String oldLinkSplit = oldLink.substring(oldLink.lastIndexOf('/') + 1);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String date = "";

		if (month < 10)
		{
			date = Calendar.getInstance().get(Calendar.YEAR) + "/" + "0" + month;
		}
		else
		{
			date = Calendar.getInstance().get(Calendar.YEAR) + "/" + month;
		}

		return "http://blog.scssoft.com/" + date + "/" + oldLinkSplit;
	}
}