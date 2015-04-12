package com.vauff.maunz.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class UUID implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://api.fishbans.com/uuid/" + args[1]).openStream()));
			String rawdata = reader.readLine();
			String[] rawresponse = rawdata.split("\"");

			if(rawresponse[5].equals("User is not premium."))
				event.getChannel().send().message("Username is either an unpaid legacy account or a free username.");
			else
				event.getChannel().send().message("" + rawresponse[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://api.fishbans.com/uuid/" + args[1]).openStream()));
			String rawdata = reader.readLine();
			String[] rawresponse = rawdata.split("\"");

			if(rawresponse[5].equals("User is not premium."))
				event.getUser().send().message("Username is either an unpaid legacy account or a free username.");
			else
				event.getUser().send().message("" + rawresponse[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
		}
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[]{"*uuid"};
	}
}