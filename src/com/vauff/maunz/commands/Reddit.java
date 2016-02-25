package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Reddit implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respondChannel("You need to provide a subreddit!");
		}
		else
		{
			if (args[1].startsWith("/r/"))
			{
				String[] splitArgs = args[1].split("/");
				event.respondChannel("https://www.reddit.com/r/" + splitArgs[2] + "/");
				Logger.botMsg(event.getChannel().getName(), "https://www.reddit.com/r/" + splitArgs[2] + "/");
			}
			else if (args[1].startsWith("r/"))
			{
				String[] splitArgs = args[1].split("/");
				event.respondChannel("https://www.reddit.com/r/" + splitArgs[1] + "/");
				Logger.botMsg(event.getChannel().getName(), "https://www.reddit.com/r/" + splitArgs[1] + "/");
			}
			else
			{
				event.respondChannel("https://www.reddit.com/r/" + args[1] + "/");
				Logger.botMsg(event.getChannel().getName(), "https://www.reddit.com/r/" + args[1] + "/");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("You need to provide a subreddit!");
		}
		else
		{
			if (args[1].startsWith("/r/"))
			{
				String[] splitArgs = args[1].split("/");
				event.respond("https://www.reddit.com/r/" + splitArgs[2] + "/");
				Logger.botMsg(event.getUser().getNick(), "https://www.reddit.com/r/" + splitArgs[2] + "/");
			}
			else if (args[1].startsWith("r/"))
			{
				String[] splitArgs = args[1].split("/");
				event.respond("https://www.reddit.com/r/" + splitArgs[1] + "/");
				Logger.botMsg(event.getUser().getNick(), "https://www.reddit.com/r/" + splitArgs[1] + "/");
			}
			else
			{
				event.respond("https://www.reddit.com/r/" + args[1] + "/");
				Logger.botMsg(event.getUser().getNick(), "https://www.reddit.com/r/" + args[1] + "/");
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*reddit" };
	}
}