package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.Colors;

import java.net.JarURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class About implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respondChannel(Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		Logger.botMsg(event.getChannel().getName(), Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");

		if (Main.devMode)
		{
			event.respondChannel(Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
			Logger.botMsg(event.getChannel().getName(), Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
		}
		else
		{
			event.respondChannel(Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
			Logger.botMsg(event.getChannel().getName(), Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		}
		event.respondChannel(Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		event.respondChannel(Colors.PURPLE + "Build Date: " + Colors.RED + getBuildDate());
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Build Date: " + Colors.RED + getBuildDate());
		event.respondChannel(Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		event.respondChannel(Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		event.respondChannel(Colors.BROWN + "******************************");
		Logger.botMsg(event.getChannel().getName(), Colors.BROWN + "******************************");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond(Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		Logger.botMsg(event.getUser().getNick(), Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		if (Main.devMode)
		{
			event.respond(Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
			Logger.botMsg(event.getUser().getNick(), Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
		}
		else
		{
			event.respond(Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
			Logger.botMsg(event.getUser().getNick(), Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		}
		event.respond(Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		event.respond(Colors.PURPLE + "Build Date: " + Colors.RED + getBuildDate());
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Build Date: " + Colors.RED + getBuildDate());
		event.respond(Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		event.respond(Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		event.respond(Colors.BROWN + "******************************");
		Logger.botMsg(event.getUser().getNick(), Colors.BROWN + "******************************");
	}

	private String getBuildDate()
	{
		try
		{
			long unparsedTime = ((JarURLConnection) ClassLoader.getSystemResource(Main.class.getName().replace('.', '/') + ".class").openConnection()).getJarFile().getEntry("META-INF/MANIFEST.MF").getTime();
			Date date = new Date(unparsedTime);
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM d'" + getOrdinal(date.getDay()) + "', yyyy, h:mm a z");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			return sdf.format(date);
		}
		catch (ClassCastException e)
		{
			return "Not available in debug mode";
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
			return "Error";
		}
	}

	private String getOrdinal(int n)
	{
		if (n >= 11 && n <= 13)
		{
			return "th";
		}
		else
		{
			switch (n % 10)
			{
			case 1:
				return "st";
			case 2:
				return "nd";
			case 3:
				return "rd";
			default:
				return "th";
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*about" };
	}
}