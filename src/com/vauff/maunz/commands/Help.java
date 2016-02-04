package com.vauff.maunz.commands;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;

public class Help implements ICommand<MessageEvent<PircBotX>, PrivateMessageEvent<PircBotX>>
{

	@Override
	public void exeChan(MessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.getChannel().send().message("Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
			Logger.botMsg(event.getChannel().getName(), "Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
		}
		else
		{
			event.getChannel().send().message(cmdHelp(args));
			Logger.botMsg(event.getChannel().getName(), cmdHelp(args));
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent<PircBotX> event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
			Logger.botMsg(event.getUser().getNick(), "Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
		}
		else
		{
			event.respond(cmdHelp(args));
			Logger.botMsg(event.getUser().getNick(), cmdHelp(args));
		}
	}

	public String cmdHelp(String[] args)
	{
		switch (args[1].toLowerCase())
		{
		case "*about":
		case "about":
			return "Gives information about Maunz such as version and uptime. Usage: *about";
		case "*accinfo":
		case "accinfo":
			return "Gives you full information about any Minecraft account. Usage: *accinfo [username]";
		case "*bulliedme":
		case "bulliedme":
			return "Did somebody bully you? This will send them a link to stop with their bullying ways. Usage: *bulliedme [channel] <username>";
		case "*bullyme":
		case "bullyme":
			return "Do you want somebody to bully you? This will send them a link to start with their bullying ways. Usage: *bullyme [channel] <username>";
		case "*changelog":
		case "changelog":
			return "Tells you the changelog of the Maunz version you specify. Usage: *changelog [version]";
		case "*chans":
		case "chans":
			return "Lists the channels that Maunz is currently in. Usage: *chans";
		case "*disable":
		case "disable":
			return "Disables Maunz, only useable by Vauff. Usage: *disable";
		case "*enable":
		case "enable":
			return "Enables Maunz, only useable by Vauff. Usage: *enable";
		case "*help":
		case "help":
			return "Links you to the README or gives command help if a command is given. Please note that command specific help defaults to channel syntax by default. Usage: *help [command]";
		case "*join":
		case "join":
			return "Makes Maunz join a channel, only useable by Vauff. Usage: *join <channel>";
		case "*leave":
		case "leave":
			return "Makes Maunz leave a channel, only useable by Vauff. Usage: *leave [channel]";
		case "*nick":
		case "nick":
			return "Changes Maunz's nickname on a specific network, only useable by Vauff. Usage: *nick <network> <nickname>";
		case "*ping":
		case "ping":
			return "Makes Maunz respond to you with pong. Very useful for testing ping to the IRC server! Usage: *ping";
		case "*reddit":
		case "reddit":
			return "Links you to a subreddit that you provide. Usage: *reddit <subreddit>";
		case "*restart":
		case "restart":
			return "Restarts Maunz, only useable by Vauff. Usage: *restart";
		case "*say":
		case "say":
			return "Makes Maunz say whatever you want her to! Usage: *say [channel] <message>";
		case "*source":
		case "source":
			return "Links you to the GitHub page of Maunz, you can submit issues/pull requests here. Usage: *source";
		case "*steam":
		case "steam":
			return "Links you to a Steam profile based on a Steam ID. Usage: *steam <steamid>";
		case "*stop":
		case "stop":
			return "Stops Maunz, only useable by Vauff. Usage: *stop";
		case "*trello":
		case "trello":
			return "Links you to the Trello board of Maunz. Feature requests and bug reports can be made here. Usage: *trello";
		case "*update":
		case "update":
			return "This command automatically updates and restarts Maunz, only useable by Vauff. Usage: *update";
		case "*whosay":
		case "whosay":
			return "Tells you the last person who used the *say command. Usage: *whosay";
		default:
			return "I don't recognize the command " + args[1] + "!";
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*help" };
	}
}