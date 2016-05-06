package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Passwords;
import com.vauff.maunz.core.Util;

public class Join implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			String[] args = event.getMessage().split(" ");

			if (args.length != 1)
			{
				if (args[1].startsWith("#"))
				{
					if (Util.hasJoinedChannel(args[1]))
					{
						event.respondChannel("I am already in " + args[1] + "!");
						Logger.botMsg(event.getChannel().getName(), "I am already in " + args[1] + "!");
					}

					if (!Util.hasJoinedChannel(args[1]))
					{
						if (args[1].equals("#extruders"))
						{
							Main.esperBot.sendIRC().joinChannel(args[1], Passwords.extruders);
						}
						else
						{
							Main.esperBot.sendIRC().joinChannel(args[1]);
						}

						event.respondChannel("I will join " + args[1] + "!");
						Logger.botMsg(event.getChannel().getName(), "I will join " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					event.respondChannel("Channel name must start with a #");
					Logger.botMsg(event.getChannel().getName(), "Channel name must start with a #");
				}
			}
			else
			{
				event.respondChannel("Please give me a channel to join!");
				Logger.botMsg(event.getChannel().getName(), "Please give me a channel to join!");
			}
		}
		else
		{
			event.respondChannel("You do not have permission to use that command");
			Logger.botMsg(event.getChannel().getName(), "You do not have permission to use that command");

		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			String[] args = event.getMessage().split(" ");

			if (args.length != 1)
			{
				if (args[1].startsWith("#"))
				{
					if (Util.hasJoinedChannel(args[1]))
					{
						event.respond("I am already in " + args[1] + "!");
						Logger.botMsg(event.getUser().getNick(), "I am already in " + args[1] + "!");
					}

					if (!Util.hasJoinedChannel(args[1]))
					{
						if (args[1].equals("#extruders"))
						{
							Main.esperBot.sendIRC().joinChannel(args[1], Passwords.extruders);
						}
						else
						{
							Main.esperBot.sendIRC().joinChannel(args[1]);
						}
						
						event.respond("I will join " + args[1] + "!");
						Logger.botMsg(event.getUser().getNick(), "I will join " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					event.respond("Channel name must start with a #");
					Logger.botMsg(event.getUser().getNick(), "Channel name must start with a #");
				}
			}
			else
			{
				event.respond("Please give me a channel to join!");
				Logger.botMsg(event.getUser().getNick(), "Please give me a channel to join!");
			}
		}
		else
		{
			event.respond("You do not have permission to use that command");
			Logger.botMsg(event.getUser().getNick(), "You do not have permission to use that command");

		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*join" };
	}
}