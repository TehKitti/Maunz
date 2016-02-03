package com.vauff.maunz.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.pircbotx.Channel;

import com.google.common.collect.ImmutableSortedSet;

public class Util
{
	public static boolean isEnabled = true;
	public static String mainChannel;
	public static String freenodeChannel;

	public static String getJarLocation()
	{
		try
		{
			String path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();

			if (path.endsWith(".jar"))
			{
				path = path.substring(0, path.lastIndexOf("/"));
			}

			if (!path.endsWith("/"))
			{
				path += "/";
			}

			return path;
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();

			return null;
		}
	}

	public static List<String> getFileContents() throws IOException
	{
		File file = new File(getJarLocation() + "chans.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String[] result = reader.readLine().split(",");

		if (!file.exists())
		{
			file.createNewFile();
		}

		reader.close();

		return Arrays.asList(result);
	}

	public static String getTime()
	{
		String time = new Date(System.currentTimeMillis()).toString();

		return time;
	}

	public static String getUptime()
	{
		Listener.uptime.split();

		String[] uptimeraw = Listener.uptime.toSplitString().split("\\.");
		int hours = Integer.parseInt(uptimeraw[0].split(":")[0]);
		int days = (hours / 24) >> 0;

		hours = hours % 24;

		return days + ":" + (hours < 10 ? "0" + hours : hours) + ":" + uptimeraw[0].split(":")[1] + ":" + uptimeraw[0].split(":")[2];
	}

	public static String addArgs(String[] args, int startIndex)
	{
		String s = "";

		for (int i = startIndex; i < args.length; i++)
		{
			s += args[i] + " ";
		}

		return s.substring(0, s.lastIndexOf(" "));
	}

	public static int getJarInt(boolean opposite) throws URISyntaxException
	{
		int number = 0;

		if (opposite == true)
		{
			if (new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().contains("1"))
			{
				number = 2;
			}

			if (new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().contains("2"))
			{
				number = 1;
			}
		}

		if (opposite == false)
		{
			if (new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().contains("1"))
			{
				number = 1;
			}

			if (new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().contains("2"))
			{
				number = 2;
			}
		}

		return number;
	}

	public static boolean hasJoinedChannel(String channel)
	{
		String[] chans = getJoinedChannels();

		for (String s : chans)
		{
			if (s != null)
			{
				if (s.equalsIgnoreCase(channel))
				{
					return true;
				}
			}
		}
		return false;
	}

	public static String[] getJoinedChannels()
	{
		ImmutableSortedSet<Channel> list = Main.esperBot.getUserBot().getChannels();
		Object[] x = list.toArray();
		String[] chans = new String[x.length];
		int i = 0;

		for (Object o : x)
		{
			chans[i] = o.toString().split(",")[0].split("=")[1];
			i++;
		}

		return chans;
	}
}