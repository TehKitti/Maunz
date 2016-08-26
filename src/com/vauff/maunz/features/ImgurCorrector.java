package com.vauff.maunz.features;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
						else if ((arg.contains("imgur") && !arg.contains("i.imgur")) && (arg.contains("/gallery/") || arg.contains("/a/")))
						{
							if (event.getChannel().getName().equals("#bl4ckscor3"))
							{
								Thread.sleep(4000);
							}

							Document doc = Jsoup.connect(arg).userAgent(" ").get();
							String html = doc.select("div[class=post-images]").html();
							String[] htmlSplit = html.split(" ");
							int images = 0;

							for (String o : htmlSplit)
							{
								if (o.equals("class=\"post-image\">"))
								{
									images++;

									if (images == 2)
									{
										break;
									}
								}
							}

							if (images == 1)
							{
								String linkHtml = doc.select("a[class=zoom]").html();
								String link;

								if (!linkHtml.equals(""))
								{
									link = "https://" + linkHtml.split("\"")[1].split("\\?")[0].replace("//", "");
								}
								else
								{
									linkHtml = doc.select("div[class=post-image]").html();
									link = "https://" + linkHtml.split("\"")[1].split("\\?")[0].replace("//", "");
								}

								Util.msg(event, "Direct link: " + link);
							}
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
