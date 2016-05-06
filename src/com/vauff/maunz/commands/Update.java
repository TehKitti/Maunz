package com.vauff.maunz.commands;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Update implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			event.respondChannel("I will run the auto update sequence!");
			Logger.botMsg(event.getChannel().getName(), "I will run the auto update sequence!");

			ReadableByteChannel url = Channels.newChannel(new URL("https://dl.dropboxusercontent.com/u/85708850/Maunz.jar").openStream());
			FileOutputStream file = new FileOutputStream("Maunz" + Util.getJarInt(true) + ".jar");
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(true) + ".jar");
			file.getChannel().transferFrom(url, 0, Long.MAX_VALUE);
			file.close();
			new ProcessBuilder(command).start();
			Logger.log.info("Maunz is updating...");
			Main.manager.stop("Updating and restarting");
			System.exit(0);
		}
		else
		{
			event.respondChannel("You do not have permission to use that command");
			Logger.botMsg(event.getChannel().getName(), "You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			event.respond("I will run the auto update sequence!");
			Logger.botMsg(event.getUser().getNick(), "I will run the auto update sequence!");

			ReadableByteChannel url = Channels.newChannel(new URL("https://dl.dropboxusercontent.com/u/85708850/Maunz.jar").openStream());
			FileOutputStream file = new FileOutputStream("Maunz" + Util.getJarInt(true) + ".jar");
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(true) + ".jar");
			file.getChannel().transferFrom(url, 0, Long.MAX_VALUE);
			file.close();
			new ProcessBuilder(command).start();
			Logger.log.info("Maunz is updating...");
			Main.manager.stop("Updating and restarting");
			System.exit(0);
		}
		else
		{
			event.respond("You do not have permission to use that command");
			Logger.botMsg(event.getUser().getNick(), "You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*update" };
	}
}