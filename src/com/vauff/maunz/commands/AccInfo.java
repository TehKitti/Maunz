package com.vauff.maunz.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class AccInfo implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accinfo?username=" + args[1] + "&format=csv").openStream()));
			String statusraw = reader.readLine();
			String[] status = statusraw.split(",");

			if (args[1].contains("#") || args[1].contains("&"))
			{
				event.respondChannel("The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
				Logger.botMsg(event.getChannel().getName(), "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
			}
			else
			{
				if (statusraw.equalsIgnoreCase("unknown username"))
				{
					event.respondChannel("The Minecraft account name " + args[1] + " is free and does not belong to any account!");
					Logger.botMsg(event.getChannel().getName(), "The Minecraft account name " + args[1] + " is free and does not belong to any account!");
				}

				else if (statusraw.equalsIgnoreCase("Username must be 16 characters or less."))
				{
					event.respondChannel("The Minecraft account name " + args[1] + " must be 16 characters or less.");
					Logger.botMsg(event.getChannel().getName(), "The Minecraft account name " + args[1] + " must be 16 characters or less.");
				}

				else if (statusraw.equalsIgnoreCase("Username must be alphanumerical (or contain '_')."))
				{
					event.respondChannel("The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
					Logger.botMsg(event.getChannel().getName(), "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
				}

				else if (statusraw.contains(","))
				{
					BufferedReader uuidreader = new BufferedReader(new InputStreamReader(new URL("http://mcuuid.com/api/" + status[1]).openStream()));
					String uuidstatusraw = uuidreader.readLine();
					String[] uuidstatusrawsplit = uuidstatusraw.split(":");
					String uuidstatus;

					if (uuidstatusraw.contains("legacy"))
					{
						uuidstatus = uuidstatusrawsplit[4].replace("\"", "").replace("}", "");
					}
					else
					{
						uuidstatus = uuidstatusrawsplit[3].replace("\"", "").replace("}", "");
					}

					event.respondChannel(Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
					Logger.botMsg(event.getChannel().getName(), Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
					event.respondChannel(Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
					Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
					event.respondChannel(Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
					Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
					event.respondChannel(Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
					Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
					event.respondChannel(Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
					Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
					event.respondChannel(Colors.PURPLE + "Raw Skin: " + "https://minotar.net/skin/" + status[1]);
					Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Raw Skin: " + "https://minotar.net/skin/" + status[1]);
					event.respondChannel(Colors.BROWN + "****************************************");
					Logger.botMsg(event.getChannel().getName(), Colors.BROWN + "****************************************");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			event.respondChannel("Provide a username for me please!");
			Logger.botMsg(event.getChannel().getName(), "Provide a username for me please!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accinfo?username=" + args[1] + "&format=csv").openStream()));
			String statusraw = reader.readLine();
			String[] status = statusraw.split(",");

			if (args[1].contains("#") || args[1].contains("&"))
			{
				event.respond("The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
				Logger.botMsg(event.getUser().getNick(), "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
			}
			else
			{
				if (statusraw.equalsIgnoreCase("unknown username"))
				{
					event.respond("The Minecraft account name " + args[1] + " is free and does not belong to any account!");
					Logger.botMsg(event.getUser().getNick(), "The Minecraft account name " + args[1] + " is free and does not belong to any account!");
				}

				else if (statusraw.equalsIgnoreCase("Username must be 16 characters or less."))
				{
					event.respond("The Minecraft account name " + args[1] + " must be 16 characters or less.");
					Logger.botMsg(event.getUser().getNick(), "The Minecraft account name " + args[1] + " must be 16 characters or less.");
				}

				else if (statusraw.equalsIgnoreCase("Username must be alphanumerical (or contain '_')."))
				{
					event.respond("The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
					Logger.botMsg(event.getUser().getNick(), "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
				}

				else if (statusraw.contains(","))
				{
					BufferedReader uuidreader = new BufferedReader(new InputStreamReader(new URL("http://mcuuid.com/api/" + status[1]).openStream()));
					String uuidstatusraw = uuidreader.readLine();
					String[] uuidstatusrawsplit = uuidstatusraw.split(":");
					String uuidstatus;

					if (uuidstatusraw.contains("legacy"))
					{
						uuidstatus = uuidstatusrawsplit[4].replace("\"", "").replace("}", "");
					}
					else
					{
						uuidstatus = uuidstatusrawsplit[3].replace("\"", "").replace("}", "");
					}

					event.respond(Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
					Logger.botMsg(event.getUser().getNick(), Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
					event.respond(Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
					Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
					event.respond(Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
					Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
					event.respond(Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
					Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
					event.respond(Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
					Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
					event.respond(Colors.PURPLE + "Raw Skin: " + "https://minotar.net/skin/" + status[1]);
					Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Raw Skin: " + "https://minotar.net/skin/" + status[1]);
					event.respond(Colors.BROWN + "****************************************");
					Logger.botMsg(event.getUser().getNick(), Colors.BROWN + "****************************************");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
			Logger.botMsg(event.getUser().getNick(), "Provide a username for me please!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*accinfo" };
	}
}