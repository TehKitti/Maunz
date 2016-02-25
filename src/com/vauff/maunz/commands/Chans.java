package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Chans implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String chans = "";

		for (String rawchan : Util.getJoinedChannels())
		{
			chans += (rawchan + " | ");
		}
		
		chans = chans.substring(0, chans.lastIndexOf(" | "));
		event.respondChannel("I am currently in the following channels: " + chans);
		Logger.botMsg(event.getChannel().getName(), "I am currently in the following channels: " + chans);
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String chans = "";

		for (String rawchan : Util.getJoinedChannels())
		{
			chans += (rawchan + " | ");
		}
		
		chans = chans.substring(0, chans.lastIndexOf(" | "));
		event.respond("I am currently in the following channels: " + chans);
		Logger.botMsg(event.getUser().getNick(), "I am currently in the following channels: " + chans);
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*chans" };
	}
}