package com.vauff.maunz.features;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.QuitEvent;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class TaskController extends ListenerAdapter
{
	public void onJoin(JoinEvent event)
	{
		try
		{
			if (event.getUser().getNick().startsWith("TaskController_"))
			{
				Util.msg(Util.privateChannel, event.getUser().getNick().split("_")[1] + " just logged on!");
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
	
	public void onQuit(QuitEvent event)
	{
		try
		{
			if (event.getUser().getNick().startsWith("TaskController_"))
			{
				Util.msg(Util.privateChannel, "Vauff: " + event.getUser().getNick().split("_")[1] + " just logged off!");
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}
