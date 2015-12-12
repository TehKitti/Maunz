package com.vauff.maunz.features;

import java.util.Arrays;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Util;

public class Grammar extends ListenerAdapter<PircBotX>
{
	public void onMessage(MessageEvent<PircBotX> event) throws Exception
	{
		if (Util.isEnabled == true && !event.getUser().getNick().startsWith("SCUser_"))
		{
			if (event.getMessage().toLowerCase().contains("should of"))
			{
				event.respond("It isn't \"should of\", it's \"should have\"!");
			}
			
			else if (event.getMessage().toLowerCase().contains("shouldnt of"))
			{
				event.respond("It isn't \"shouldnt of\", it's \"shouldn't have\"!");
			}
			
			else if (event.getMessage().toLowerCase().contains("shouldn't of"))
			{
				event.respond("It isn't \"shouldn't of\", it's \"shouldn't have\"!");
			}

			else if (event.getMessage().toLowerCase().contains("could of"))
			{
				event.respond("It isn't \"could of\", it's \"could have\"!");
			}
			
			else if (event.getMessage().toLowerCase().contains("couldnt of"))
			{
				event.respond("It isn't \"couldnt of\", it's \"couldn't have\"!");
			}
			
			else if (event.getMessage().toLowerCase().contains("couldn't of"))
			{
				event.respond("It isn't \"couldn't of\", it's \"couldn't have\"!");
			}

			else if (event.getMessage().toLowerCase().contains("would of"))
			{
				event.respond("It isn't \"would of\", it's \"would have\"!");
			}
			
			else if (event.getMessage().toLowerCase().contains("wouldnt of"))
			{
				event.respond("It isn't \"wouldnt of\", it's \"wouldn't have\"!");
			}
			
			else if (event.getMessage().toLowerCase().contains("wouldn't of"))
			{
				event.respond("It isn't \"wouldn't of\", it's \"wouldn't have\"!");
			}

			else if (Arrays.asList(event.getMessage().split(" ")).contains("y"))
			{
				event.respond("It isn't \"y\", it's \"why\"!");
			}

			else if (Arrays.asList(event.getMessage().split(" ")).contains("u"))
			{
				event.respond("It isn't \"u\", it's \"you\"!");
			}

		}
	}
}
