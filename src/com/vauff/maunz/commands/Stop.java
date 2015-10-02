package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Main;

public class Stop implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		if(event.getUser().getNick().equals("Vauff"))
		{
			Main.esperBot.sendRaw().rawLine("QUIT :I was ordered to stop by Vauff");
			Main.freenodeBot.sendRaw().rawLine("QUIT :I was ordered to stop by Vauff");
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		if(event.getUser().getNick().equals("Vauff"))
		{
			Main.esperBot.sendRaw().rawLine("QUIT :I was ordered to stop by Vauff");
			Main.freenodeBot.sendRaw().rawLine("QUIT :I was ordered to stop by Vauff");
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[]{"*stop"};
	}
}