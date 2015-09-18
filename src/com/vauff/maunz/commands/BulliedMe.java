package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.Main;

public class BulliedMe implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
			event.respond("Nobody bullied you? Okay then.");
		else
			event.getChannel().send().message(args[1] + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
			event.respond("Nobody bullied you? Okay then.");
		else
			Main.esperBot.sendIRC().message(args[1], "Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*bulliedme"};
	}
}