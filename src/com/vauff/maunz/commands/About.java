package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.Colors;

import org.apache.commons.lang3.StringUtils;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class About implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	String builddate = "Wednesday February 3rd 2015, 8:00 PM GMT";

	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		event.getChannel().send().message(Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		Logger.botMsg(event.getChannel().getName(), Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		if (Main.devMode)
		{
			event.getChannel().send().message(Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
			Logger.botMsg(event.getChannel().getName(), Colors.DARK_GREEN + "Maunz is an IRC bot created by V4uff with help from blackscore");
		}
		else
		{
			event.getChannel().send().message(Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
			Logger.botMsg(event.getChannel().getName(), Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		}
		event.getChannel().send().message(Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		event.getChannel().send().message(Colors.PURPLE + "Build Date: " + Colors.RED + builddate);
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Build Date: " + Colors.RED + builddate);
		event.getChannel().send().message(Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		event.getChannel().send().message(Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		Logger.botMsg(event.getChannel().getName(), Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		event.getChannel().send().message(Colors.BROWN + "******************************");
		Logger.botMsg(event.getChannel().getName(), Colors.BROWN + "******************************");
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
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
		event.respond(Colors.PURPLE + "Build Date: " + Colors.RED + builddate);
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Build Date: " + Colors.RED + builddate);
		event.respond(Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Dev Mode: " + Colors.RED + StringUtils.capitalize(Boolean.toString(Main.devMode)));
		event.respond(Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		Logger.botMsg(event.getUser().getNick(), Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		event.respond(Colors.BROWN + "******************************");
		Logger.botMsg(event.getUser().getNick(), Colors.BROWN + "******************************");
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*about" };
	}
}