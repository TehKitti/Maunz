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
		String about;

		if (Util.devMode)
		{
			about = "Maunz is an IRC bot created by V4uff";
		}
		else
		{
			about = "Maunz is an IRC bot created by Vauff";
		}

		Util.msg(event, Colors.BOLD + "About: " + Colors.NORMAL + about + " | " + Colors.BOLD + "Version: " + Colors.NORMAL + Main.version + " | " + Colors.BOLD + "Build Date: " + Colors.NORMAL + getBuildDate() + " | " + Colors.BOLD + "Dev Mode: " + Colors.NORMAL + StringUtils.capitalize(Boolean.toString(Util.devMode)) + " | " + Colors.BOLD + "Uptime: " + Colors.NORMAL + Util.getUptime());
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String about;

		if (Util.devMode)
		{
			about = "Maunz is an IRC bot created by V4uff";
		}
		else
		{
			about = "Maunz is an IRC bot created by Vauff";
		}

		Util.msg(event, Colors.BOLD + "About: " + Colors.NORMAL + about + " | " + Colors.BOLD + "Version: " + Colors.NORMAL + Main.version + " | " + Colors.BOLD + "Build Date: " + Colors.NORMAL + getBuildDate() + " | " + Colors.BOLD + "Dev Mode: " + Colors.NORMAL + StringUtils.capitalize(Boolean.toString(Util.devMode)) + " | " + Colors.BOLD + "Uptime: " + Colors.NORMAL + Util.getUptime());
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