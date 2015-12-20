package com.vauff.maunz.core;

import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;

import static com.google.common.util.concurrent.Service.State;

/**
 * This code is used to bring a feature to have a quit message from PircBotX 2.1 into 2.0.1 
 * From this class https://github.com/TheLQ/pircbotx/blob/master/src/main/java/org/pircbotx/MultiBotManager.java 
 * And this commit https://github.com/TheLQ/pircbotx/commit/0b3056bf4392adc0cbb8082dcc0fe50be6df0d24 
 * All credit to TheLQ
 */
public class CustomMultiBotManager<T extends PircBotX> extends MultiBotManager<T>
{
	/**
	 * Stop with no quit message
	 * @see #stop(java.lang.String)
	 */
	@Override
	public void stop()
	{
		stop("");
	}

	/**
	 * Disconnect all bots from their respective severs cleanly.
	 */
	public void stop(String quitMessage)
	{
		synchronized (stateLock)
		{
			if (state != State.RUNNING)
			{
				throw new RuntimeException("MultiBotManager cannot be stopped again or before starting. State: " + state);
			}
			state = State.STOPPING;
		}

		for (PircBotX bot : runningBots.keySet())
		{
			if (bot.isConnected())
			{
				bot.sendIRC().quitServer(quitMessage);
			}
		}

		botPool.shutdown();
	}
}