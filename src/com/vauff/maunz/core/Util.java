package com.vauff.maunz.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class Util 
{
	public static boolean isEnabled = true;
	
	public static String getJarLocation() 
	{
		try 
		{
			String path = Main.class.getProtectionDomain().getCodeSource()
					.getLocation().toURI().getPath();

			if (path.endsWith(".jar"))
				path = path.substring(0, path.lastIndexOf("/"));
			if(!path.endsWith("/"))
                path += "/";
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

		if(!file.exists())
		{
			file.createNewFile();
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String[] result = reader.readLine().split(",");
		reader.close();
		return Arrays.asList(result);
	}
}