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
			Main.manager.stop("Updating");
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
			Main.manager.stop("Updating");
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
		return new String[] { "*update" };
	}
}