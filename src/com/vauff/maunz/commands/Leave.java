package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.Listener;
import com.vauff.maunz.core.Main;

public class Leave implements ICommand<MessageEvent, PrivateMessageEvent> 
{
	@Override
	public void exeChan(MessageEvent event) throws Exception 
	{
		if (event.getUser().getNick().equals("Vauff")) 
		{
			String[] args = event.getMessage().split(" ");
			if (args[1].startsWith("#")) 
			{
				if (!Listener.channels.contains(args[1]))
				{
					event.getChannel().send().message("I am not in "+ args[1] + "!");
				}
				if (Listener.channels.contains(args[1])) 
				{
					Main.esperBot.sendRaw().rawLine("PART " + args[1] + " :" + "Goodbye");
					event.getChannel().send().message("I will leave " + args[1] + "!");
					Listener.channels.remove(args[1]);
					
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
				if (!Listener.channels.contains(args[1]))
				{
					event.respond("I am not in "+ args[1] + "!");
				}
				if (Listener.channels.contains(args[1])) 
				{
					Main.esperBot.sendRaw().rawLine("PART " + args[1] + " :" + "Goodbye");
					event.respond("I will leave " + args[1] + "!");
					Listener.channels.remove(args[1]);
					
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
		return new String[]{"*leave"};
	}
}