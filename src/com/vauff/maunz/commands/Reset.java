package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.features.Intelligence;

public class Reset implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		Intelligence.sessions.remove(event.getChannel().getName());
		event.getChannel().send().message("Session has been ended! A new one can be started by talking to me again.");
		Logger.botMsg(event.getChannel().getName(), "Session has been ended! A new one can be started by talking to me again.");
		Intelligence.sessionTimers.get(event.getChannel().getName()).cancel();
		Intelligence.sessionTimers.remove(event.getChannel().getName());
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		Intelligence.sessions.remove(event.getUser().getNick());
		event.respond("Session has been ended! A new one can be started by talking to me again.");
		Logger.botMsg(event.getUser().getNick(), "Session has been ended! A new one can be started by talking to me again.");
		Intelligence.sessionTimers.get(event.getUser().getNick()).cancel();
		Intelligence.sessionTimers.remove(event.getUser().getNick());
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*reset" };
	}
}