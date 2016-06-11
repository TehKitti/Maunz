package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Enable implements ICommand<MessageEvent, PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.hasPermission(event.getUser()))
		{
			if (!Util.isEnabled)
			{
				Util.msg(event, "I have been enabled :D");
				Logger.log.info("Maunz is now enabled, messages will be parsed for commands and will no longer have a [DISABLED] prefix");
				Util.isEnabled = true;
			}
			else
			{
				Util.msg(event, "You silly, I was already enabled!");
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
			if (!Util.isEnabled)
			{
				Util.msg(event, "I have been enabled :D");
				Logger.log.info("Maunz is now enabled, messages will be parsed for commands and will no longer have a [DISABLED] prefix");
				Util.isEnabled = true;
			}
			else
			{
				Util.msg(event, "You silly, I was already enabled!");
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
		return new String[] { "*enable" };
	}
}