package com.vauff.maunz.core;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.NickAlreadyInUseEvent;

import com.vauff.maunz.commands.Nick;

public class FreenodeListener extends ListenerAdapter
{
	public void onNickAlreadyInUse(NickAlreadyInUseEvent event)
	{
		try
		{
			Nick.isNickUsed = true;
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}
