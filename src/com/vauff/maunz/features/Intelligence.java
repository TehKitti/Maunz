package com.vauff.maunz.features;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.google.code.chatterbotapi.ChatterBotSession;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class Intelligence implements ICommand<MessageEvent, PrivateMessageEvent>
{
	public static HashMap<String, CleverbotSession> sessions = new HashMap<String, CleverbotSession>();
	public static HashMap<String, Timer> sessionTimers = new HashMap<String, Timer>();

	public void exeChan(MessageEvent event) throws Exception
	{
		event.respondChannel("This feature is temporarily disabled due to a broken API");

		/*
		try
		{
			String[] message = event.getMessage().split(" ");
			ChatterBotSession chatSession;
			CleverbotSession session;

			if (!sessions.containsKey(event.getChannel().getName()))
			{
				session = new CleverbotSession();
				sessions.put(event.getChannel().getName(), session);
				event.respondChannel("New Cleverbot session started for " + event.getChannel().getName() + ". This session will automatically end after 15 minutes of inactivity. It can also be stopped manually by using the *reset command. If this conversation gets long, please use #CleverMaunz if not already.");
				Logger.botMsg(event.getChannel().getName(), "New Cleverbot session started for " + event.getChannel().getName() + ". This session will automatically end after 15 minutes of inactivity. It can also be stopped manually by using the *reset command. If this conversation gets long, please use #CleverMaunz if not already.");

				TimerTask timerTask = new TimerTask()
				{

					@Override
					public void run()
					{
						sessions.remove(event.getChannel().getName());
						Intelligence.sessionTimers.get(event.getChannel().getName()).cancel();
						Intelligence.sessionTimers.remove(event.getChannel().getName());
						event.respondChannel("Session has been automatically ended after 15 minutes of inactivity!");
						Logger.botMsg(event.getChannel().getName(), "Session has been automatically ended after 15 minutes of inactivity! A new one can be started by talking to me again.");
					}
				};

				sessionTimers.put(event.getChannel().getName(), new Timer());
				sessionTimers.get(event.getChannel().getName()).schedule(timerTask, 900000);
			}
			else
			{
				session = sessions.get(event.getChannel().getName());

				TimerTask timerTask = new TimerTask()
				{

					@Override
					public void run()
					{
						sessions.remove(event.getChannel().getName());
						Intelligence.sessionTimers.get(event.getChannel().getName()).cancel();
						Intelligence.sessionTimers.remove(event.getChannel().getName());
						event.respondChannel("Session has been automatically ended after 15 minutes of inactivity!");
						Logger.botMsg(event.getChannel().getName(), "Session has been automatically ended after 15 minutes of inactivity! A new one can be started by talking to me again.");

					}
				};

				sessionTimers.get(event.getChannel().getName()).cancel();
				sessionTimers.put(event.getChannel().getName(), new Timer());
				sessionTimers.get(event.getChannel().getName()).schedule(timerTask, 900000);
			}

			chatSession = session.getSession();
			String response = chatSession.think(Util.addArgs(message, 1));

			Logger.log.info("Sending \"" + response + "\" in response to " + event.getChannel().getName() + "'s message \"" + Util.addArgs(message, 1) + "\"!");
			Logger.botMsg(event.getChannel().getName(), event.getChannel().getName() + ": " + response);
			event.respond(response);
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
		*/
	}

	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("This feature is temporarily disabled due to a broken API");
		
		/*
		try
		{
			String[] message = event.getMessage().split(" ");
			ChatterBotSession chatSession;
			CleverbotSession session;

			if (!sessions.containsKey(event.getUser().getNick()))
			{
				session = new CleverbotSession();
				sessions.put(event.getUser().getNick(), session);
				event.respond("New Cleverbot session started for " + event.getUser().getNick() + ". This session will automatically end after 15 minutes of inactivity. It can also be stopped manually by using the *reset command.");
				Logger.botMsg(event.getUser().getNick(), "New Cleverbot session started for " + event.getUser().getNick() + ". This session will automatically end after 15 minutes of inactivity. It can also be stopped manually by using the *reset command.");

				TimerTask timerTask = new TimerTask()
				{

					@Override
					public void run()
					{
						sessions.remove(event.getUser().getNick());
						Intelligence.sessionTimers.get(event.getUser().getNick()).cancel();
						Intelligence.sessionTimers.remove(event.getUser().getNick());
						event.respond("Session has been automatically ended after 15 minutes of inactivity!");
						Logger.botMsg(event.getUser().getNick(), "Session has been automatically ended after 15 minutes of inactivity! A new one can be started by talking to me again.");
					}
				};

				sessionTimers.put(event.getUser().getNick(), new Timer());
				sessionTimers.get(event.getUser().getNick()).schedule(timerTask, 900000);
			}
			else
			{
				session = sessions.get(event.getUser().getNick());

				TimerTask timerTask = new TimerTask()
				{

					@Override
					public void run()
					{
						sessions.remove(event.getUser().getNick());
						Intelligence.sessionTimers.get(event.getUser().getNick()).cancel();
						Intelligence.sessionTimers.remove(event.getUser().getNick());
						event.respond("Session has been automatically ended after 15 minutes of inactivity!");
						Logger.botMsg(event.getUser().getNick(), "Session has been automatically ended after 15 minutes of inactivity! A new one can be started by talking to me again.");

					}
				};

				sessionTimers.get(event.getUser().getNick()).cancel();
				sessionTimers.put(event.getUser().getNick(), new Timer());
				sessionTimers.get(event.getUser().getNick()).schedule(timerTask, 900000);
			}

			chatSession = session.getSession();
			String response = chatSession.think(Util.addArgs(message, 1));

			Logger.log.info("Sending \"" + response + "\" in response to " + event.getUser().getNick() + "'s message \"" + Util.addArgs(message, 1) + "\"!");
			Logger.botMsg(event.getUser().getNick(), event.getUser().getNick() + ": " + response);
			event.respond(response);
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
		*/
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { Main.esperBot.getNick() + ",", Main.esperBot.getNick() + ":" };
	}
}