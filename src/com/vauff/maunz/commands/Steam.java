package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Steam implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respondChannel("Please give me a Steam ID!");
			Logger.botMsg(event.getChannel().getName(), "Please give me a Steam ID.");
		}
		else
		{
			if (args[1].matches("[0-9]+"))
			{
				Logger.log.info("Detected a numeric input, using the profiles link...");
				event.respondChannel("Here you go! http://steamcommunity.com/profiles/" + args[1]);
				Logger.botMsg(event.getChannel().getName(), "Here you go! http://steamcommunity.com/profiles/" + args[1]);
			}
			else
			{
				Logger.log.info("Detected a alphanumeric input, using the id link...");
				event.respondChannel("Here you go! http://steamcommunity.com/id/" + args[1]);
				Logger.botMsg(event.getChannel().getName(), "Here you go! http://steamcommunity.com/id/" + args[1]);
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("Please give me a Steam ID.");
			Logger.botMsg(event.getUser().getNick(), "Please give me a Steam ID.");
		}
		else
		{
			if (args[1].matches("[0-9]+"))
			{
				Logger.log.info("Detected a numeric input, using the profiles link...");
				event.respond("Here you go! http://steamcommunity.com/profiles/" + args[1]);
				Logger.botMsg(event.getUser().getNick(), "Here you go! http://steamcommunity.com/profiles/" + args[1]);
			}
			else
			{
				Logger.log.info("Detected a alphanumeric input, using the id link...");
				event.respond("Here you go! http://steamcommunity.com/id/" + args[1]);
				Logger.botMsg(event.getUser().getNick(), "Here you go! http://steamcommunity.com/id/" + args[1]);
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*steam" };
	}
}