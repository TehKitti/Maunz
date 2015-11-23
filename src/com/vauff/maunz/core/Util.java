package com.vauff.maunz.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Util
{
	public static boolean isEnabled = true;

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

	public static Thread getThreadByName(String threadname)
	{
		for (Thread t : Thread.getAllStackTraces().keySet())
		{
			if (t.getName().equals(threadname))
			{
				return t;
			}
		}

		return null;
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
}