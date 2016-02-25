package com.vauff.maunz.core;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.commons.lang3.time.StopWatch;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.commands.*;
import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.features.Intelligence;

public class Listener extends ListenerAdapter
{
	private LinkedList<ICommand<MessageEvent, PrivateMessageEvent>> commands = new LinkedList<ICommand<MessageEvent, PrivateMessageEvent>>();
	public static StopWatch uptime = new StopWatch();

	public Listener()
	{
		commands.add(new About());
		commands.add(new AccInfo());
		commands.add(new BulliedMe());
		commands.add(new BullyMe());
		commands.add(new Changelog());
		commands.add(new Chans());
		commands.add(new Disable());
		commands.add(new Enable());
		commands.add(new Help());
		commands.add(new Intelligence());
		commands.add(new Join());
		commands.add(new Leave());
		commands.add(new Nick());
		commands.add(new Ping());
		commands.add(new Reddit());
		commands.add(new Reset());
		commands.add(new Restart());
		commands.add(new Say());
		commands.add(new Source());
		commands.add(new Steam());
		commands.add(new Stop());
		commands.add(new Trello());
		commands.add(new Update());
		commands.add(new WhoSay());

	}

	public void onMessage(MessageEvent event) throws Exception
	{
		String cmdName = event.getMessage().split(" ")[0];

		if (Util.isEnabled)
		{
			for (ICommand<MessageEvent, PrivateMessageEvent> cmd : commands)
			{
				for (String s : cmd.getAliases())
				{
					if (cmdName.equalsIgnoreCase(s))
					{
						cmd.exeChan(event);
					}
				}
			}
		}
		else
		{
			for (ICommand<MessageEvent, PrivateMessageEvent> cmd : commands)
			{
				if (cmd instanceof Enable || cmd instanceof Disable)
				{
					for (String s : cmd.getAliases())
					{
						if (cmdName.equalsIgnoreCase(s))
						{
							cmd.exeChan(event);
						}
					}
				}
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception
	{
		String cmdName = event.getMessage().split(" ")[0];

		if (Util.isEnabled)
		{
			for (ICommand<MessageEvent, PrivateMessageEvent> cmd : commands)
			{
				for (String s : cmd.getAliases())
				{
					if (cmdName.equalsIgnoreCase(s))
					{
						cmd.exePrivate(event);
					}
				}
			}
		}
		else
		{
			for (ICommand<MessageEvent, PrivateMessageEvent> cmd : commands)
			{
				if (cmd instanceof Enable || cmd instanceof Disable)
				{
					for (String s : cmd.getAliases())
					{
						if (cmdName.equalsIgnoreCase(s))
						{
							cmd.exePrivate(event);
						}
					}
				}
			}
		}
	}

	public void onConnect(ConnectEvent event) throws IOException
	{
		Main.esperID += 2;
		Main.freenodeID += 2;
		Main.esperBot = Main.manager.getBotById(Main.esperID);
		Main.freenodeBot = Main.manager.getBotById(Main.freenodeID);
		uptime.start();

		for (String chan : Util.getFileContents())
		{
			Main.esperBot.sendIRC().joinChannel(chan);
		}
	}
}