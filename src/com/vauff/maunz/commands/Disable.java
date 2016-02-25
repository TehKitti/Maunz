package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Disable implements ICommand<MessageEvent, PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			if (Util.isEnabled)
			{
				event.respondChannel("I have been disabled :(");
				Logger.botMsg(event.getChannel().getName(), "I have been disabled :(");
				Logger.log.info("Maunz is now disabled, messages messages will no longer be parsed for commands and will show in the log with a [DISABLED] prefix");
				Util.isEnabled = false;
			}
			else
			{
				event.respondChannel("You silly, I was already disabled!");
				Logger.botMsg(event.getChannel().getName(), "You silly, I was already disabled!");
			}
		}
		else
		{
			event.respondChannel("You do not have permission to use that command");
			Logger.botMsg(event.getChannel().getName(), "You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			if (Util.isEnabled)
			{
				event.respond("I have been disabled :(");
				Logger.botMsg(event.getUser().getNick(), "I have been disabled :(");
				Logger.log.info("Maunz is now disabled, messages received while disabled will show in the log with a [DISABLED] prefix");
				Util.isEnabled = false;
			}
			else
			{
				event.respond("You silly, I was already disabled!");
				Logger.botMsg(event.getUser().getNick(), "You silly, I was already disabled!");
			}
		}
		else
		{
			event.respond("You do not have permission to use that command");
			Logger.botMsg(event.getUser().getNick(), "You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*disable" };
	}
}