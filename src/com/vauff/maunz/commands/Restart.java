package com.vauff.maunz.commands;

import java.util.ArrayList;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Restart implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(false) + ".jar");
			new ProcessBuilder(command).start();
			Main.manager.stop("Restarting");
			System.exit(0);
		}
		else
		{
			event.getChannel().send().message("You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(false) + ".jar");
			new ProcessBuilder(command).start();
			Main.manager.stop("Restarting");
			System.exit(0);
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*restart" };
	}
}