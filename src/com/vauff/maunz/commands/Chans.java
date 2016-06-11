package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
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
		Util.msg(event, "I am currently in the following channels: " + chans);
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
		Util.msg(event, "I am currently in the following channels: " + chans);
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*chans" };
	}
}