package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Help implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respond("Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*help"};
	}
}