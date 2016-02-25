package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Source implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respondChannel("My source is available at https://github.com/Vauff/Maunz");
		Logger.botMsg(event.getChannel().getName(), "My source is available at https://github.com/Vauff/Maunz");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("My source is available at https://github.com/Vauff/Maunz");
		Logger.botMsg(event.getUser().getNick(), "My source is available at https://github.com/Vauff/Maunz");
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*source" };
	}
}