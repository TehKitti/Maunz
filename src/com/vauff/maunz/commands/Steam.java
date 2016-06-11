package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Steam implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "Please give me a Steam ID!");
		}
		else
		{
			if (args[1].matches("[0-9]+"))
			{
				Logger.log.info("Detected a numeric input, using the profiles link...");
				Util.msg(event, "Here you go! http://steamcommunity.com/profiles/" + args[1]);
			}
			else
			{
				Logger.log.info("Detected a alphanumeric input, using the id link...");
				Util.msg(event, "Here you go! http://steamcommunity.com/id/" + args[1]);
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "Please give me a Steam ID.");
		}
		else
		{
			if (args[1].matches("[0-9]+"))
			{
				Logger.log.info("Detected a numeric input, using the profiles link...");
				Util.msg(event, "Here you go! http://steamcommunity.com/profiles/" + args[1]);
			}
			else
			{
				Logger.log.info("Detected a alphanumeric input, using the id link...");
				Util.msg(event, "Here you go! http://steamcommunity.com/id/" + args[1]);
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*steam" };
	}
}