package com.vauff.maunz.commands;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Benchmark implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "You need to provide a GPU/CPU name to benchmark!");
		}
		else
		{
			String query = Util.addArgs(args, 1);

			if (query.contains(" "))
			{
				query = query.replace(" ", "+");
			}

			Document searchDoc = Jsoup.connect("http://www.passmark.com/search/zoomsearch.php?zoom_query=" + query + "&zoom_cat=5").get();
			String searchHtml = searchDoc.select("div[class=result_title]").html();
			String[] searchHtmlSplit = searchHtml.split(" ");
			String link = "";

			for (String l : searchHtmlSplit)
			{
				if ((l.contains("http://")) && (l.contains("gpu.php") || l.contains("cpu.php")))
				{
					link = l;
					break;
				}
			}

			if (!link.equals(""))
			{
				link = link.split("\"")[1];

				link = link.replace("amp;", "");
				Document benchDoc = Jsoup.connect(link).get();
				String fullDesc = benchDoc.select("table[class=desc]").html().replace("<a href=\"#history\">", "");
				String name = benchDoc.select("span[class=cpuname]").text();
				String score = benchDoc.select("span[style=font-family: Arial, Helvetica, sans-serif;font-size: 35px;	font-weight: bold; color: red;]").text();
				String rank = fullDesc.split("Overall Rank:</span>&nbsp;&nbsp;")[1].split("<")[0];
				String samples = benchDoc.select("td[style=text-align: center]").text().split("Samples: ")[1].split("\\*")[0];
				String ratio = fullDesc.split("Price:</span>&nbsp;&nbsp;")[1].split("&")[0];
				String turboSpeed = "N/A";
				String singleThread = "N/A";
				String clockSpeed = "N/A";
				String tdp = "N/A";
				String price;
				String date;
				String cores;

				if (ratio.equals("NA"))
				{
					ratio = "N/A";
				}

				if (link.contains("gpu.php"))
				{
					date = fullDesc.split("Videocard First Benchmarked:</span>&nbsp;&nbsp;")[1].split("<")[0];
					price = fullDesc.split("Last Price Change:</span>&nbsp;&nbsp;")[1].split(" \\(")[0].split("<")[0];

					if (price.equals("NA"))
					{
						price = "N/A";
					}

					Util.msg(event, Colors.BOLD + "Name: " + Colors.NORMAL + name + " | " + Colors.BOLD + "Score: " + Colors.NORMAL + score + " | " + Colors.BOLD + "Rank: " + Colors.NORMAL + rank + " | " + Colors.BOLD + "Samples: " + Colors.NORMAL + samples + " | " + Colors.BOLD + "First Benchmarked: " + Colors.NORMAL + date + " | " + Colors.BOLD + "Price: " + Colors.NORMAL + price + " | " + Colors.BOLD + "Performance Per Dollar: " + Colors.NORMAL + ratio + " | " + Colors.BOLD + "Powered by PassMark");
				}
				if (link.contains("cpu.php"))
				{
					date = fullDesc.split("CPU First Seen on Charts:</span>&nbsp;&nbsp;")[1].split("<")[0];
					price = fullDesc.split("Last Price Change:</span>&nbsp;&nbsp;")[1].split("<")[0];
					cores = fullDesc.split("No of Cores:</strong> ")[1].split("<")[0];

					if (fullDesc.contains("Clockspeed:</strong> "))
					{
						clockSpeed = fullDesc.split("Clockspeed:</strong> ")[1].split("<")[0];
					}

					if (fullDesc.contains("<br><br> Single Thread Rating: "))
					{
						singleThread = fullDesc.split("<br><br> Single Thread Rating: ")[1].split("<")[0];
					}

					if (fullDesc.contains("Turbo Speed:</strong> "))
					{
						turboSpeed = fullDesc.split("Turbo Speed:</strong> ")[1].split("<")[0];
					}

					if (fullDesc.contains("Max TDP:</strong> "))
					{
						tdp = fullDesc.split("Max TDP:</strong> ")[1].split("<")[0];
					}

					if (price.equals("NA"))
					{
						price = "N/A";
					}

					if (tdp.equals("-1 W"))
					{
						tdp = "N/A";
					}

					Util.msg(event, Colors.BOLD + "Name: " + Colors.NORMAL + name + " | " + Colors.BOLD + "Score: " + Colors.NORMAL + score + " | " + Colors.BOLD + "Single Thread Score: " + Colors.NORMAL + singleThread + " | " + Colors.BOLD + "Rank: " + Colors.NORMAL + rank + " | " + Colors.BOLD + "Samples: " + Colors.NORMAL + samples + " | " + Colors.BOLD + "Cores: " + Colors.NORMAL + cores + " | " + Colors.BOLD + "Clock Speed: " + Colors.NORMAL + clockSpeed + " | " + Colors.BOLD + "Turbo Speed: " + Colors.NORMAL + turboSpeed + " | " + Colors.BOLD + "Max TDP: " + Colors.NORMAL + tdp + " | " + Colors.BOLD + "First Benchmarked: " + Colors.NORMAL + date + " | " + Colors.BOLD + "Price: " + Colors.NORMAL + price + " | " + Colors.BOLD + "Performance Per Dollar: " + Colors.NORMAL + ratio + " | " + Colors.BOLD + "Powered by PassMark");

				}
			}
			else
			{
				Util.msg(event, "I couldn't find any results for \"" + Util.addArgs(args, 1) + "\"!");
			}

		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "You need to provide a GPU/CPU name to benchmark!");
		}
		else
		{
			String query = Util.addArgs(args, 1);

			if (query.contains(" "))
			{
				query = query.replace(" ", "+");
			}

			Document searchDoc = Jsoup.connect("http://www.passmark.com/search/zoomsearch.php?zoom_query=" + query + "&zoom_cat=5").get();
			String searchHtml = searchDoc.select("div[class=result_title]").html();
			String[] searchHtmlSplit = searchHtml.split(" ");
			String link = "";

			for (String l : searchHtmlSplit)
			{
				if ((l.contains("http://")) && (l.contains("gpu.php") || l.contains("cpu.php")))
				{
					link = l;
					break;
				}
			}

			if (!link.equals(""))
			{
				link = link.split("\"")[1];

				link = link.replace("amp;", "");
				Document benchDoc = Jsoup.connect(link).get();
				String fullDesc = benchDoc.select("table[class=desc]").html().replace("<a href=\"#history\">", "");
				String name = benchDoc.select("span[class=cpuname]").text();
				String score = benchDoc.select("span[style=font-family: Arial, Helvetica, sans-serif;font-size: 35px;	font-weight: bold; color: red;]").text();
				String rank = fullDesc.split("Overall Rank:</span>&nbsp;&nbsp;")[1].split("<")[0];
				String samples = benchDoc.select("td[style=text-align: center]").text().split("Samples: ")[1].split("\\*")[0];
				String ratio = fullDesc.split("Price:</span>&nbsp;&nbsp;")[1].split("&")[0];
				String turboSpeed = "N/A";
				String singleThread = "N/A";
				String clockSpeed = "N/A";
				String tdp = "N/A";
				String price;
				String date;
				String cores;

				if (ratio.equals("NA"))
				{
					ratio = "N/A";
				}

				if (link.contains("gpu.php"))
				{
					date = fullDesc.split("Videocard First Benchmarked:</span>&nbsp;&nbsp;")[1].split("<")[0];
					price = fullDesc.split("Last Price Change:</span>&nbsp;&nbsp;")[1].split(" \\(")[0].split("<")[0];

					if (price.equals("NA"))
					{
						price = "N/A";
					}

					Util.msg(event, Colors.BOLD + "Name: " + Colors.NORMAL + name + " | " + Colors.BOLD + "Score: " + Colors.NORMAL + score + " | " + Colors.BOLD + "Rank: " + Colors.NORMAL + rank + " | " + Colors.BOLD + "Samples: " + Colors.NORMAL + samples + " | " + Colors.BOLD + "First Benchmarked: " + Colors.NORMAL + date + " | " + Colors.BOLD + "Price: " + Colors.NORMAL + price + " | " + Colors.BOLD + "Performance Per Dollar: " + Colors.NORMAL + ratio + " | " + Colors.BOLD + "Powered by PassMark");
				}
				if (link.contains("cpu.php"))
				{
					date = fullDesc.split("CPU First Seen on Charts:</span>&nbsp;&nbsp;")[1].split("<")[0];
					price = fullDesc.split("Last Price Change:</span>&nbsp;&nbsp;")[1].split("<")[0];
					cores = fullDesc.split("No of Cores:</strong> ")[1].split("<")[0];

					if (fullDesc.contains("Clockspeed:</strong> "))
					{
						clockSpeed = fullDesc.split("Clockspeed:</strong> ")[1].split("<")[0];
					}

					if (fullDesc.contains("<br><br> Single Thread Rating: "))
					{
						singleThread = fullDesc.split("<br><br> Single Thread Rating: ")[1].split("<")[0];
					}

					if (fullDesc.contains("Turbo Speed:</strong> "))
					{
						turboSpeed = fullDesc.split("Turbo Speed:</strong> ")[1].split("<")[0];
					}

					if (fullDesc.contains("Max TDP:</strong> "))
					{
						tdp = fullDesc.split("Max TDP:</strong> ")[1].split("<")[0];
					}

					if (price.equals("NA"))
					{
						price = "N/A";
					}

					if (tdp.equals("-1 W"))
					{
						tdp = "N/A";
					}

					Util.msg(event, Colors.BOLD + "Name: " + Colors.NORMAL + name + " | " + Colors.BOLD + "Score: " + Colors.NORMAL + score + " | " + Colors.BOLD + "Single Thread Score: " + Colors.NORMAL + singleThread + " | " + Colors.BOLD + "Rank: " + Colors.NORMAL + rank + " | " + Colors.BOLD + "Samples: " + Colors.NORMAL + samples + " | " + Colors.BOLD + "Cores: " + Colors.NORMAL + cores + " | " + Colors.BOLD + "Clock Speed: " + Colors.NORMAL + clockSpeed + " | " + Colors.BOLD + "Turbo Speed: " + Colors.NORMAL + turboSpeed + " | " + Colors.BOLD + "Max TDP: " + Colors.NORMAL + tdp + " | " + Colors.BOLD + "First Benchmarked: " + Colors.NORMAL + date + " | " + Colors.BOLD + "Price: " + Colors.NORMAL + price + " | " + Colors.BOLD + "Performance Per Dollar: " + Colors.NORMAL + ratio + " | " + Colors.BOLD + "Powered by PassMark");

				}
			}
			else
			{
				Util.msg(event, "I couldn't find any results for \"" + Util.addArgs(args, 1) + "\"!");
			}

		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*benchmark" };
	}
}