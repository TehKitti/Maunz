package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class BulliedMe implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.getChannel().send().message("Nobody bullied you? Okay then.");
		}
		else
		{
			if (args[1].startsWith("#"))
			{
				if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
				{
					if (args.length == 2)
					{
						event.getChannel().send().message("Nobody bullied you? Okay then.");
					}
					else
					{
						Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
					}
				}
				else
				{
					event.getChannel().send().message("I am not in the channel " + args[1] + "!");
				}
			}
			else
			{
				event.getChannel().send().message(Util.addArgs(args, 1) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("Nobody bullied you? Okay then.");
		}
		else
		{
			if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
			{
				if (args.length == 2)
				{
					event.respond("Nobody bullied you? Okay then.");
				}
				else
				{
					Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
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
		return new String[] { "*bulliedme" };
	}
}