package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Chans implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{
	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String chans = "";

		for (String rawchan : Util.getJoinedChannels())
		{
			chans += (rawchan + " | ");
		}
		
		chans = chans.substring(0, chans.lastIndexOf(" | "));
		event.getChannel().send().message("I am currently in the following channels: " + chans);
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String chans = "";

		for (String rawchan : Util.getJoinedChannels())
		{
			chans += (rawchan + " | ");
		}
		
		chans = chans.substring(0, chans.lastIndexOf(" | "));
		event.respond("I am currently in the following channels: " + chans);
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*chans" };
	}
}