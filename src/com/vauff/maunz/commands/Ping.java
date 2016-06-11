package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Ping implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		Util.msg(event, "Pong!");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		Util.msg(event, "Pong!");
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*ping" };
	}
}