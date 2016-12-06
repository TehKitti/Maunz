package com.vauff.maunz.commands;

import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Map implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (!Util.getFileContents("lastmap.txt").endsWith("_OLD-DATA"))
		{
			Util.msg(event, "GFL Zombie Escape is currently playing: " + Colors.BOLD + Util.getFileContents("lastmap.txt"));
		}
		else
		{
			Util.msg(event, "Failed to grab map data, maybe the server is down?");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (!Util.getFileContents("lastmap.txt").endsWith("_OLD-DATA"))
		{
			Util.msg(event, "GFL Zombie Escape is currently playing: " + Colors.BOLD + Util.getFileContents("lastmap.txt"));
		}
		else
		{
			Util.msg(event, "Failed to grab map data, maybe the server is down?");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*map" };
	}
}