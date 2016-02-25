package com.vauff.maunz.commands;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;

public class Changelog implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");
		Document doc = null;

		try
		{
			String html;
			String[] split;
			String link;

			if (args.length == 1)
			{
				link = "https://github.com/Vauff/Maunz/releases/tag/v" + Main.version;
				doc = Jsoup.connect(link).userAgent(" ").get();
			}
			else
			{
				if (args[1].startsWith("v"))
				{
					link = "https://github.com/Vauff/Maunz/releases/tag/" + args[1];
					doc = Jsoup.connect(link).userAgent(" ").get();
				}
				else
				{
					link = "https://github.com/Vauff/Maunz/releases/tag/v" + args[1];
					doc = Jsoup.connect(link).userAgent(" ").get();
				}
			}

			html = doc.select("div[class=\"markdown-body\"]").html();
			split = html.split("li>");

			for (int i = 1; i < split.length; i++)
			{
				if (i % 2 == 0)
				{
					continue;
				}

				event.respondChannel("- " + split[i].substring(0, split[i].length() - 2));
				Logger.botMsg(event.getChannel().getName(), "- " + split[i].substring(0, split[i].length() - 2));
			}

			event.respondChannel("GitHub link: " + link);
			Logger.botMsg(event.getChannel().getName(), "GitHub link: " + link);
		}
		catch (HttpStatusException e)
		{
			Logger.log.error(e);
			event.respondChannel("That version of Maunz doesn't exist!");
			Logger.botMsg(event.getChannel().getName(), "That version of Maunz doesn't exist!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");
		Document doc = null;

		try
		{
			String html;
			String[] split;
			String link;

			if (args.length == 1)
			{
				link = "https://github.com/Vauff/Maunz/releases/tag/v" + Main.version;
				doc = Jsoup.connect(link).userAgent(" ").get();
			}
			else
			{
				if (args[1].startsWith("v"))
				{
					link = "https://github.com/Vauff/Maunz/releases/tag/" + args[1];
					doc = Jsoup.connect(link).userAgent(" ").get();
				}
				else
				{
					link = "https://github.com/Vauff/Maunz/releases/tag/v" + args[1];
					doc = Jsoup.connect(link).userAgent(" ").get();
				}
			}

			html = doc.select("div[class=\"markdown-body\"]").html();
			split = html.split("li>");

			for (int i = 1; i < split.length; i++)
			{
				if (i % 2 == 0)
				{
					continue;
				}

				event.respond("- " + split[i].substring(0, split[i].length() - 2));
				Logger.botMsg(event.getUser().getNick(), "- " + split[i].substring(0, split[i].length() - 2));
			}

			event.respond("GitHub link: " + link);
			Logger.botMsg(event.getUser().getNick(), "GitHub link: " + link);
		}
		catch (HttpStatusException e)
		{
			Logger.log.error(e);
			event.respond("That version of Maunz doesn't exist!");
			Logger.botMsg(event.getUser().getNick(), "That version of Maunz doesn't exist!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*changelog" };
	}
}