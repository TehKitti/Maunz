package pw.tehkitti.maunz.core;

import java.util.LinkedList;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import pw.tehkitti.maunz.commands.AccountInfo;
import pw.tehkitti.maunz.commands.BulliedMe;
import pw.tehkitti.maunz.commands.Disable;
import pw.tehkitti.maunz.commands.Enable;
import pw.tehkitti.maunz.commands.Help;
import pw.tehkitti.maunz.commands.ICommand;
import pw.tehkitti.maunz.commands.Ping;
import pw.tehkitti.maunz.commands.Restart;
import pw.tehkitti.maunz.commands.Say;
import pw.tehkitti.maunz.commands.Source;
import pw.tehkitti.maunz.commands.Stop;
import pw.tehkitti.maunz.commands.UUID;

public class Listener extends ListenerAdapter
{
	private String p = "*";
	private LinkedList<ICommand> commands = new LinkedList<ICommand>();

	public Listener()
	{
		commands.add(new AccountInfo());
		commands.add(new BulliedMe());
		commands.add(new Enable());
		commands.add(new Disable());
		commands.add(new Help());
		commands.add(new Ping());
		commands.add(new Restart());
		commands.add(new Say());
		commands.add(new Source());
		commands.add(new Stop());
		commands.add(new UUID());
	}

	@Override
	public void onMessage(MessageEvent event) throws Exception
	{
		String cmdName = event.getMessage().split(" ")[0];

		if(!cmdName.startsWith(p))
			return;

		if(Main.isEnabled)
		{
			for(ICommand cmd : commands)
			{
				if(cmdName.equalsIgnoreCase(p + cmd.getAlias()))
				{
					cmd.exeChan(event);
					return;
				}
			}
		}
		else
		{
			for(ICommand cmd : commands)
			{
				if((cmd instanceof Enable || cmd instanceof Disable) && event.getMessage().equalsIgnoreCase(p + cmd.getAlias()))
				{
					cmd.exeChan(event);
					return;
				}
			}
		}
	}

	@Override
	public void onPrivateMessage(PrivateMessageEvent event) throws Exception
	{
		String cmdName = event.getMessage().split(" ")[0];

		if(!cmdName.startsWith(p))
			return;

		if(Main.isEnabled)
		{
			for(ICommand cmd : commands)
			{
				if(cmdName.equalsIgnoreCase(p + cmd.getAlias()))
				{
					cmd.exePrivate(event);
					return;
				}
			}
		}
		else
		{
			for(ICommand cmd : commands)
			{
				if((cmd instanceof Enable || cmd instanceof Disable) && event.getMessage().equalsIgnoreCase(p + cmd.getAlias()))
				{
					cmd.exePrivate(event);
					return;
				}
			}
		}
	}
}
