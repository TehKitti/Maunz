package com.vauff.maunz.core;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.pircbotx.Configuration;
import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

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
		Configuration<PircBotX> esperConfig = defaultConfig
				.setServerHostname("irc.esper.net")
				.addListener(new Listener())
				.buildForServer("irc.esper.net");
		Configuration<PircBotX> freenodeConfig = defaultConfig
				.setServerHostname("irc.freenode.net")
				.addAutoJoinChannel("#steamdb-announce")
				.addListener(new FreenodeListener())
				.buildForServer("irc.freenode.net");
		MultiBotManager<PircBotX> manager = new MultiBotManager<PircBotX>();
		
		manager.addBot(esperConfig);
		manager.addBot(freenodeConfig);
		esperBot = new PircBotX(esperConfig);
		freenodeBot = new PircBotX(freenodeConfig);
		Util.isEnabled = true;
		new Timer().schedule(new TimerTask() {          
		    @Override
		    public void run() {
		        try {
					freenodeBot.startBot();
				}
		        catch (IOException e) 
		        {
					e.printStackTrace();
				}
		        catch (IrcException e) 
		        {
					e.printStackTrace();
				}    
		    }
		}, 10000);
		esperBot.startBot();
    }
}