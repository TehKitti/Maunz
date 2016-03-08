package com.vauff.maunz.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class WhoSay implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (!Say.whoSay.equals(""))
		{
			event.respondChannel("The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
			Logger.botMsg(event.getChannel().getName(), "The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
		}
		else
		{
			event.respondChannel("Nobody has used my *say command since I last started");
			Logger.botMsg(event.getChannel().getName(), "Nobody has used my *say command since I last started");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
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