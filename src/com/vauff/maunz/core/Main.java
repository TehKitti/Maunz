package com.vauff.maunz.core;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;

import org.pircbotx.Configuration;
import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;

import com.vauff.maunz.features.CsgoUpdate;
import com.vauff.maunz.features.GFLTimer;
import com.vauff.maunz.features.Grammar;
import com.vauff.maunz.features.ImgurCorrector;
import com.vauff.maunz.features.PTOTimer;
import com.vauff.maunz.features.SCSRSSTimer;
import com.vauff.maunz.features.TaskController;
import com.vauff.maunz.features.CSGORSSTimer;

public class Main
{
	public static MultiBotManager manager;
	public static PircBotX esperBot;
	public static PircBotX freenodeBot;
	public static String version = "3.19.3";
	public static boolean devMode;

	public static void main(String args[]) throws Exception
	{
		try
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
				Util.secondaryChannel = "#whatever";
				Util.privateChannel = "#TaCoTest";
				CsgoUpdate.listeningNick = "Vauff";
				devMode = true;
			}
			else
			{
				Logger.log.info("Starting Maunz v" + version);
				Util.freenodeChannel = "#steamdb-announce";
				Util.mainChannel = "#mancave";
				Util.secondaryChannel = "#extruders";
				Util.privateChannel = "#TaskController";
				CsgoUpdate.listeningNick = "SteamDB";
				devMode = false;
			}

			createBot();
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
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
				.addListener(new Grammar())
				.addListener(new ImgurCorrector())
				.addListener(new EsperListener())
				.addListener(new Logger())
				.addListener(new TaskController())
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
				.addListener(new FreenodeListener())
				.addListener(new Logger())
				.buildForServer("irc.freenode.net");

		manager = new MultiBotManager();
		manager.addBot(esperConfig);
		manager.addBot(freenodeConfig);
		manager.start();
		Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(GFLTimer.timer, 60, 60, TimeUnit.SECONDS);
		Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(CSGORSSTimer.timer, 75, 60, TimeUnit.SECONDS);
		Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(SCSRSSTimer.timer, 90, 60, TimeUnit.SECONDS);
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(PTOTimer.timer, 105, 60, TimeUnit.SECONDS);
	}
}
