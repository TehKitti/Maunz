package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class BulliedMe implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respondChannel("Nobody bullied you? Okay then.");
			Logger.botMsg(event.getChannel().getName(), "Nobody bullied you? Okay then.");
		}
		else
		{
			if (args[1].startsWith("#"))
			{
				if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
				{
					if (args.length == 2)
					{
						event.respondChannel("Nobody bullied you? Okay then.");
						Logger.botMsg(event.getChannel().getName(), "Nobody bullied you? Okay then.");
					}
					else
					{
						Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
						Logger.botMsg(event.getChannel().getName(), Util.addArgs(args, 2) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
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
				event.respondChannel(Util.addArgs(args, 1) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
				Logger.botMsg(event.getChannel().getName(), Util.addArgs(args, 1) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("Nobody bullied you? Okay then.");
			Logger.botMsg(event.getUser().getNick(), "Nobody bullied you? Okay then.");
		}
		else
		{
			if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
			{
				if (args.length == 2)
				{
					event.respond("Nobody bullied you? Okay then.");
					Logger.botMsg(event.getUser().getNick(), "Nobody bullied you? Okay then.");
				}
				else
				{
					Main.esperBot.sendIRC().message(args[1], Util.addArgs(args, 2) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
					Logger.botMsg(event.getUser().getNick(), Util.addArgs(args, 2) + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
				}
			}
			else
			{
				event.respond("I am not in the channel " + args[1] + "!");
				Logger.botMsg(event.getUser().getNick(), "I am not in the channel " + args[1] + "!");
			}

		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*bulliedme" };
	}
}