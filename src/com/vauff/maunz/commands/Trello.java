package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Trello implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respond("My Trello board is located at https://trello.com/b/9W7PmTvX/maunz");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("My Trello board is located at https://trello.com/b/9W7PmTvX/maunz");
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*trello"};
	}
}