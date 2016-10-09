package com.vauff.maunz.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Help implements ICommand<MessageEvent, PrivateMessageEvent>
{

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
		}
		else
		{
			Util.msg(event, cmdHelp(args));
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "Help documents are located at https://github.com/Vauff/Maunz/blob/master/README.md");
		}
		else
		{
			Util.msg(event, cmdHelp(args));
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
		case "*benchmark":
		case "benchmark":
			return "Provides complete benchmark information on a GPU or CPU powered by PassMark. Usage: *benchmark <gpu/cpu>";
		case "*blogdebug":
		case "blogdebug":
			return "Enables blog timer debug output in the log to try and track a bug, only usable by Vauff. Usage: *blogdebug";
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
			return "Disables Maunz, only usable by Vauff. Usage: *disable";
		case "*enable":
		case "enable":
			return "Enables Maunz, only usable by Vauff. Usage: *enable";
		case "*help":
		case "help":
			return "Links you to the README or gives command help if a command is given. Please note that command specific help defaults to channel syntax by default. Usage: *help [command]";
		case "*join":
		case "join":
			return "Makes Maunz join a channel, only usable by Vauff. Usage: *join <channel>";
		case "*leave":
		case "leave":
			return "Makes Maunz leave a channel, only usable by Vauff. Usage: *leave [channel]";
		case "*map":
		case "map":
			return "Tells you which map GFL ZE is playing outside of the normal #TaskController channel. Usage: *map";
		case "*nick":
		case "nick":
			return "Changes Maunz's nickname on a specific network, only usable by Vauff. Usage: *nick <network> <nickname>";
		case "*ping":
		case "ping":
			return "Makes Maunz respond to you with pong. Very useful for testing ping to the IRC server! Usage: *ping";
		case "*quote":
		case "quote":
			return "Allows you to view IRC quotes. Usage: *quote <view/list/add> <quoteid> [page]";
		case "*reddit":
		case "reddit":
			return "Links you to a subreddit that you provide. Usage: *reddit <subreddit>";
		case "*reset":
		case "reset":
			return "Resets the Cleverbot session in the channel sent in. Usage: *reset";
		case "*restart":
		case "restart":
			return "Restarts Maunz, only usable by Vauff. Usage: *restart";
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
			return "Stops Maunz, only usable by Vauff. Usage: *stop";
		case "*trello":
		case "trello":
			return "Links you to the Trello board of Maunz. Feature requests and bug reports can be made here. Usage: *trello";
		case "*update":
		case "update":
			return "This command automatically updates and restarts Maunz, only usable by Vauff. Usage: *update";
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