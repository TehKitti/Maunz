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
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"should of\" to \"should have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"should of\", it's \"should have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("shouldnt of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"shouldnt of\" to \"shouldn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"shouldnt of\", it's \"shouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("shouldn't of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"shouldn't of\" to \"shouldn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"shouldn't of\", it's \"shouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("could of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"could of\" to \"could have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"could of\", it's \"could have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("couldnt of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"couldnt of\" to \"couldn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"couldnt of\", it's \"couldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("couldn't of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"couldn't of\" to \"couldn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"couldn't of\", it's \"couldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("would of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"would of\" to \"would have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"would of\", it's \"would have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("wouldnt of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"wouldnt of\" to \"wouldn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"wouldnt of\", it's \"wouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("wouldn't of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"wouldn't of\" to \"wouldn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"wouldn't of\", it's \"wouldn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("must of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"must of\" to \"must have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"must of \" it's \"must have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("mustnt of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"mustnt of\" to \"mustn't have\" from the message \"" + event.getMessage() + "\"");
					Util.msg(true, event, "It isn't \"mustnt of \" it's \"mustn't have\"!");
				}

				else if (event.getMessage().toLowerCase().contains("mustn't of"))
				{
					Logger.log.info("Corrected " + event.getUser().getNick() + "'s spelling of \"mustn't of\" to \"mustn't have\" from the message \"" + event.getMessage() + "\"");
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
