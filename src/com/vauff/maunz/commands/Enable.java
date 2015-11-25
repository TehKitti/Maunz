package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Enable implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{

	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			if (!Util.isEnabled)
			{
				event.getChannel().send().message("I have been enabled :D");
				Util.isEnabled = true;
			}
			else
			{
				event.getChannel().send().message("You silly, I was already enabled!");
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
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			if (!Util.isEnabled)
			{
				event.respond("I have been enabled :D");
				Util.isEnabled = true;
			}
			else
			{
				event.respond("You silly, I was already enabled!");
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
		return new String[] { "*enable" };
	}
}