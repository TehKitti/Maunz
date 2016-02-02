package com.vauff.maunz.features;

import java.util.ArrayList;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Main;
import com.vauff.maunz.core.Util;

public class PTOTimer
{
	public static Runnable timer = new Runnable()
	{
		public void run()
		{
			if (!Main.esperBot.isConnected() || !Main.freenodeBot.isConnected())
			{
				try
				{
					final ArrayList<String> command = new ArrayList<String>();

					command.add("java");
					command.add("-jar");
					command.add("Maunz" + Util.getJarInt(false) + ".jar");
					new ProcessBuilder(command).start();
					Logger.log.info("Restarting due to an automatically detected network disconnection");
					Main.manager.stop("Restarting due to an automatically detected network disconnection");
					System.exit(0);
				}
				catch (Exception e)
				{
					Logger.log.error(e);
				}
			}
		}
	};
}
