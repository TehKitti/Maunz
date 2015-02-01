package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.core.Main;

public class BulliedMe implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
			event.respond("Nobody bullied you? Okay then.");
		else
			event.getChannel().send().message(args[1] + ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
			event.respond("Nobody bullied you? Okay then.");
		else
			Main.bot.sendIRC().message(args[1], "Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
	}
	
	@Override
	public String getAlias()
	{
		return "bulliedme";
	}
}