package com.vauff.maunz.features;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class ImgurCorrector extends ListenerAdapter
{
	public void onMessage(MessageEvent event) throws Exception
	{
		try
		{
			if (Util.isEnabled == true)
			{
				String[] args = event.getMessage().split(" ");

				for (String arg : args)
				{
					if (arg.contains("www.") || arg.contains("http://") || arg.contains("https://"))
					{
						if (arg.contains("imgur") && !arg.contains("i.imgur") && !arg.contains("/gallery/") && !arg.contains("/a/"))
						{
							String constructedLink = "https://i.imgur.com/";

							if (event.getChannel().getName().equals("#bl4ckscor3"))
							{
								Thread.sleep(4000);
							}

							if (arg.contains("www."))
							{
								if (!arg.contains("https://") && !arg.contains("http://"))
								{
									constructedLink = constructedLink + arg.split("/")[1] + ".png";
								}
								else
								{
									constructedLink = constructedLink + arg.split("/")[3] + ".png";
								}
							}
							else
							{
								constructedLink = constructedLink + arg.split("/")[3] + ".png";
							}

							Util.msg(event, "Direct link: " + constructedLink);
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}
