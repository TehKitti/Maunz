package com.vauff.maunz.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Util 
{
	public static boolean isEnabled = true;
	
	public static List<String> getFileContents() throws IOException
	{
		String path = Util.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		File file = new File(path.substring(0, path.length() - "Maunz.jar".length()) + "chans.txt");
		
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