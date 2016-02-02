package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Source implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		event.getChannel().send().message("My source is available at https://github.com/Vauff/Maunz");
		Logger.botMsg(event.getChannel().getName(), "My source is available at https://github.com/Vauff/Maunz");
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
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