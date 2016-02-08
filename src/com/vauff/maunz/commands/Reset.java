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
		if (Intelligence.sessions.containsKey(event.getChannel().getName()))
		{
			Intelligence.sessions.remove(event.getChannel().getName());
			event.getChannel().send().message("Session has been ended! A new one can be started by talking to me again.");
			Logger.botMsg(event.getChannel().getName(), "Session has been ended! A new one can be started by talking to me again.");
			Intelligence.sessionTimers.get(event.getChannel().getName()).cancel();
			Intelligence.sessionTimers.remove(event.getChannel().getName());
		}
		else
		{
			event.getChannel().send().message("There is not a session currently running in this channel!");
			Logger.botMsg(event.getChannel().getName(), "There is not a session currently running in this channel!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if (Intelligence.sessions.containsKey(event.getUser().getNick()))
		{
			Intelligence.sessions.remove(event.getUser().getNick());
			event.respond("Session has been ended! A new one can be started by talking to me again.");
			Logger.botMsg(event.getUser().getNick(), "Session has been ended! A new one can be started by talking to me again.");
			Intelligence.sessionTimers.get(event.getUser().getNick()).cancel();
			Intelligence.sessionTimers.remove(event.getUser().getNick());
		}
		else
		{
			event.respond("There is not a session currently running in this channel!");
			Logger.botMsg(event.getUser().getNick(), "There is not a session currently running in this channel!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*reset" };
	}
}