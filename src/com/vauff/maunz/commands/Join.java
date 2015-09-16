package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import com.vauff.maunz.core.Listener;
import com.vauff.maunz.core.Main;

public class Join implements ICommand<MessageEvent, PrivateMessageEvent> 
{
	@Override
	public void exeChan(MessageEvent event) throws Exception 
	{
		if (event.getUser().getNick().equals("Vauff")) 
		{
			String[] args = event.getMessage().split(" ");
			if (args[1].startsWith("#")) 
			{
				if (Listener.channels.contains(args[1])) 
				{
					event.getChannel().send().message("I am already in " + args[1] + "!");
				}
				if (!Listener.channels.contains(args[1]))
				{
					Main.esperBot.sendIRC().joinChannel(args[1]);
					event.getChannel().send().message("I will join "+ args[1] + "!");
					Listener.channels.add(args[1]);
				}
			}
			if (!args[1].startsWith("#")) 
			{
				event.getChannel().send().message("Channel name must start with a #");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception 
	{
		if (event.getUser().getNick().equals("Vauff")) 
		{
			String[] args = event.getMessage().split(" ");
			if (args[1].startsWith("#")) 
			{
				if (Listener.channels.contains(args[1])) 
				{
					event.respond("I am already in " + args[1] + "!");
				}
				if (!Listener.channels.contains(args[1]))
				{
					Main.esperBot.sendIRC().joinChannel(args[1]);
					event.respond("I will join "+ args[1] + "!");
					Listener.channels.add(args[1]);
				}
			}
			if (!args[1].startsWith("#")) 
			{
				event.respond("Channel name must start with a #");
			}
		}
	}

	@Override
	public String[] getAliases() 
	{
		return new String[]{"*join"};
	}
}