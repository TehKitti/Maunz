package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Enable implements ICommand<MessageEvent, PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			if (!Util.isEnabled)
			{
				event.respondChannel("I have been enabled :D");
				Logger.botMsg(event.getChannel().getName(), "I have been enabled :D");
				Logger.log.info("Maunz is now enabled, messages will be parsed for commands and will no longer have a [DISABLED] prefix");
				Util.isEnabled = true;
			}
			else
			{
				event.respondChannel("You silly, I was already enabled!");
				Logger.botMsg(event.getChannel().getName(), "You silly, I was already enabled!");
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
		if (Util.hasPermission(event.getUser()))
		{
			if (!Util.isEnabled)
			{
				event.respond("I have been enabled :D");
				Logger.botMsg(event.getUser().getNick(), "I have been enabled :D");
				Logger.log.info("Maunz is now enabled, messages will be parsed for commands and will no longer have a [DISABLED] prefix");
				Util.isEnabled = true;
			}
			else
			{
				event.respond("You silly, I was already enabled!");
				Logger.botMsg(event.getUser().getNick(), "You silly, I was already enabled!");
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
		return new String[] { "*enable" };
	}
}