package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Reddit implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "You need to provide a subreddit!");
		}
		else
		{
			if (args[1].startsWith("/r/"))
			{
				String[] splitArgs = args[1].split("/");
				Util.msg(event, "https://www.reddit.com/r/" + splitArgs[2] + "/");
			}
			else if (args[1].startsWith("r/"))
			{
				String[] splitArgs = args[1].split("/");
				Util.msg(event, "https://www.reddit.com/r/" + splitArgs[1] + "/");
			}
			else
			{
				Util.msg(event, "https://www.reddit.com/r/" + args[1] + "/");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "You need to provide a subreddit!");
		}
		else
		{
			if (args[1].startsWith("/r/"))
			{
				String[] splitArgs = args[1].split("/");
				Util.msg(event, "https://www.reddit.com/r/" + splitArgs[2] + "/");
			}
			else if (args[1].startsWith("r/"))
			{
				String[] splitArgs = args[1].split("/");
				Util.msg(event, "https://www.reddit.com/r/" + splitArgs[1] + "/");
			}
			else
			{
				Util.msg(event, "https://www.reddit.com/r/" + args[1] + "/");
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*reddit" };
	}
}