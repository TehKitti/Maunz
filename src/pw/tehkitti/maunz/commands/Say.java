package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.core.Main;

@SuppressWarnings("rawtypes")
public class Say implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		event.getChannel().send().message(args[1]);
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		Main.bot.sendIRC().message("#bl4ckscor3", args[1]);
	}
	
	@Override
	public String getAlias()
	{
		return "say";
	}
}