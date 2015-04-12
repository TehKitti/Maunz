package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Ping implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respond("Pong!");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("Pong!");
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*ping"};
	}
}