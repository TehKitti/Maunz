package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
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
						Util.msg(args[1], Util.addArgs(args, 2));
						whoSay = event.getUser().getNick();
						whoSayTime = Util.getTime();
					}
					else
					{
						Util.msg(event, "I need a message to send!");
					}
				}
				else
				{
					Util.msg(event, "I am not in the channel " + args[1] + "!");
				}
			}
			else
			{
				Util.msg(event, Util.addArgs(args, 1));
				whoSay = event.getUser().getNick();
				whoSayTime = Util.getTime();
			}
		}
		else
		{
			Util.msg(event, "I need a message to send!");
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
					Util.msg(event, "I need a message to send!");
				}
				else
				{
					Util.msg(args[1], Util.addArgs(args, 2));
					whoSay = event.getUser().getNick();
					whoSayTime = Util.getTime();
				}
			}
			else
			{
				Util.msg(event, "I am not in the channel " + args[1] + "!");
			}
		}
		else
		{
			Util.msg(event, "I need a channel and a message to send!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*say" };
	}
}