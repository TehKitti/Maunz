package com.vauff.maunz.core;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.Event;

public interface ICommand<M extends Event<PircBotX>, P extends Event<PircBotX>>
{
	public void exeChan(M event) throws Exception;

	public void exePrivate(P event) throws Exception;

	public String[] getAliases();
}