package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Ping implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respondChannel("Pong!");
		Logger.botMsg(event.getChannel().getName(), "Pong!");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("Pong!");
		Logger.botMsg(event.getUser().getNick(), "Pong!");
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*ping" };
	}
}