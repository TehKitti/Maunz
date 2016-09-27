package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class BlogDebug implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if (Util.blogDebug)
		{
			Util.blogDebug = false;
			Util.msg(event, "Disabled the blog debug log messages.");
		}
		else
		{
			Util.blogDebug = true;
			Util.msg(event, "Enabled the blog debug log messages, please see the log file.");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if (Util.blogDebug)
		{
			Util.blogDebug = false;
			Util.msg(event, "Disabled the blog debug log messages.");
		}
		else
		{
			Util.blogDebug = true;
			Util.msg(event, "Enabled the blog debug log messages, please see the log file.");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*blogdebug" };
	}
}