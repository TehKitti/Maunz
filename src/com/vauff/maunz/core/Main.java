package com.vauff.maunz.core;

import org.pircbotx.Configuration;
import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;

public class Main 
{
	public static PircBotX esperBot;
	public static PircBotX freenodeBot;

	public static void main(String args[]) throws Exception
	{
		createBot();
	}

	public static void createBot() throws Exception
	{
		Configuration.Builder<PircBotX> defaultConfig = new Configuration.Builder<PircBotX>()
		.setName("Maunz")
		.setVersion("1.0")
		.setLogin("Maunz")
		.setNickservPassword(Passwords.NICKSERV)
		.setAutoNickChange(true)
		.setCapEnabled(true)
		.setMessageDelay(400)
		.setRealName("Maunz, an IRC bot coded by Vauff.");
		Configuration esperConfig = defaultConfig
				.setServerHostname("irc.esper.net")
				.addListener(new Listener())
				.buildConfiguration();
		Configuration freenodeConfig = defaultConfig
				.setServerHostname("irc.freenode.net")
				.addAutoJoinChannel("#steamdb-announce")
				.addListener(new FreenodeListener())
				.buildConfiguration();
		MultiBotManager<PircBotX> manager = new MultiBotManager<PircBotX>();
		
		manager.addBot(esperConfig);
		manager.addBot(freenodeConfig);
		esperBot = new PircBotX(esperConfig);
		freenodeBot = new PircBotX(freenodeConfig);
		Util.isEnabled = true;
		manager.start();
	}
}