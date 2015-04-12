package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Source implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan	(MessageEvent event) throws Exception
	{
		event.respond("My source is available at https://github.com/Vauff/Maunz");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("My source is available at https://github.com/Vauff/Maunz");
	}

	@Override
	public String[] getAliases()
	{
		return new String[]{"*source"};
	}
}