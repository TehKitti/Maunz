package com.vauff.maunz.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.pircbotx.Colors;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;

public class AccInfo implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accinfo?username=" + args[1] + "&format=csv").openStream()));
			String statusraw = reader.readLine();
			String[] status = statusraw.split(",");
			
			if (args[1].contains("#") || args[1].contains("&")) 
			{
				event.getChannel().send().message("The Minecraft account name " + args[1] + " must be alphanumeric.");
			}
			else
			{
			if(statusraw.equalsIgnoreCase("unknown username"))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " is free and does not belong to any account!");
			else if(statusraw.equalsIgnoreCase("Username must be 16 characters or less."))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " must be 16 characters or less.");
			else if(statusraw.equalsIgnoreCase("Username must be alphanumerical (or contain '_')."))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " must be alphanumeric.");
			else if(statusraw.contains(","))
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
				
				event.getChannel().send().message(Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
				event.getChannel().send().message(Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
				event.getChannel().send().message(Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
				event.getChannel().send().message(Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
				event.getChannel().send().message(Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
				event.getChannel().send().message(Colors.PURPLE + "Raw Skin: " + "http://skins.minecraft.net/MinecraftSkins/" + status[1] + ".png");
				event.getChannel().send().message(Colors.BROWN + "****************************************");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
		}
	}
	
	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accinfo?username=" + args[1] + "&format=csv").openStream()));
			String statusraw = reader.readLine();
			String[] status = statusraw.split(",");
			
			if (args[1].contains("#") || args[1].contains("&")) 
			{
				event.getUser().send().message("The Minecraft account name " + args[1] + " must be alphanumeric.");
			}
			else
			{
			if(statusraw.equalsIgnoreCase("unknown username"))
				event.getUser().send().message("The Minecraft account name " + args[1] + " is free and does not belong to any account!");
			else if(statusraw.equalsIgnoreCase("Username must be 16 characters or less."))
				event.getUser().send().message("The Minecraft account name " + args[1] + " must be 16 characters or less.");
			else if(statusraw.equalsIgnoreCase("Username must be alphanumerical (or contain '_')."))
				event.getUser().send().message("The Minecraft account name " + args[1] + " must be alphanumeric.");
			else if(statusraw.contains(","))
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
				
				event.getUser().send().message(Colors.BROWN + "**********" + Colors.BLUE + "Account Info For " + status[1] + Colors.BROWN + "**********");
				event.getUser().send().message(Colors.PURPLE + "Account Status: " + Colors.RED + "Premium");
				event.getUser().send().message(Colors.PURPLE + "Migrated: " + Colors.RED + StringUtils.capitalize(status[2]));
				event.getUser().send().message(Colors.PURPLE + "UUID: " + Colors.RED + uuidstatus);
				event.getUser().send().message(Colors.PURPLE + "Skin: " + "https://minotar.net/body/" + status[1] + "/500.png");
				event.getUser().send().message(Colors.PURPLE + "Raw Skin: " + "http://skins.minecraft.net/MinecraftSkins/" + status[1] + ".png");
				event.getUser().send().message(Colors.BROWN + "****************************************");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
		}
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*accinfo"};
	}
}