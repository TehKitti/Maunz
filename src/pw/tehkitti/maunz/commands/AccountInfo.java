package pw.tehkitti.maunz.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class AccountInfo implements ICommand<MessageEvent,PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accstatus?username=" + args[1] + "&format=plain").openStream()));
			String status = reader.readLine();

			if(status.equalsIgnoreCase("FREE"))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " is free and does not belong to any account!");
			else if(status.equalsIgnoreCase("REGISTERED"))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " belongs to an unpaid legacy account.");
			else if(status.equalsIgnoreCase("PREMIUM"))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " belongs to a paid account.");
			else if(status.equalsIgnoreCase("Username must be 16 characters or less."))
				event.getChannel().send().message("The Minecraft account name " + args[1] + " must be 16 characters or less.");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
		}
	}
	
	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		try
		{
			String[] args = event.getMessage().split(" ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accstatus?username=" + args[1] + "&format=plain").openStream()));
			String status = reader.readLine();

			if(status.equalsIgnoreCase("FREE"))
				event.getUser().send().message("The Minecraft account name " + args[1] + " is free and does not belong to any account!");
			else if(status.equalsIgnoreCase("REGISTERED"))
				event.getUser().send().message("The Minecraft account name " + args[1] + " belongs to an unpaid legacy account.");
			else if(status.equalsIgnoreCase("PREMIUM"))
				event.getUser().send().message("The Minecraft account name " + args[1] + " belongs to a paid account.");
			else if(status.equalsIgnoreCase("Username must be 16 characters or less."))
				event.getUser().send().message("The Minecraft account name " + args[1] + " must be 16 characters or less.");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			event.respond("Provide a username for me please!");
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[]{"*accinfo"};
	}
}