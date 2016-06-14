package com.vauff.maunz.features;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.pircbotx.Colors;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class GFLTimer
{
	private static String lastMap = "";

	public static Runnable timer = new Runnable()
	{
		public void run()
		{
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(new URL("http://api.gametracker.rs/demo/xml/server_info/216.52.148.47:27015/").openStream());
				Element root = doc.getDocumentElement();
				String map = root.getElementsByTagName("map").item(0).getTextContent();

				if (!lastMap.equals(map) && !map.equals("") && Util.isEnabled)
				{
					Util.msg(Util.privateChannel, "GFL Zombie Escape is now playing: " + Colors.MAGENTA + Colors.BOLD + map);
					lastMap = map;
				}
			}
			catch (Exception e)
			{
				Logger.log.error("", e);
			}
		}
	};
}