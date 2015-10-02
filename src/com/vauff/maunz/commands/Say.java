package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Listener;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Say implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	public static String whoSay = "";
	public static String whoSayTime = "";
	
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");
		if (Listener.channels.contains(args[1])) 
		{
			Main.esperBot.sendIRC().message(args[1], addArgs(args, 2));
			whoSay = event.getUser().getNick();
			whoSayTime = Util.getTime();
		}
		else 
		{
			event.getChannel().send().message("I am not in the channel " + args[1] + "!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (Listener.channels.contains(args[1])) 
		{
			Main.esperBot.sendIRC().message(args[1], addArgs(args, 2));
			whoSay = event.getUser().getNick();
			whoSayTime = Util.getTime();
		}
		else 
		{
			event.respond("I am not in the channel " + args[1] + "!");
		}
	}
	
	private String addArgs(String[] args, int startIndex)
	{
		String s = "";
		
		for(int i = startIndex; i < args.length; i++)
		{
                        s += args[i] + " ";
		}
		
		return s;
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*say"};
	}
}