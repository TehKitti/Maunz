package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Disable implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{

	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff"))
		{
			if (Util.isEnabled)
			{
				event.getChannel().send().message("I have been disabled :(");
				Util.isEnabled = false;
			}
			else
			{
				event.getChannel().send().message("You silly, I was already disabled!");
			}
		}
		else
		{
			event.getChannel().send().message("You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff"))
		{
			if (Util.isEnabled)
			{
				Util.isEnabled = false;
				event.respond("I have been disabled :(");
			}
			else
			{
				event.respond("You silly, I was already disabled!");
			}
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*disable" };
	}
}