package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Ping implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		event.respond("Pong!");
	}
	
	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		event.respond("Pong!");
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*ping"};
	}
}