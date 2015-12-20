package com.vauff.maunz.commands;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Update implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if (event.getUser().getNick().equals("Vauff") && event.getUser().isVerified())
		{
			event.getChannel().send().message("I will run the auto update sequence!");

			ReadableByteChannel url = Channels.newChannel(new URL("https://dl.dropboxusercontent.com/u/85708850/Maunz.jar").openStream());
			FileOutputStream file = new FileOutputStream("Maunz" + Util.getJarInt(true) + ".jar");
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(true) + ".jar");
			file.getChannel().transferFrom(url, 0, Long.MAX_VALUE);
			file.close();
			new ProcessBuilder(command).start();
			Main.manager.stop("Updating and restarting");
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
			event.respond("I will run the auto update sequence!");

			ReadableByteChannel url = Channels.newChannel(new URL("https://dl.dropboxusercontent.com/u/85708850/Maunz.jar").openStream());
			FileOutputStream file = new FileOutputStream("Maunz" + Util.getJarInt(true) + ".jar");
			final ArrayList<String> command = new ArrayList<String>();

			command.add("java");
			command.add("-jar");
			command.add("Maunz" + Util.getJarInt(true) + ".jar");
			file.getChannel().transferFrom(url, 0, Long.MAX_VALUE);
			file.close();
			new ProcessBuilder(command).start();
			Main.manager.stop("Updating and restarting");
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*update" };
	}
}