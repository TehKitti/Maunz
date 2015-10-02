package com.vauff.maunz.features;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class CleverbotSession
{
	private static ChatterBotSession session;
	private static CleverbotSession instance;
	
	public CleverbotSession() throws Exception
	{
		ChatterBotFactory factory = new ChatterBotFactory();
		ChatterBot bot = factory.create(ChatterBotType.CLEVERBOT);

		session = bot.createSession();
		instance = this;
	}
	
	public static ChatterBotSession getSession()
	{
		return session;
	}
	
	public static CleverbotSession getInstance()
	{
		return instance;
	}
}
