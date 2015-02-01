package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Help implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		event.respond("Help documents are located at http://tehkitti.pw/maunz.html");
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		event.respond("Help documents are located at http://tehkitti.pw/maunz.html");
	}
	
	@Override
	public String getAlias()
	{
		return "help";
	}
}