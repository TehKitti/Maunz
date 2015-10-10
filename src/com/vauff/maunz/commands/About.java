package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.Colors;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class About implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	String builddate = "Friday October 10th 2015, 10:21 PM GMT";
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		event.getChannel().send().message(Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		event.getChannel().send().message(Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		event.getChannel().send().message(Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		event.getChannel().send().message(Colors.PURPLE + "Build Date: " + Colors.RED + builddate);
		event.getChannel().send().message(Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		event.getChannel().send().message(Colors.BROWN + "******************************");
		
	}
	
	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		event.respond(Colors.BROWN + "**********" + Colors.BLUE + "About Maunz" + Colors.BROWN + "**********");
		event.respond(Colors.DARK_GREEN + "Maunz is an IRC bot created by Vauff with help from bl4ckscor3");
		event.respond(Colors.PURPLE + "Version: " + Colors.RED + Main.version);
		event.respond(Colors.PURPLE + "Build Date: " + Colors.RED + builddate);
		event.respond(Colors.PURPLE + "Uptime: " + Colors.RED + Util.getUptime());
		event.respond(Colors.BROWN + "******************************");
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*about"};
	}
}