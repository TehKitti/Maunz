package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.core.Listener;
import pw.tehkitti.maunz.core.Main;

public class Join implements ICommand<MessageEvent, PrivateMessageEvent> 
{
	@Override
	public void exeChan(MessageEvent event) throws Exception 
	{
		if (event.getUser().getNick().equals("TehKitti")) 
		{
			String[] args = event.getMessage().split(" ");
			if (args[1].startsWith("#")) 
			{
				if (Listener.channels.contains(args[1])) 
				{
					event.getChannel().send().message("I am already in " + args[1] + "!");
				}
				if (!Listener.channels.contains(args[1]))
				{
					Main.bot.sendIRC().joinChannel(args[1]);
					event.getChannel().send().message("I will join "+ args[1] + "!");
					Listener.channels.add(args[1]);
				}
			}
			if (!args[1].startsWith("#")) 
			{
				event.getChannel().send().message("Channel name must start with a #");
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception 
	{
		if (event.getUser().getNick().equals("TehKitti")) 
		{
			String[] args = event.getMessage().split(" ");
			if (args[1].startsWith("#")) 
			{
				if (Listener.channels.contains(args[1])) 
				{
					event.respond("I am already in " + args[1] + "!");
				}
				if (!Listener.channels.contains(args[1]))
				{
					Main.bot.sendIRC().joinChannel(args[1]);
					event.respond("I will join "+ args[1] + "!");
					Listener.channels.add(args[1]);
				}
			}
			if (!args[1].startsWith("#")) 
			{
				event.respond("Channel name must start with a #");
			}
		}
	}

	@Override
	public String getAlias() 
	{
		return "join";
	}
}