package com.vauff.maunz.features;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class CleverbotSession
{
	private ChatterBotSession session;

	public CleverbotSession() throws Exception
	{
		ChatterBotFactory factory = new ChatterBotFactory();
		ChatterBot bot = factory.create(ChatterBotType.CLEVERBOT);

		session = bot.createSession();
	}

	public ChatterBotSession getSession()
	{
		return session;
	}
}
