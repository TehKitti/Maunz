package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class BullyMe implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.getChannel().send().message("Nobody isn't bullying you? Okay then.");
		}
		else
		{
			event.getChannel().send().message(Util.addArgs(args, 1) + ": Start being a bully! Read http://start-irc-bullying.eu/start/");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("Nobody isn't bullying you? Okay then.");
		}
		else
		{
			if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
			{
				if (args.length == 2)
				{
					event.respond("Nobody isn't bullying you? Okay then.");
				}
				else
				{
					Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2) + ": Start being a bully! Read http://start-irc-bullying.eu/start/");
				}
			}
			else
			{
				event.respond("I am not in the channel " + args[1] + "!");
			}

		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*bullyme" };
	}
}