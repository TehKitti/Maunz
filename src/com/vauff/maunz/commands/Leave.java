package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;

public class Leave implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
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
					if (!Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
					{
						event.getChannel().send().message("I am not in " + args[1] + "!");
					}

					if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
					{
						event.getChannel().send().message("I will leave " + args[1] + "!");
						Main.esperBot.sendRaw().rawLine("PART " + args[1] + " :" + "Parting");
					}
				}

				if (!args[1].startsWith("#"))
				{
					event.getChannel().send().message("Channel name must start with a #");
				}
			}
			else
			{
				event.getChannel().send().message("I will leave " + event.getChannel().getName() + "!");
				Main.esperBot.sendRaw().rawLine("PART " + event.getChannel().getName() + " :" + "Parting");
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
					if (!Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
					{
						event.respond("I am not in " + args[1] + "!");
					}

					if (Main.esperBot.getUserBot().getChannels().toString().contains("name=" + args[1] + ","))
					{
						Main.esperBot.sendRaw().rawLine("PART " + args[1] + " :" + "Parting");
						event.respond("I will leave " + args[1] + "!");
					}
				}

				if (!args[1].startsWith("#"))
				{
					event.respond("Channel name must start with a #");
				}
			}
			else
			{
				event.respond("Please give me a channel to leave!");
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
		return new String[] { "*leave" };
	}
}