package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Source implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan	(MessageEvent event) throws Exception
	{
		event.respond("https://github.com/TehKitti/Maunz");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("https://github.com/TehKitti/Maunz");
	}

	@Override
	public String getAlias()
	{
		return "source";
	}
}