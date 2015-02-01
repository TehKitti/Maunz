package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.core.Main;

public class Disable implements ICommand<MessageEvent,PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if(event.getUser().getNick().equals("TehKitti"))
		{
			if(Main.isEnabled)
			{
				event.respond("Maunz has successfully been disabled :(");
				Main.isEnabled = false;
			}
			else
				event.respond("You silly, I was already disabled!");
		}
		else
		{
			event.respond("I'm sorry but you do not have proper permissions to disable me!");
			event.getChannel().send().message("Now nobody can stop me from taking over the world! Mwahahahahaha!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if(event.getUser().getNick().equals("TehKitti"))
		{
			if(Main.isEnabled)
			{
				event.respond("Maunz has successfully been disabled :(");
				Main.isEnabled = false;
			}
			else
				event.respond("You silly, I was already disabled!");
		}
		else
		{
			event.respond("I'm sorry but you do not have proper permissions to disable me!");
			event.getUser().send().message("Now nobody can stop me from taking over the world! Mwahahahahaha!");
		}
	}

	@Override
	public String getAlias()
	{
		return "disable";
	}
}
