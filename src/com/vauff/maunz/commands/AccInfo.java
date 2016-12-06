package com.vauff.maunz.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class AccInfo implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");

			if (args.length == 1)
			{
				Util.msg(event, "Provide a Minecraft username for me please!");
			}
			else
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accinfo?username=" + args[1] + "&format=csv").openStream()));
				String statusRaw = reader.readLine();
				String[] status = statusRaw.split(",");

				if (args[1].contains("#") || args[1].contains("&"))
				{
					Util.msg(event, "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
				}
				else
				{
					if (statusRaw.equalsIgnoreCase("unknown username"))
					{
						Util.msg(event, "The Minecraft account name " + args[1] + " is free and does not belong to any account!");
					}

					else if (statusRaw.equalsIgnoreCase("Username must be 16 characters or less."))
					{
						Util.msg(event, "The Minecraft account name " + args[1] + " must be 16 characters or less.");
					}

					else if (statusRaw.equalsIgnoreCase("Username must be alphanumerical (or contain '_')."))
					{
						Util.msg(event, "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
					}

					else if (statusRaw.contains(","))
					{
						String uuid = status[0];
						
						uuid = new StringBuilder(uuid).insert(uuid.length() - 24, "-").toString();
						uuid = new StringBuilder(uuid).insert(uuid.length() - 20, "-").toString();
						uuid = new StringBuilder(uuid).insert(uuid.length() - 16, "-").toString();
						uuid = new StringBuilder(uuid).insert(uuid.length() - 12, "-").toString();
						Util.msg(event, Colors.BOLD + "Username: " + Colors.NORMAL + status[1] + " | " + Colors.BOLD + "Account Status: " + Colors.NORMAL + "Premium" + " | " + Colors.BOLD + "Migrated: " + Colors.NORMAL + StringUtils.capitalize(status[2]) + " | " + Colors.BOLD + "UUID: " + Colors.NORMAL + uuid + " | " + Colors.BOLD + "Skin: " + Colors.NORMAL + "https://minotar.net/body/" + status[1] + "/500.png" + " | " + Colors.BOLD + "Raw Skin: " + Colors.NORMAL + "https://minotar.net/skin/" + status[1] + " | " + Colors.BOLD + "Powered by axis.iaero.me");
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			Util.msg(event, "An unknown error occured grabbing account information");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");

			if (args.length == 1)
			{
				Util.msg(event, "Provide a Minecraft username for me please!");
			}
			else
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accinfo?username=" + args[1] + "&format=csv").openStream()));
				String statusRaw = reader.readLine();
				String[] status = statusRaw.split(",");

				if (args[1].contains("#") || args[1].contains("&"))
				{
					Util.msg(event, "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
				}
				else
				{
					if (statusRaw.equalsIgnoreCase("unknown username"))
					{
						Util.msg(event, "The Minecraft account name " + args[1] + " is free and does not belong to any account!");
					}

					else if (statusRaw.equalsIgnoreCase("Username must be 16 characters or less."))
					{
						Util.msg(event, "The Minecraft account name " + args[1] + " must be 16 characters or less.");
					}

					else if (statusRaw.equalsIgnoreCase("Username must be alphanumerical (or contain '_')."))
					{
						Util.msg(event, "The Minecraft account name " + args[1] + " must be alphanumerical or contain an underscore.");
					}

					else if (statusRaw.contains(","))
					{
						String uuid = status[0];
						
						uuid = new StringBuilder(uuid).insert(uuid.length() - 24, "-").toString();
						uuid = new StringBuilder(uuid).insert(uuid.length() - 20, "-").toString();
						uuid = new StringBuilder(uuid).insert(uuid.length() - 16, "-").toString();
						uuid = new StringBuilder(uuid).insert(uuid.length() - 12, "-").toString();
						Util.msg(event, Colors.BOLD + "Username: " + Colors.NORMAL + status[1] + " | " + Colors.BOLD + "Account Status: " + Colors.NORMAL + "Premium" + " | " + Colors.BOLD + "Migrated: " + Colors.NORMAL + StringUtils.capitalize(status[2]) + " | " + Colors.BOLD + "UUID: " + Colors.NORMAL + uuid + " | " + Colors.BOLD + "Skin: " + Colors.NORMAL + "https://minotar.net/body/" + status[1] + "/500.png" + " | " + Colors.BOLD + "Raw Skin: " + Colors.NORMAL + "https://minotar.net/skin/" + status[1] + " | " + Colors.BOLD + "Powered by axis.iaero.me");
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			Util.msg(event, "An unknown error occured grabbing account information");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*accinfo" };
	}
}