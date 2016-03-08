package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Say implements ICommand<MessageEvent, PrivateMessageEvent>
{
	public static String whoSay = "";
	public static String whoSayTime = "";

	@Override
	public void exeChan(MessageEvent event) throws Exception
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
						Logger.log.info(event.getUser().getNick() + " is sending " + Util.addArgs(args, 2) + " to " + args[1]);
						Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2));
						Logger.botMsg(args[1], Util.addArgs(args, 2));
						whoSay = event.getUser().getNick();
						whoSayTime = Util.getTime(false, 0);
					}
					else
					{
						event.respondChannel("I need a message to send!");
						Logger.botMsg(event.getChannel().getName(), "I need a message to send!");
					}
				}
				else
				{
					event.respondChannel("I am not in the channel " + args[1] + "!");
					Logger.botMsg(event.getChannel().getName(), "I am not in the channel " + args[1] + "!");
				}
			}
			else
			{
				Logger.log.info(event.getUser().getNick() + " is sending " + Util.addArgs(args, 1) + " to " + event.getChannel().getName());
				event.respondChannel(Util.addArgs(args, 1));
				Logger.botMsg(event.getChannel().getName(), Util.addArgs(args, 1));
				whoSay = event.getUser().getNick();
				whoSayTime = Util.getTime(false, 0);
			}
		}
		else
		{
			event.respondChannel("I need a message to send!");
			Logger.botMsg(event.getChannel().getName(), "I need a message to send!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length != 1)
		{
			if (Util.hasJoinedChannel(args[1]))
			{
				if (args.length == 2)
				{
					event.respond("I need a message to send!");
					Logger.botMsg(event.getUser().getNick(), "I need a message to send!");
				}
				else
				{
					Logger.log.info(event.getUser().getNick() + " is sending " + Util.addArgs(args, 2) + " to " + args[1]);
					Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2));
					Logger.botMsg(args[1], Util.addArgs(args, 2));
					whoSay = event.getUser().getNick();
					whoSayTime = Util.getTime(false, 0);
				}
			}
			else
			{
				event.respond("I am not in the channel " + args[1] + "!");
				Logger.botMsg(event.getUser().getNick(), "I am not in the channel " + args[1] + "!");
			}
		}
		else
		{
			event.respond("I need a channel and a message to send!");
			Logger.botMsg(event.getUser().getNick(), "I need a channel and a message to send!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*say" };
	}
}