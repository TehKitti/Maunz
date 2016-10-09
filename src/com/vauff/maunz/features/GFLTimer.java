package com.vauff.maunz.features;

import java.io.File;
import java.net.SocketTimeoutException;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.pircbotx.Colors;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class GFLTimer
{
	private static File file = new File(Util.getJarLocation() + "lastmap.txt");

	public static Runnable timer = new Runnable()
	{
		public void run()
		{
			try
			{
				Document doc = Jsoup.connect("https://stats.gflclan.com/hlstats.php?game=csgoze").timeout(10000).get();
				String html = doc.select("td[class=game-table-cell]").text();
				String[] htmlSplit = html.split(" ");
				String map = "";

				for (String m : htmlSplit)
				{
					if (m.contains("_"))
					{
						map = m;
						break;
					}
				}

				if (!map.equals("") && !Util.getFileContents("lastmap.txt").equals(map) && Util.isEnabled)
				{
					Util.msg(Util.privateChannel, "GFL Zombie Escape is now playing: " + Colors.MAGENTA + Colors.BOLD + map);
				}

				if (map.equals(""))
				{
					FileUtils.writeStringToFile(file, " ", "UTF-8");
				}
				else
				{
					FileUtils.writeStringToFile(file, map, "UTF-8");
				}
			}
			catch (SocketTimeoutException e)
			{
				Logger.log.error("Failed to connect to the GFL HLStatsX page, automatically retrying in 1 minute");
			}
			catch (Exception e)
			{
				Logger.log.error("", e);
			}
		}
	};
}