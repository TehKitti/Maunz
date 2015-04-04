package pw.tehkitti.maunz.core;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.commands.ICommand;

import com.google.code.chatterbotapi.ChatterBotSession;

public class Intelligence implements ICommand<MessageEvent,PrivateMessageEvent>
{
	private static boolean alreadyStartedSession = false;
	
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] message = event.getMessage().split(" ");
		ChatterBotSession chatSession;
		CleverbotSession session = null;
		
		if(!alreadyStartedSession)
		{
			session = new CleverbotSession();
			alreadyStartedSession = true;
		}
		else
			session = CleverbotSession.getInstance();
		
		chatSession = session.getSession();
		event.respond("I am sending \"" + addArgs(message, 1) + "\" to Cleverbot!");
		event.respond(chatSession.think(addArgs(message, 1)));
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] message = event.getMessage().split(" ");
		ChatterBotSession chatSession;
		CleverbotSession session = null;
		
		if(!alreadyStartedSession)
		{
			session = new CleverbotSession();
			alreadyStartedSession = true;
		}
		else
			session = CleverbotSession.getInstance();
		
		chatSession = session.getSession();
		event.respond("I am sending \"" + addArgs(message, 1) + "\" to Cleverbot!");
		event.respond(chatSession.think(addArgs(message, 1)));
	}

	private String addArgs(String[] args, int startIndex)
	{
		String s = "";

		for(int i = startIndex; i < args.length; i++)
		{
			s += args[i] + " ";
		}

		return s.substring(0, s.lastIndexOf(" "));
	}

	@Override
	public String[] getAliases()
	{
		return new String[]{"Maunz:", "Maunz,"};
	}
}