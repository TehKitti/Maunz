package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.Colors;

import java.net.JarURLConnection;

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
		Util.msg(event, Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");

		if (Main.devMode)
		{
			Util.msg(event, Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
		}
		else
		{
			Util.msg(event, Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		}

		Util.msg(event, Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		Util.msg(event, Colors.PURPLE + "Build Date: " + Colors.RED + getBuildDate());
		Util.msg(event, Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		Util.msg(event, Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		Util.msg(event, Colors.BROWN + "******************************");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		Util.msg(event, Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");

		if (Main.devMode)
		{
			Util.msg(event, Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
		}
		else
		{
			Util.msg(event, Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		}
		
		Util.msg(event, Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		Util.msg(event, Colors.PURPLE + "Build Date: " + Colors.RED + getBuildDate());
		Util.msg(event, Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		Util.msg(event, Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		Util.msg(event, Colors.BROWN + "******************************");
	}

	private String getBuildDate()
	{
		try
		{
			long unparsedTime = ((JarURLConnection) ClassLoader.getSystemResource(Main.class.getName().replace('.', '/') + ".class").openConnection()).getJarFile().getEntry("META-INF/MANIFEST.MF").getTime();

			return Util.getTime(unparsedTime);
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

	@Override
	public String[] getAliases()
	{
		return new String[] { "*about" };
	}
}