package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.output.OutputIRC;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Listener;
import com.vauff.maunz.core.Main;

public class Restart implements ICommand<MessageEvent<PircBotX>,PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception 
	{
		if(event.getUser().getNick().equals("Vauff"))
		{
			Main.esperBot.sendRaw().rawLine("QUIT :I was ordered to restart by Vauff");
			Main.freenodeBot.sendRaw().rawLine("QUIT :I was ordered to restart by Vauff");
			Listener.channels.clear();
			Listener.uptime.stop();
			Listener.uptime.reset();
			Main.createBot();
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
			Main.esperBot.sendRaw().rawLine("QUIT :I was ordered to restart by Vauff");
			Main.freenodeBot.sendRaw().rawLine("QUIT :I was ordered to restart by Vauff");
			Listener.channels.clear();
			Listener.uptime.stop();
			Listener.uptime.reset();
			Main.createBot();
		}
		else
		{
			event.respond("You do not have permission to use that command");
		}
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*restart"};
	}
}