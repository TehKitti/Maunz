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
			OutputIRC irc = new OutputIRC(Main.esperBot);

			for (String p : Listener.channels) 
			{
			Main.esperBot.sendIRC().message(p, "I have been ordered to restart by " + event.getUser().getNick());
			}
			Listener.channels.clear();
			irc.quitServer();
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
			OutputIRC irc = new OutputIRC(Main.esperBot);

			for (String p : Listener.channels) 
			{
			Main.esperBot.sendIRC().message(p, "I have been ordered to restart by " + event.getUser().getNick());
			}
			event.respond("I have been ordered to restart by " + event.getUser().getNick());
			Listener.channels.clear();
			irc.quitServer();
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