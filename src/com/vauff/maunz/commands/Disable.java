package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Disable implements ICommand<MessageEvent, PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			if (Util.isEnabled)
			{
				Util.msg(event, "I have been disabled :(");
				Logger.log.info("Maunz is now disabled, messages messages will no longer be parsed for commands and will show in the log with a [DISABLED] prefix");
				Util.isEnabled = false;
			}
			else
			{
				Util.msg(event, "You silly, I was already disabled!");
			}
		}
		else
		{
			Util.msg(event, "You do not have permission to use that command");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			if (Util.isEnabled)
			{
				Util.msg(event, "I have been disabled :(");
				Logger.log.info("Maunz is now disabled, messages received while disabled will show in the log with a [DISABLED] prefix");
				Util.isEnabled = false;
			}
			else
			{
				Util.msg(event, "You silly, I was already disabled!");
			}
		}
		else
		{
			Util.msg(event, "You do not have permission to use that command");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*disable" };
	}
}