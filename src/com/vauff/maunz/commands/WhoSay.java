package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class WhoSay implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if (!Say.whoSay.equals(""))
		{
			event.getChannel().send().message("The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
			Logger.botMsg(event.getChannel().getName(), "The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
		}
		else
		{
			event.getChannel().send().message("Nobody has used my *say command since I last started");
			Logger.botMsg(event.getChannel().getName(), "Nobody has used my *say command since I last started");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if (!Say.whoSay.equals(""))
		{
			event.respond("The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
			Logger.botMsg(event.getUser().getNick(), "The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
		}
		else
		{
			event.respond("Nobody has used my *say command since I last started");
			Logger.botMsg(event.getUser().getNick(), "Nobody has used my *say command since I last started");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*whosay" };
	}
}