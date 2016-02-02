package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Reddit implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.getChannel().send().message("You need to provide a subreddit!");
		}
		else
		{
			if (args[1].startsWith("/r/"))
			{
				String[] splitArgs = args[1].split("/");
				event.getChannel().send().message("https://www.reddit.com/r/" + splitArgs[2] + "/");
				Logger.botMsg(event.getChannel().getName(), "https://www.reddit.com/r/" + splitArgs[2] + "/");
			}
			else if (args[1].startsWith("r/"))
			{
				String[] splitArgs = args[1].split("/");
				event.getChannel().send().message("https://www.reddit.com/r/" + splitArgs[1] + "/");
				Logger.botMsg(event.getChannel().getName(), "https://www.reddit.com/r/" + splitArgs[1] + "/");
			}
			else
			{
				event.getChannel().send().message("https://www.reddit.com/r/" + args[1] + "/");
				Logger.botMsg(event.getChannel().getName(), "https://www.reddit.com/r/" + args[1] + "/");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
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