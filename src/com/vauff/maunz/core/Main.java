package com.vauff.maunz.core;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;

import org.pircbotx.Configuration;
import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;

import com.vauff.maunz.features.CsgoUpdate;
import com.vauff.maunz.features.Grammar;
import com.vauff.maunz.features.PTOTimer;
import com.vauff.maunz.features.RSSTimer;

public class Main
{
	public static MultiBotManager manager;
	public static PircBotX esperBot;
	public static PircBotX freenodeBot;
	public static int esperID = -2;
	public static int freenodeID = -1;
	public static String version = "3.13.5";
	public static boolean devMode;

	public static void main(String args[]) throws Exception
	{
		File log = new File("maunz.log");
		File oldLog = new File("maunz-old.log");
		File oldJar = new File("Maunz" + Util.getJarInt(true) + ".jar");

		Thread.sleep(3000);
		oldJar.delete();
		oldLog.delete();
		log.renameTo(oldLog);
		Logger.log = LogManager.getLogger(Main.class);

		if (args.length >= 1 && args[0].equals("-dev"))
		{
			Logger.log.info("Starting Maunz v" + version + " in dev mode");
			Util.freenodeChannel = "#maunztesting";
			Util.mainChannel = "#bl4ckb0tTest";
			CsgoUpdate.listeningNick = "Vauff";
			devMode = true;
		}
		else
		{
			Logger.log.info("Starting Maunz v" + version);
			Util.freenodeChannel = "#steamdb-announce";
			Util.mainChannel = "#bl4ckscor3";
			CsgoUpdate.listeningNick = "SteamDB";
			devMode = false;
		}

		createBot();
	}

	public static void createBot() throws Exception
	{
		Configuration esperConfig = new Configuration.Builder()
				.setName("Maunz")
				.setVersion(version)
				.setLogin("Maunz")
				.setNickservPassword(Passwords.esperNickServ)
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot created by Vauff.")
				.addServer("irc.esper.net")
				.addListener(new Listener())
				.addListener(new Grammar())
				.addListener(new Logger())
				.buildForServer("irc.esper.net");

		Configuration freenodeConfig = new Configuration.Builder()
				.setName("Maunz")
				.setVersion(version)
				.setLogin("Maunz")
				.setNickservPassword(Passwords.freenodeNickServ)
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot created by Vauff.")
				.addServer("irc.freenode.net")
				.addAutoJoinChannel(Util.freenodeChannel)
				.addListener(new CsgoUpdate())
				.addListener(new Logger())
				.buildForServer("irc.freenode.net");

		manager = new MultiBotManager();
		manager.addBot(esperConfig);
		manager.addBot(freenodeConfig);
		manager.start();
		Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(RSSTimer.timer, 60, 60, TimeUnit.SECONDS);
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(PTOTimer.timer, 60, 60, TimeUnit.SECONDS);
	}
}