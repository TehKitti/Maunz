package com.vauff.maunz.features;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Grammar extends ListenerAdapter
{
	public void onMessage(MessageEvent event) throws Exception
	{
		try
		{
			if (Util.isEnabled == true && !event.getUser().getNick().startsWith("SCUser_"))
			{
				if (event.getMessage().toLowerCase().contains("should of"))
				{
					Util.msg(true, event, "It isn't \"should of\", it's \"should have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("shouldnt of"))
				{
					Util.msg(true, event, "It isn't \"shouldnt of\", it's \"shouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("shouldn't of"))
				{
					Util.msg(true, event, "It isn't \"shouldn't of\", it's \"shouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("could of"))
				{
					Util.msg(true, event, "It isn't \"could of\", it's \"could have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("couldnt of"))
				{
					Util.msg(true, event, "It isn't \"couldnt of\", it's \"couldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("couldn't of"))
				{
					Util.msg(true, event, "It isn't \"couldn't of\", it's \"couldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("would of"))
				{
					Util.msg(true, event, "It isn't \"would of\", it's \"would have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("wouldnt of"))
				{
					Util.msg(true, event, "It isn't \"wouldnt of\", it's \"wouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("wouldn't of"))
				{
					Util.msg(true, event, "It isn't \"wouldn't of\", it's \"wouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("must of"))
				{
					Util.msg(true, event, "It isn't \"must of \" it's \"must have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("mustnt of"))
				{
					Util.msg(true, event, "It isn't \"mustnt of \" it's \"mustn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("mustn't of"))
				{
					Util.msg(true, event, "It isn't \"mustn't of \" it's \"mustn't have\"!");
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}
