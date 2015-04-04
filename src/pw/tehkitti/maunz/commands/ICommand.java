package pw.tehkitti.maunz.commands;

import org.pircbotx.hooks.Event;

public interface ICommand<M extends Event, P extends Event>
{
	public void exeChan(M event) throws Exception;
	
	public void exePrivate(P event) throws Exception;
	
	public String[] getAliases();
}