package com.vauff.maunz.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.commands.AccountInfo;
import com.vauff.maunz.commands.BulliedMe;
import com.vauff.maunz.commands.Disable;
import com.vauff.maunz.commands.Enable;
import com.vauff.maunz.commands.Help;
import com.vauff.maunz.commands.ICommand;
import com.vauff.maunz.commands.Join;
import com.vauff.maunz.commands.Leave;
import com.vauff.maunz.commands.Ping;
import com.vauff.maunz.commands.Restart;
import com.vauff.maunz.commands.Say;
import com.vauff.maunz.commands.Source;
import com.vauff.maunz.commands.Stop;
import com.vauff.maunz.commands.Trello;
import com.vauff.maunz.commands.UUID;
import com.vauff.maunz.commands.WhoSay;

public class Listener extends ListenerAdapter<PircBotX>
{
	public static List<String> channels = new ArrayList<String>();
	private LinkedList<ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>> commands = new LinkedList<ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>>();
	private static boolean onConnectSwitch = false;

	public Listener()
	{
		commands.add(new AccountInfo());
		commands.add(new BulliedMe());
		commands.add(new Enable());
		commands.add(new Disable());
		commands.add(new Help());
		commands.add(new Ping());
		commands.add(new Restart());
		commands.add(new Say());
		commands.add(new Source());
		commands.add(new Stop());
		commands.add(new UUID());
		commands.add(new Join());
		commands.add(new Leave());
		commands.add(new Intelligence());
		commands.add(new Trello());
		commands.add(new WhoSay());
	}

	@Override
	public void onMessage(MessageEvent<PircBotX> event) throws Exception
	{
		if(event.getBot().getServerInfo().getNetwork().equals("EsperNet"))
		{
			String cmdName = event.getMessage().split(" ")[0];

			if(Util.isEnabled)
			{
				for(ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>> cmd : commands)
				{
					for(String s : cmd.getAliases()) //iterating through all the aliases and seeing if any fit
					{	
						if(cmdName.equalsIgnoreCase(s))
						{
							cmd.exeChan(event);
							return;
						}
					}
				}
			}
			else
			{
				for(ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>> cmd : commands)
				{
					if(cmd instanceof Enable || cmd instanceof Disable)
					{
						for(String s : cmd.getAliases())
						{
							if(cmdName.equalsIgnoreCase(s))
							{
								cmd.exeChan(event);
								return;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void onPrivateMessage(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if(event.getBot().getServerInfo().getNetwork().equals("EsperNet"))
		{
			String cmdName = event.getMessage().split(" ")[0];

			if(Util.isEnabled)
			{
				for(ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>> cmd : commands)
				{
					for(String s : cmd.getAliases()) //iterating through all the aliases and seeing if any fit
					{	
						if(cmdName.equalsIgnoreCase(s))
						{
							cmd.exePrivate(event);
							return;
						}
					}
				}
			}
			else
			{
				for(ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>> cmd : commands)
				{
					if(cmd instanceof Enable || cmd instanceof Disable)
					{
						for(String s : cmd.getAliases())
						{
							if(cmdName.equalsIgnoreCase(s))
							{
								cmd.exePrivate(event);
								return;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void onConnect(ConnectEvent<PircBotX> event) throws Exception 
	{
		if (!onConnectSwitch)
		{
			for (String chan : Util.getFileContents()) 
			{
				if (chan.equals("#BreakInBadStaff")) 
				{
					Main.esperBot.sendIRC().joinChannel(chan, Passwords.BREAKIN_BAD_STAFF);
					channels.add(chan);
				}
				else 
				{
					Main.esperBot.sendIRC().joinChannel(chan);
					channels.add(chan);
				}
			}

			onConnectSwitch = true;
		}
		else
			onConnectSwitch = false;
	}
}