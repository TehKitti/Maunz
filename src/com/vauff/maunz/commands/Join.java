package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Join implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			String[] args = event.getMessage().split(" ");

			if (args.length != 1)
			{
				if (args[1].startsWith("#"))
				{
					if (Util.hasJoinedChannel(args[1]))
					{
						event.getChannel().send().message("I am already in " + args[1] + "!");
					}

					if (!Util.hasJoinedChannel(args[1]))
					{
						Main.esperBot.sendIRC().joinChannel(args[1]);
						event.getChannel().send().message("I will join " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					event.getChannel().send().message("Channel name must start with a #");
				}
			}
			else
			{
				event.getChannel().send().message("Please give me a channel to join!");
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
			String[] args = event.getMessage().split(" ");

			if (args.length != 1)
			{
				if (args[1].startsWith("#"))
				{
					if (Util.hasJoinedChannel(args[1]))
					{
						event.respond("I am already in " + args[1] + "!");
					}

					if (!Util.hasJoinedChannel(args[1]))
					{
						Main.esperBot.sendIRC().joinChannel(args[1]);
						event.respond("I will join " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					event.respond("Channel name must start with a #");
				}
			}
			else
			{
				event.respond("Please give me a channel to join!");
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
		return new String[] { "*join" };
	}
}