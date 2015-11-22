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

		if (args[1].startsWith("#"))
		{
			if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1]))
			{
				Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2));
				whoSay = event.getUser().getNick();
				whoSayTime = Util.getTime();
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

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1]))
		{
			Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2));
			whoSay = event.getUser().getNick();
			whoSayTime = Util.getTime();
		}
		else
		{
			event.respond("I am not in the channel " + args[1] + "!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*say" };
	}
}