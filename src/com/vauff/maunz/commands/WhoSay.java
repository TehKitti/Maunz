package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class WhoSay implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if(!Say.whosay.equals(""))
			event.getChannel().send().message("The last person who used my *say command was " + Say.whosay);
		else
		{
			event.getChannel().send().message("Nobody has used my *say command since I last started");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if(!Say.whosay.equals(""))
			event.respond("The last person who used my *say command was " + Say.whosay);
		else
		{
			event.respond("Nobody has used my *say command since I last started");
		}
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*whosay"};
	}
}