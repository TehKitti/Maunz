package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class WhoSay implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (!Say.whoSay.equals(""))
		{
			Util.msg(event, "The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
		}
		else
		{
			Util.msg(event, "Nobody has used my *say command since I last started");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (!Say.whoSay.equals(""))
		{
			Util.msg(event, "The last person who used my *say command was " + Say.whoSay + " on " + Say.whoSayTime);
		}
		else
		{
			Util.msg(event, "Nobody has used my *say command since I last started");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*whosay" };
	}
}