package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;

public class Help implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		event.respond("Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		event.respond("Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*help" };
	}
}