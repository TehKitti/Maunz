package com.vauff.maunz.core;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

import com.vauff.maunz.features.CsgoUpdate;

public class Main
{
	public static CustomMultiBotManager<PircBotX> manager;
	public static PircBotX esperBot;
	public static PircBotX freenodeBot;
	public static int esperID = -2;
	public static int freenodeID = -1;
	public static String version = "3.9.4";
	
	public static void main(String args[]) throws Exception
	{
		createBot();
	}

	public static void createBot() throws Exception
	{
		Configuration<PircBotX> esperConfig = new Configuration.Builder<PircBotX>()
				.setName("Maunz")
				.setVersion(version)
				.setLogin("Maunz")
				.setAutoReconnect(true)
				.setNickservPassword(System.getenv().get("NickServ"))
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot created by Vauff.")
				.setServerHostname("irc.esper.net")
				.addListener(new Listener())
				.buildForServer("irc.esper.net");

		Configuration<PircBotX> freenodeConfig = new Configuration.Builder<PircBotX>()
				.setName("Maunz")
				.setVersion(version)
				.setLogin("Maunz")
				.setAutoReconnect(true)
				.setNickservPassword(System.getenv().get("NickServ"))
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot created by Vauff.")
				.setServerHostname("irc.freenode.net")
				.addAutoJoinChannel("#steamdb-announce")
				.addListener(new CsgoUpdate())
				.buildForServer("irc.freenode.net");

		manager = new CustomMultiBotManager<PircBotX>();
		manager.addBot(esperConfig);
		manager.addBot(freenodeConfig);
		manager.start();
		Util.isEnabled = true;
	}
}