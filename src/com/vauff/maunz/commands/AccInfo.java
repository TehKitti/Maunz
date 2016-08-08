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
					BufferedReader uuidReader = new BufferedReader(new InputStreamReader(new URL("http://mcapi.ca/uuid/player/" + status[1]).openStream()));
					StringBuffer stringBuffer = new StringBuffer("");
					String line = null;
					
					while ((line = uuidReader.readLine()) != null) 
					{
					    stringBuffer.append(line);
					}

					String uuidStatusRaw = stringBuffer.toString();
					String[] uuidStatusRawSplit = uuidStatusRaw.split("\"");
					String uuidstatus = uuidStatusRawSplit[11];

					Util.msg(event, Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
					Util.msg(event, Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
					Util.msg(event, Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
					Util.msg(event, Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
					Util.msg(event, Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
					Util.msg(event, Colors.PURPLE + "Raw Skin: " + "https://minotar.net/skin/" + status[1]);
					Util.msg(event, Colors.BROWN + "****************************************");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			Util.msg(event, "Provide a username for me please!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
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
					BufferedReader uuidReader = new BufferedReader(new InputStreamReader(new URL("http://mcapi.ca/uuid/player/" + status[1]).openStream()));
					StringBuffer stringBuffer = new StringBuffer("");
					String line = null;
					
					while ((line = uuidReader.readLine()) != null) 
					{
					    stringBuffer.append(line);
					}

					String uuidStatusRaw = stringBuffer.toString();
					String[] uuidStatusRawSplit = uuidStatusRaw.split("\"");
					String uuidstatus = uuidStatusRawSplit[11];

					Util.msg(event, Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
					Util.msg(event, Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
					Util.msg(event, Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
					Util.msg(event, Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
					Util.msg(event, Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
					Util.msg(event, Colors.PURPLE + "Raw Skin: " + "https://minotar.net/skin/" + status[1]);
					Util.msg(event, Colors.BROWN + "****************************************");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			Util.msg(event, "Provide a username for me please!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*accinfo" };
	}
}