package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Say implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	public static String whoSay = "";
	public static String whoSayTime = "";

	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length != 1)
		{
			if (args[1].startsWith("#"))
			{
				if (Util.hasJoinedChannel(args[1]))
				{
					if (args.length != 2)
					{
						Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2));
						whoSay = event.getUser().getNick();
						whoSayTime = Util.getTime();
					}
					else
					{
						event.getChannel().send().message("I need a message to send!");
					}
				}
				else
				{
					event.getChannel().send().message("I am not in the channel " + args[1] + "!");
				}
			}
			else
			{
				event.getChannel().send().message(Util.addArgs(args, 1));
				whoSay = event.getUser().getNick();
				whoSayTime = Util.getTime();
			}
		}
		else
		{
			event.getChannel().send().message("I need a message to send!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length != 1)
		{
			if (Util.hasJoinedChannel(args[1]))
			{
				if (args.length == 2)
				{
					event.respond("I need a message to send!");
				}
				else
				{
					Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2));
					whoSay = event.getUser().getNick();
					whoSayTime = Util.getTime();
				}
			}
			else
			{
				event.respond("I am not in the channel " + args[1] + "!");
			}
		}
		else
		{
			event.respond("I need a channel and a message to send!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*say" };
	}
}