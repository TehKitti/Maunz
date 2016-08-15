package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Passwords;
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
				Util.msg(event, "I need a network name and a nickname specified!");
			}
			else
			{
				if (args[1].equalsIgnoreCase("Freenode") || args[1].equalsIgnoreCase("Esper"))
				{
					if (args.length == 2)
					{
						Util.msg(event, "I need a network name and a nickname specified!");
					}
					else
					{
						if (args[1].equalsIgnoreCase("Esper"))
						{
							if (args[2].equals(Main.esperBot.getNick()))
							{
								Util.msg(event, "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.esperBot.getNick();

								isNickUsed = false;
								Main.esperBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									Util.msg(event, "That nickname is already in use!");
								}
								else
								{
									Util.msg(event, "Changed nickname on Esper from " + oldNick + " to " + args[2] + "!");
									Main.esperBot.sendIRC().message("NickServ", "IDENTIFY " + Passwords.esperNickServ);
								}

							}
						}
						if (args[1].equalsIgnoreCase("Freenode"))
						{
							if (args[2].equals(Main.freenodeBot.getNick()))
							{
								Util.msg(event, "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.freenodeBot.getNick();
								
								isNickUsed = false;
								Main.freenodeBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									Util.msg(event, "That nickname is already in use!");
								}
								else
								{
									Util.msg(event, "Changed nickname on Freenode from " + oldNick + " to " + args[2] + "!");
									Main.freenodeBot.sendIRC().message("NickServ", "IDENTIFY " + Passwords.freenodeNickServ);
								}
							}
						}
					}
				}
				else
				{
					Util.msg(event, "I'm not on the network " + args[1] + "!");
				}
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

			if (args.length == 1)
			{
				Util.msg(event, "I need a network name and a nickname specified!");
			}
			else
			{
				if (args[1].equalsIgnoreCase("Freenode") || args[1].equalsIgnoreCase("Esper"))
				{
					if (args.length == 2)
					{
						Util.msg(event, "I need a network name and a nickname specified!");
					}
					else
					{
						if (args[1].equalsIgnoreCase("Esper"))
						{
							if (args[2].equals(Main.esperBot.getNick()))
							{
								Util.msg(event, "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.esperBot.getNick();
								
								isNickUsed = false;
								Main.esperBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									Util.msg(event, "That nickname is already in use!");
								}
								else
								{
									Util.msg(event, "Changed nickname on Esper from " + oldNick + " to " + args[2] + "!");
									Main.esperBot.sendIRC().message("NickServ", "IDENTIFY " + Passwords.esperNickServ);
								}
							}
						}
						if (args[1].equalsIgnoreCase("Freenode"))
						{
							if (args[2].equals(Main.freenodeBot.getNick()))
							{
								Util.msg(event, "That is the nickname that I am already using!");
							}
							else
							{
								String oldNick = Main.freenodeBot.getNick();
								
								isNickUsed = false;
								Main.freenodeBot.sendIRC().changeNick(args[2]);
								Thread.sleep(1000);

								if (isNickUsed)
								{
									Util.msg(event, "That nickname is already in use!");
								}
								else
								{
									Util.msg(event, "Changed nickname on Freenode from " + oldNick + " to " + args[2] + "!");
									Main.freenodeBot.sendIRC().message("NickServ", "IDENTIFY " + Passwords.freenodeNickServ);
								}
							}
						}
					}
				}
				else
				{
					Util.msg(event, "I'm not on the network " + args[1] + "!");
				}
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
		return new String[] { "*nick" };
	}
}