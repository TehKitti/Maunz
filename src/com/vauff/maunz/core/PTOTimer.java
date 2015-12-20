package com.vauff.maunz.core;

import java.util.ArrayList;

public class PTOTimer
{
	public static Runnable timer = new Runnable()
	{
		public void run()
		{
			if (!Main.esperBot.isConnected() | !Main.freenodeBot.isConnected())
			{
				try
				{
					final ArrayList<String> command = new ArrayList<String>();

					command.add("java");
					command.add("-jar");
					command.add("Maunz" + Util.getJarInt(false) + ".jar");
					new ProcessBuilder(command).start();
					Main.manager.stop("Restarting due to a detected network disconnection");
					System.exit(0);

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	};
}
