package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Trello implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		event.getChannel().send().message("My Trello board is located at https://trello.com/b/9W7PmTvX/maunz");
		Logger.botMsg(event.getChannel().getName(), "My Trello board is located at https://trello.com/b/9W7PmTvX/maunz");
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		event.respond("My Trello board is located at https://trello.com/b/9W7PmTvX/maunz");
		Logger.botMsg(event.getUser().getNick(), "My Trello board is located at https://trello.com/b/9W7PmTvX/maunz");
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*trello" };
	}
}