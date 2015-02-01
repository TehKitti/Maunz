package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.core.Main;

public class Enable implements ICommand<MessageEvent,PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		if(event.getUser().getNick().equals("TehKitti"))
		{
			if(!Main.isEnabled)
			{
				event.respond("Maunz has successfully been enabled!");
				Main.isEnabled = true;
			}
			else
				event.respond("You silly, I was already enabled!");
		}
		else
		{
			event.respond("I'm sorry but you do not have proper permissions to enable me!");
			event.getChannel().send().message("I was hoping I could begin to take over the world here, guess I'll have to wait for TehKitti!");
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		if(event.getUser().getNick().equals("TehKitti"))
		{
			if(!Main.isEnabled)
			{
				event.respond("Maunz has successfully been enabled!");
				Main.isEnabled = true;
			}
			else
				event.respond("You silly, I was already enabled!");
		}
		else
		{
			event.respond("I'm sorry but you do not have proper permissions to enable me!");
			event.getUser().send().message("I was hoping I could begin to take over the world here, guess I'll have to wait for TehKitti!");
		}
	}

	@Override
	public String getAlias()
	{
		return "enable";
	}
}
