package com.vauff.maunz.commands;

import java.util.ArrayList;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Restart implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(false) + ".jar");
			Logger.log.info("Maunz is restarting...");
			new ProcessBuilder(command).start();
			Main.manager.stop("Restarting");
			System.exit(0);
		}
		else
		{
			Util.msg(event, "You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(false) + ".jar");
			Logger.log.info("Maunz is restarting...");
			new ProcessBuilder(command).start();
			Main.manager.stop("Restarting");
			System.exit(0);
		}
		else
		{
			Util.msg(event, "You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*restart" };
	}
}