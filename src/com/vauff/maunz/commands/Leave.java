package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Leave implements ICommand<MessageEvent, PrivateMessageEvent>
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
					if (!Util.hasJoinedChannel(args[1]))
					{
						Util.msg(event, "I am not in " + args[1] + "!");
					}

					if (Util.hasJoinedChannel(args[1]))
					{
						Util.msg(event, "I will leave " + args[1] + "!");
						Main.esperBot.sendRaw().rawLine("PART " + args[1] + " :" + "Parting");
					}
				}

				if (!args[1].startsWith("#"))
				{
					Util.msg(event, "Channel name must start with a #");
				}
			}
			else
			{
				Util.msg(event, "I will leave " + event.getChannel().getName() + "!");
				Main.esperBot.sendRaw().rawLine("PART " + event.getChannel().getName() + " :" + "Parting");
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
					if (!Util.hasJoinedChannel(args[1]))
					{
						Util.msg(event, "I am not in " + args[1] + "!");
					}

					if (Util.hasJoinedChannel(args[1]))
					{
						Main.esperBot.sendRaw().rawLine("PART " + args[1] + " :" + "Parting");
						Util.msg(event, "I will leave " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					Util.msg(event, "Channel name must start with a #");
				}
			}
			else
			{
				Util.msg(event, "Please give me a channel to leave!");
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
		return new String[] { "*leave" };
	}
}