package com.vauff.maunz.features;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.google.code.chatterbotapi.ChatterBotSession;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Intelligence implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	private static boolean alreadyStartedSession = false;

	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] message = event.getMessage().split(" ");
		ChatterBotSession chatSession;
		CleverbotSession session;

		if (!alreadyStartedSession)
		{
			session = new CleverbotSession();
			alreadyStartedSession = true;
			Logger.log.info("Started a new Cleverbot session");
		}
		else
		{
			session = CleverbotSession.getInstance();
		}

		chatSession = session.getSession();
		String response = chatSession.think(Util.addArgs(message, 1));

		Logger.log.info("Sending \"" + response + "\" in response to " + event.getUser().getNick() + "'s message \"" + Util.addArgs(message, 1) + "\"!");
		Logger.botMsg(event.getChannel().getName(), event.getUser().getNick() + ": " + response);
		event.respond(response);
	}

	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] message = event.getMessage().split(" ");
		ChatterBotSession chatSession;
		CleverbotSession session;

		if (!alreadyStartedSession)
		{
			session = new CleverbotSession();
			alreadyStartedSession = true;
			Logger.log.info("Started a new Cleverbot session");
		}
		else
		{
			session = CleverbotSession.getInstance();
		}

		chatSession = session.getSession();
		String response = chatSession.think(Util.addArgs(message, 1));

		Logger.log.info("Sending \"" + response + "\" in response to " + event.getUser().getNick() + "'s message \"" + Util.addArgs(message, 1) + "\"!");
		Logger.botMsg(event.getUser().getNick(), event.getUser().getNick() + ": " + response);
		event.respond(response);
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { Main.esperBot.getNick() + ",", Main.esperBot.getNick() + ":" };
	}
}
