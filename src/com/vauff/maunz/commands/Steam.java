package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;

public class Steam implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.getChannel().send().message("Please give me a Steam ID!");
		}
		else
		{
			if (args[1].matches("[0-9]+"))
			{
				event.getChannel().send().message("Here you go! http://steamcommunity.com/profiles/" + args[1]);
			}
			else
			{
				event.getChannel().send().message("Here you go! http://steamcommunity.com/id/" + args[1]);
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("Please give me a Steam ID.");
		}
		else
		{
			if (args[1].matches("[0-9]+"))
			{
				event.respond("Here you go! http://steamcommunity.com/profiles/" + args[1]);
			}
			else
			{
				event.respond("Here you go! http://steamcommunity.com/id/" + args[1]);
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*steam" };
	}
}