package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Nick implements ICommand<MessageEvent, PrivateMessageEvent>
{
	public static boolean isNickUsed = false;

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
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
						event.respondChannel("I need a network name and a nickname specified!");
						Logger.botMsg(event.getChannel().getName(), "I need a network name and a nickname specified!");
					}
					else
					{
						if (args[1].equalsIgnoreCase("Esper"))
						{
							if (args[2].equals(Main.esperBot.getNick()))
							{
								event.respondChannel("That is the nickname that I am already using!");
								Logger.botMsg(event.getChannel().getName(), "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.esperBot.getNick();

								isNickUsed = false;
								Main.esperBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									event.respondChannel("That nickname is already in use!");
									Logger.botMsg(event.getChannel().getName(), "That nickname is already in use!");
								}
								else
								{
									event.respondChannel("Changed nickname on Esper from " + oldNick + " to " + args[2] + "!");
									Logger.botMsg(event.getChannel().getName(), "Changed nickname on Esper from " + oldNick + " to " + args[2] + "!");
								}

							}
						}
						if (args[1].equalsIgnoreCase("Freenode"))
						{
							if (args[2].equals(Main.freenodeBot.getNick()))
							{
								event.respondChannel("That is the nickname that I am already using!");
								Logger.botMsg(event.getChannel().getName(), "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.freenodeBot.getNick();
								
								isNickUsed = false;
								Main.freenodeBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									event.respondChannel("That nickname is already in use!");
									Logger.botMsg(event.getChannel().getName(), "That nickname is already in use!");
								}
								else
								{
									event.respondChannel("Changed nickname on Freenode from " + oldNick + " to " + args[2] + "!");
									Logger.botMsg(event.getChannel().getName(), "Changed nickname on Freenode from " + oldNick + " to " + args[2] + "!");
								}
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
		if (Util.hasPermission(event.getUser()))
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
						event.respond("I need a network name and a nickname specified!");
						Logger.botMsg(event.getUser().getNick(), "I need a network name and a nickname specified!");
					}
					else
					{
						if (args[1].equalsIgnoreCase("Esper"))
						{
							if (args[2].equals(Main.esperBot.getNick()))
							{
								event.respond("That is the nickname that I am already using!");
								Logger.botMsg(event.getUser().getNick(), "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.esperBot.getNick();
								
								isNickUsed = false;
								Main.esperBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									event.respond("That nickname is already in use!");
									Logger.botMsg(event.getUser().getNick(), "That nickname is already in use!");
								}
								else
								{
									event.respond("Changed nickname on Esper from " + oldNick + " to " + args[2] + "!");
									Logger.botMsg(event.getUser().getNick(), "Changed nickname on Esper from " + oldNick + " to " + args[2] + "!");
								}
							}
						}
						if (args[1].equalsIgnoreCase("Freenode"))
						{
							if (args[2].equals(Main.freenodeBot.getNick()))
							{
								event.respond("That is the nickname that I am already using!");
								Logger.botMsg(event.getUser().getNick(), "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.freenodeBot.getNick();
								
								isNickUsed = false;
								Main.freenodeBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									event.respond("That nickname is already in use!");
									Logger.botMsg(event.getUser().getNick(), "That nickname is already in use!");
								}
								else
								{
									event.respond("Changed nickname on Freenode from " + oldNick + " to " + args[2] + "!");
									Logger.botMsg(event.getUser().getNick(), "Changed nickname on Freenode from " + oldNick + " to " + args[2] + "!");
								}
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