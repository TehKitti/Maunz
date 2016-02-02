package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
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
				Logger.botMsg(event.getChannel().getName(), "I have been enabled :D");
				Logger.log.info("Maunz is now enabled, messages will be parsed for commands and will no longer have a [DISABLED] prefix");
				Util.isEnabled = true;
			}
			else
			{
				event.getChannel().send().message("You silly, I was already enabled!");
				Logger.botMsg(event.getChannel().getName(), "You silly, I was already enabled!");
			}
		}
		else
		{
			event.getChannel().send().message("You do not have permission to use that command");
			Logger.botMsg(event.getChannel().getName(), "You do not have permission to use that command");
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