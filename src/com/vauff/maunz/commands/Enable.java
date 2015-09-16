package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.Listener;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Enable implements ICommand<MessageEvent,PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
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
			event.respond("I'm sorry but you do not have proper permissions to enable me!");
			event.getChannel().send().message("I was hoping I could begin to take over the world here, guess I'll have to wait for TehKitti!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
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
			event.respond("I'm sorry but you do not have proper permissions to enable me!");
			event.getUser().send().message("I was hoping I could begin to take over the world here, guess I'll have to wait for TehKitti!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[]{"*enable"};
	}
}