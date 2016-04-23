package com.vauff.maunz.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.pircbotx.Channel;

import com.google.common.collect.ImmutableSortedSet;

public class Util
{
	public static boolean isEnabled = true;
	public static Connection sqlCon;
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
		return getTime(System.currentTimeMillis());
	}

	public static String getTime(long time)
	{
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM d'" + getOrdinal(date.getDate()) + "', yyyy, h:mm a z");

		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(date);
	}

	public static String getUptime()
	{
		EsperListener.uptime.split();

		String[] uptimeraw = EsperListener.uptime.toSplitString().split("\\.");
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

	public static String getOrdinal(int n)
	{
		if (n >= 11 && n <= 13)
		{
			return "th";
		}
		else
		{
			switch (n % 10)
			{
			case 1:
				return "st";
			case 2:
				return "nd";
			case 3:
				return "rd";
			default:
				return "th";
			}
		}
	}

	public static void sqlConnect() throws Exception
	{
		try
		{
			sqlCon = DriverManager.getConnection("jdbc:mysql://geforcemods.net:3306/ircquotes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "Vauff", Passwords.database);
		}
		catch (SQLException e)
		{
			Logger.log.error(e.getMessage(), e);
		}
	}
}