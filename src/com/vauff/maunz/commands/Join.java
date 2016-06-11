package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
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
						Util.msg(event, "I am already in " + args[1] + "!");
					}

					if (!Util.hasJoinedChannel(args[1]))
					{
						Util.channelModeState.put(args[1] + event.getBot().getServerInfo().getServerName(), false);

						if (args[1].equals("#extruders"))
						{
							Main.esperBot.sendIRC().joinChannel(args[1], Passwords.extruders);
						}
						else
						{
							Main.esperBot.sendIRC().joinChannel(args[1]);
						}

						Util.msg(event, "I will join " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					Util.msg(event, "Channel name must start with a #");
				}
			}
			else
			{
				Util.msg(event, "Please give me a channel to join!");
			}
		}
		else
		{
			Util.msg(event, "You do not have permission to use that command");

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
						Util.msg(event, "I am already in " + args[1] + "!");
					}

					if (!Util.hasJoinedChannel(args[1]))
					{
						Util.channelModeState.put(args[1], false);

						if (args[1].equals("#extruders"))
						{
							Main.esperBot.sendIRC().joinChannel(args[1], Passwords.extruders);
						}
						else
						{
							Main.esperBot.sendIRC().joinChannel(args[1]);
						}

						Util.msg(event, "I will join " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					Util.msg(event, "Channel name must start with a #");
				}
			}
			else
			{
				Util.msg(event, "Please give me a channel to join!");
			}
		}
		else
		{
			Util.msg(event, "You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*join" };
	}
}