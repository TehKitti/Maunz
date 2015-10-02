package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Listener;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Enable implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{

	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if(event.getUser().getNick().equals("Vauff"))
		{
			if(!Util.isEnabled)
			{
				for (String p : Listener.channels) 
				{
				Main.esperBot.sendIRC().message(p, "I have been enabled by " + event.getUser().getNick());
				}
				Util.isEnabled = true;
			}
			else
				event.respond("You silly, I was already enabled!");
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if(event.getUser().getNick().equals("Vauff"))
		{
			if(!Util.isEnabled)
			{
				for (String p : Listener.channels) 
				{
				Main.esperBot.sendIRC().message(p, "I have been enabled by " + event.getUser().getNick());
				}
				event.respond("I have been enabled by " + event.getUser().getNick());
				Util.isEnabled = true;
			}
			else
				event.respond("You silly, I was already enabled!");
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[]{"*enable"};
	}
}