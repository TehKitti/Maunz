package com.vauff.maunz.core;

import org.apache.commons.lang3.StringUtils;

import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.KickEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.ModeEvent;
import org.pircbotx.hooks.events.NickChangeEvent;
import org.pircbotx.hooks.events.NoticeEvent;
import org.pircbotx.hooks.events.PartEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.events.QuitEvent;
import org.pircbotx.hooks.events.ServerPingEvent;

public class Logger extends ListenerAdapter
{
	public static org.apache.logging.log4j.Logger log;

	public static void botMsg(String buffer, String msg)
	{
		try
		{
			Thread.sleep(100);

			if (Util.isEnabled)
			{
				log.info(buffer + " | " + Main.esperBot.getNick() + " | " + Colors.removeFormatting(Colors.removeColors(msg)));
			}
			else
			{
				log.info("[DISABLED] " + buffer + " | " + Main.esperBot.getNick() + " | " + Colors.removeFormatting(Colors.removeColors(msg)));
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onMessage(MessageEvent event)
	{
		try
		{
			if (!event.getUser().getNick().equals("SteamDB"))
			{
				if (Util.isEnabled)
				{
					log.info(event.getChannel().getName() + " | " + event.getUser().getNick() + " | " + Colors.removeFormatting(Colors.removeColors(event.getMessage())));
				}
				else
				{
					log.info("[DISABLED] " + event.getChannel().getName() + " | " + event.getUser().getNick() + " | " + Colors.removeFormatting(Colors.removeColors(event.getMessage())));
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event)
	{
		try
		{
			if (Util.isEnabled)
			{
				log.info(event.getUser().getNick() + " | " + event.getUser().getNick() + " | " + Colors.removeFormatting(Colors.removeColors(event.getMessage())));
			}
			else
			{
				log.info("[DISABLED] " + event.getUser().getNick() + " | " + event.getUser().getNick() + " | " + Colors.removeFormatting(Colors.removeColors(event.getMessage())));
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onServerPing(ServerPingEvent event)
	{
		try
		{
			if (!event.getBot().getServerInfo().getServerName().equals(null))
			{
				log.info("Ping from " + event.getBot().getServerInfo().getServerName());
			}
		}
		catch (NullPointerException e)
		{
			// do nothing because im expecting this every startup
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onQuit(QuitEvent event)
	{
		try
		{
			if (!event.getUser().getNick().equals(Main.esperBot.getNick()) && !event.getUser().getNick().equals(Main.freenodeBot.getNick()))
			{
				if (event.getReason().equals(""))
				{
					log.info(event.getUser().getNick() + " just quit " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
				}
				else
				{
					log.info(event.getUser().getNick() + " just quit " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + " with the reason \"" + Colors.removeFormatting(Colors.removeColors(event.getReason())) + "\"");
				}
			}
			if (event.getUser().getNick().equals(Main.esperBot.getNick()) || event.getUser().getNick().equals(Main.freenodeBot.getNick()))
			{
				if (event.getReason().equals(""))
				{
					log.info("Quit " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
				}
				else
				{
					log.info("Quit " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + " with the reason \"" + Colors.removeFormatting(Colors.removeColors(event.getReason())) + "\"");
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onPart(PartEvent event)
	{
		try
		{
			if (!event.getUser().getNick().equals(Main.esperBot.getNick()) && !event.getUser().getNick().equals(Main.freenodeBot.getNick()))
			{
				if (event.getReason().equals(""))
				{
					log.info(event.getUser().getNick() + " just left " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
				}
				else
				{
					log.info(event.getUser().getNick() + " just left " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + " with the reason \"" + Colors.removeFormatting(Colors.removeColors(event.getReason())) + "\"");
				}
			}

			if (event.getUser().getNick().equals(Main.esperBot.getNick()) || event.getUser().getNick().equals(Main.freenodeBot.getNick()))
			{
				if (event.getReason().equals(""))
				{
					log.info("Left " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
				}
				else
				{
					log.info("Left " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + " with the reason \"" + Colors.removeFormatting(Colors.removeColors(event.getReason())) + "\"");
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onJoin(JoinEvent event) throws InterruptedException
	{
		try
		{
			if (!event.getUser().getNick().equals(Main.esperBot.getNick()) && !event.getUser().getNick().equals(Main.freenodeBot.getNick()))
			{
				log.info(event.getUser().getNick() + " just joined " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
			}

			if (event.getUser().getNick().equals(Main.esperBot.getNick()) || event.getUser().getNick().equals(Main.freenodeBot.getNick()))
			{
				log.info("Joined " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onNickChange(NickChangeEvent event)
	{
		try
		{
			log.info(event.getOldNick() + " just changed their nick to " + event.getNewNick() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onAction(ActionEvent event)
	{
		try
		{
			log.info(event.getChannel().getName() + " | -*- " + event.getUser().getNick() + " " + Colors.removeFormatting(Colors.removeColors(event.getMessage())));
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onNotice(NoticeEvent event)
	{
		try
		{
			if (!event.getUser().getNick().contains(".esper.net") && !event.getUser().getNick().contains(".freenode.net"))
			{
				log.info("[" + event.getUser().getNick() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + "] " + Colors.removeFormatting(Colors.removeColors(event.getMessage())));
			}
		}
		catch (NullPointerException e)
		{
			// do nothing because im expecting this every startup
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onMode(ModeEvent event)
	{
		try
		{
			log.info(event.getUser().getNick() + " sets mode " + event.getMode() + " on " + event.getChannel().getName() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));

		}
		catch (NullPointerException e)
		{
			log.info(event.getChannel().getName() + " has mode " + event.getMode() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}

	public void onKick(KickEvent event)
	{
		try
		{
			if (!event.getRecipient().getNick().equals(Main.esperBot.getNick()) && !event.getRecipient().getNick().equals(Main.freenodeBot.getNick()))
			{
				if (event.getReason().equals(""))
				{
					log.info(event.getRecipient().getNick() + " was kicked from " + event.getChannel().getName() + " by " + event.getUser().getNick() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
				}
				else
				{
					log.info(event.getRecipient().getNick() + " was kicked from " + event.getChannel().getName() + " by " + event.getUser().getNick() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + " with the reason \"" + Colors.removeFormatting(Colors.removeColors(event.getReason())) + "\"");
				}
			}

			if (event.getRecipient().getNick().equals(Main.esperBot.getNick()) || event.getRecipient().getNick().equals(Main.freenodeBot.getNick()))
			{
				if (event.getReason().equals(""))
				{
					log.info("Kicked from " + event.getChannel().getName() + " by " + event.getUser().getNick() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]));
				}
				else
				{
					log.info("Kicked from " + event.getChannel().getName() + " by " + event.getUser().getNick() + " on " + StringUtils.capitalize(event.getBot().getServerInfo().getServerName().split("\\.")[1]) + " with the reason \"" + Colors.removeFormatting(Colors.removeColors(event.getReason())) + "\"");
				}
			}
		}
		catch (Exception e)
		{
			Logger.log.error("", e);
		}
	}
}
