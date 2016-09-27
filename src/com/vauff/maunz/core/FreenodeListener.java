package com.vauff.maunz.core;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.NickAlreadyInUseEvent;
import org.pircbotx.hooks.events.QuitEvent;

import com.vauff.maunz.commands.Nick;

public class FreenodeListener extends ListenerAdapter
{
	public void onNickAlreadyInUse(NickAlreadyInUseEvent event)
	{
		try
		{
			if (event.getUsedNick().equals("Maunz") && Util.devMode == false)
			{
				Thread.sleep(5000);
				Main.freenodeBot.sendIRC().message("NickServ", "GHOST Maunz " + Passwords.freenodeNickServ);
				Main.freenodeBot.sendIRC().changeNick("Maunz");
				Main.freenodeBot.sendIRC().message("NickServ", "IDENTIFY " + Passwords.freenodeNickServ);
			}
			else
			{
				Nick.isNickUsed = true;
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onQuit(QuitEvent event)
	{
		if (event.getReason().equals("Disconnected by services") && event.getUser().getNick().equals(Main.freenodeBot.getNick()))
		{
			Util.isGhosted = true;
			Logger.log.info("Maunz is stopping...");
			Main.manager.stop("Stopping");
			System.exit(0);
		}
	}
}