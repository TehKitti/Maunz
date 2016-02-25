package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;

public class Nick implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			String[] args = event.getMessage().split(" ");

			if (args.length == 1)
			{
				event.respondChannel("I need a network name and a nickname specified!");
				Logger.botMsg(event.getChannel().getName(), "I need a network name and a nickname specified!");
			}
			else
			{
				if (args[1].equalsIgnoreCase("Freenode") || args[1].equalsIgnoreCase("Esper"))
				{
					if (args.length == 2)
					{
						event.respondChannel("You need to give me a nickname!");
						Logger.botMsg(event.getChannel().getName(), "You need to give me a nickname!");
					}
					else
					{
						if (args[1].equalsIgnoreCase("Esper"))
						{
							if (args[2].equals(Main.esperBot.getNick()))
							{
								event.respondChannel("That is the nick that I am already using!");
								Logger.botMsg(event.getChannel().getName(), "That is the nick that I am already using!");
							}
							else
							{
								event.respondChannel("Changing nickname on Esper from " + Main.esperBot.getNick() + " to " + args[2] + "!");
								Logger.botMsg(event.getChannel().getName(), "Changing nickname on Esper from " + Main.esperBot.getNick() + " to " + args[2] + "!");
								Main.esperBot.sendIRC().changeNick(args[2]);
							}
						}
						if (args[1].equalsIgnoreCase("Freenode"))
						{
							if (args[2].equals(Main.freenodeBot.getNick()))
							{
								event.respondChannel("That is the nick that I am already using!");
								Logger.botMsg(event.getChannel().getName(), "That is the nick that I am already using!");
							}
							else
							{
								event.respondChannel("Changing nickname on Freenode from " + Main.freenodeBot.getNick() + " to " + args[2] + "!");
								Logger.botMsg(event.getChannel().getName(), "Changing nickname on Freenode from " + Main.freenodeBot.getNick() + " to " + args[2] + "!");
								Main.freenodeBot.sendIRC().changeNick(args[2]);
							}
						}
					}
				}
				else
				{
					event.respondChannel("I'm not on the network " + args[1] + "!");
					Logger.botMsg(event.getChannel().getName(), "I'm not on the network " + args[1] + "!");
				}
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
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			String[] args = event.getMessage().split(" ");

			if (args.length == 1)
			{
				event.respond("I need a network name and a nickname specified!");
				Logger.botMsg(event.getUser().getNick(), "I need a network name and a nickname specified!");
			}
			else
			{
				if (args[1].equalsIgnoreCase("Freenode") || args[1].equalsIgnoreCase("Esper"))
				{
					if (args.length == 2)
					{
						event.respond("You need to give me a nickname!");
						Logger.botMsg(event.getUser().getNick(), "You need to give me a nickname!");
					}
					else
					{
						if (args[1].equalsIgnoreCase("Esper"))
						{
							if (args[2].equals(Main.esperBot.getNick()))
							{
								event.respond("That is the nick that I am already using!");
								Logger.botMsg(event.getUser().getNick(), "That is the nick that I am already using!");
							}
							else
							{
								event.respond("Changing nickname on Esper to " + args[2] + "!");
								Logger.botMsg(event.getUser().getNick(), "Changing nickname on Esper to " + args[2] + "!");
								Main.esperBot.sendIRC().changeNick(args[2]);
							}
						}
						if (args[1].equalsIgnoreCase("Freenode"))
						{
							if (args[2].equals(Main.freenodeBot.getNick()))
							{
								event.respond("That is the nick that I am already using!");
								Logger.botMsg(event.getUser().getNick(), "That is the nick that I am already using!");
							}
							else
							{
								event.respond("Changing nickname on Freenode to " + args[2] + "!");
								Logger.botMsg(event.getUser().getNick(), "Changing nickname on Freenode to " + args[2] + "!");
								Main.freenodeBot.sendIRC().changeNick(args[2]);
							}
						}
					}
				}
				else
				{
					event.respond("I'm not on the network " + args[1] + "!");
					Logger.botMsg(event.getUser().getNick(), "I'm not on the network " + args[1] + "!");
				}
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
		return new String[] { "*nick" };
	}
}