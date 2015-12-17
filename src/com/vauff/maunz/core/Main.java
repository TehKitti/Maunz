package com.vauff.maunz.core;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

import com.vauff.maunz.features.CsgoUpdate;
import com.vauff.maunz.features.Grammar;

public class Main
{
	public static CustomMultiBotManager<PircBotX> manager;
	public static PircBotX esperBot;
	public static PircBotX freenodeBot;
	public static int esperID = -2;
	public static int freenodeID = -1;
	public static String version = "3.10.2";

	public static void main(String args[]) throws Exception
	{
		File log = new File("maunz.log");
		File oldLog = new File("maunz-old.log");
		File oldJar = new File("Maunz" + Util.getJarInt() + ".jar");

		Thread.sleep(3000);
		oldJar.delete();
		oldLog.delete();
		log.renameTo(oldLog);
		final Logger logger = LogManager.getLogger(Main.class);
		logger.info("Starting Maunz v" + version + "!");
		createBot();
	}

	public static void createBot() throws Exception
	{
		Configuration<PircBotX> esperConfig = new Configuration.Builder<PircBotX>()
				.setName("Maunz")
				.setVersion(version)
				.setLogin("Maunz")
				.setAutoReconnect(true)
				.setNickservPassword(Passwords.NICKSERV)
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot created by Vauff.")
				.setServerHostname("irc.esper.net")
				.addListener(new Listener())
				.addListener(new Grammar())
				.buildForServer("irc.esper.net");

		Configuration<PircBotX> freenodeConfig = new Configuration.Builder<PircBotX>()
				.setName("Maunz")
				.setVersion(version)
				.setLogin("Maunz")
				.setAutoReconnect(true)
				.setNickservPassword(Passwords.NICKSERV)
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot created by Vauff.")
				.setServerHostname("irc.freenode.net")
				.addAutoJoinChannel("#maunztesting")
				.addListener(new CsgoUpdate())
				.buildForServer("irc.freenode.net");

		manager = new CustomMultiBotManager<PircBotX>();
		manager.addBot(esperConfig);
		manager.addBot(freenodeConfig);
		manager.start();
		Util.isEnabled = true;
	}
}