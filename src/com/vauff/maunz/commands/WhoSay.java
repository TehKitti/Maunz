package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.Util;

public class WhoSay implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if(!Say.whosay.equals(""))
			event.getChannel().send().message("The last person who used my *say command was " + Say.whosay + " on " + Util.getTime());
		else
		{
			event.getChannel().send().message("Nobody has used my *say command since I last started");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if(!Say.whosay.equals(""))
			event.respond("The last person who used my *say command was " + Say.whosay + " on " + Say.whosaytime);
		else
		{
			event.respond("Nobody has used my *say command since I last started");
		}
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*whosay"};
	}
}
