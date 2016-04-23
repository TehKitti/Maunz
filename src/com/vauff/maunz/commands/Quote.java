package com.vauff.maunz.commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.math.NumberUtils;

import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Logger;
import com.vauff.maunz.core.Util;

public class Quote implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respondChannel("You can view the quotes site here: http://geforcemods.net/quotes/");
			Logger.botMsg(event.getChannel().getName(), "You can view the quotes site here: http://geforcemods.net/quotes/");
		}
		else
		{
			switch (args[1].toLowerCase())
			{
			case "list":
				if (args.length == 2 || NumberUtils.isNumber(args[2]))
				{
					int page = 0;

					if (args.length == 2)
					{
						page = 1;
					}
					else
					{
						page = Integer.parseInt(args[2]);
					}

					int secondQuoteID = 10 * page;
					int firstQuoteID = secondQuoteID + 1 - 10;

					Util.sqlConnect();

					PreparedStatement pst = Util.sqlCon.prepareStatement("SELECT * FROM quotes WHERE id>=" + firstQuoteID + " AND id<=" + secondQuoteID + ";");
					ResultSet rs = pst.executeQuery();
					PreparedStatement secondPst = Util.sqlCon.prepareStatement("SELECT COUNT(id) AS id FROM quotes;");
					ResultSet secondRs = secondPst.executeQuery();

					secondRs.next();

					if (page >= 1 && page <= (int) Math.ceil(secondRs.getDouble("id") / 10))
					{
						event.respondChannel("--- " + Colors.BOLD + "Page " + page + "/" + (int) Math.ceil(secondRs.getDouble("id") / 10) + Colors.NORMAL + " ---");
						Logger.botMsg(event.getChannel().getName(), "--- " + Colors.BOLD + "Page " + page + "/" + Math.ceil(secondRs.getDouble("id") / 10) + Colors.NORMAL + " ---");

						while (rs.next())
						{
							if (rs.getInt("approved") == 1)
							{
								event.respondChannel(rs.getInt("id") + " - " + rs.getString("title"));
								Logger.botMsg(event.getChannel().getName(), rs.getInt("id") + " - " + rs.getString("title"));
							}
						}
					}
					else
					{
						event.respondChannel("That page doesn't exist!");
						Logger.botMsg(event.getChannel().getName(), "That page doesn't exist!");
					}

					Util.sqlCon.abort(null);
				}
				else
				{
					event.respondChannel("Page numbers need to be numerical!");
					Logger.botMsg(event.getChannel().getName(), "Page numbers need to be numerical!");
				}

				break;
			case "view":
				if (args.length == 2)
				{
					event.respondChannel("You need to give me a quote ID!");
					Logger.botMsg(event.getChannel().getName(), "You need to give me a quote ID!");
				}
				else
				{
					if (NumberUtils.isNumber(args[2]))
					{
						Util.sqlConnect();
						PreparedStatement pst = Util.sqlCon.prepareStatement("SELECT * FROM quotes WHERE id='" + args[2] + "'");
						ResultSet rs = pst.executeQuery();

						if (!rs.next())
						{
							event.respondChannel("That quote doesn't exist!");
							Logger.botMsg(event.getChannel().getName(), "That quote doesn't exist!");
						}
						else
						{
							if (rs.getInt("approved") == 1)
							{
								int lines = 0;

								event.respondChannel(Colors.NORMAL + Colors.BOLD + "ID: " + Colors.NORMAL + rs.getString("id") + " - " + Colors.BOLD + "Title: " + Colors.NORMAL + rs.getString("title") + " - " + Colors.BOLD + "Submitter: " + Colors.NORMAL + rs.getString("submitter") + " - " + Colors.BOLD + "Date: " + Colors.NORMAL + Util.getTime(rs.getLong("time") * 1000));
								Logger.botMsg(event.getChannel().getName(), Colors.NORMAL + Colors.BOLD + "ID: " + Colors.NORMAL + rs.getString("id") + " - " + Colors.BOLD + "Title: " + Colors.NORMAL + rs.getString("title") + " - " + Colors.BOLD + "Submitter: " + Colors.NORMAL + rs.getString("submitter") + " - " + Colors.BOLD + "Date: " + Colors.NORMAL + Util.getTime(rs.getLong("time") * 1000));

								for (String s : rs.getString("quote").split("\n"))
								{
									if (lines < 10)
									{
										lines++;
										event.respondChannel(s);
										Logger.botMsg(event.getChannel().getName(), s);
									}
									else
									{
										event.respondChannel("The rest of this quote is too long for IRC. Please see the full quote at http://geforcemods.net/quotes/viewquote.php?id=" + args[2]);
										Logger.botMsg(event.getChannel().getName(), "The rest of this quote is too long for IRC. Please see the full quote at http://geforcemods.net/quotes/viewquote.php?id=" + args[2]);
										break;
									}
								}
							}
							else
							{
								event.respondChannel("That quote hasn't been approved yet!");
								Logger.botMsg(event.getChannel().getName(), "That quote hasn't been approved yet!");
							}
						}

						rs.close();
						pst.close();
						Util.sqlCon.abort(null);
					}
					else
					{
						event.respondChannel("Quote IDs need to be numerical!");
						Logger.botMsg(event.getChannel().getName(), "Quote IDs need to be numerical!");
					}
				}

				break;
			case "add":
				event.respondChannel("You can submit new quotes here: http://geforcemods.net/quotes/addquote.php");
				Logger.botMsg(event.getChannel().getName(), "You can submit new quotes here: http://geforcemods.net/quotes/addquote.php");

				break;
			default:
				event.respondChannel("The argument " + args[1] + " was not recognized! Please see *help quote for arguments that can be used");
				Logger.botMsg(event.getChannel().getName(), "The argument " + args[1] + " was not recognized! Please see *help quote for arguments that can be used");

				break;
			}
		}
	}

	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			event.respond("You can view the quotes site here: http://geforcemods.net/quotes/");
			Logger.botMsg(event.getUser().getNick(), "You can view the quotes site here: http://geforcemods.net/quotes/");
		}
		else
		{
			switch (args[1].toLowerCase())
			{
			case "list":
				if (args.length == 2 || NumberUtils.isNumber(args[2]))
				{
					int page = 0;

					if (args.length == 2)
					{
						page = 1;
					}
					else
					{
						page = Integer.parseInt(args[2]);
					}

					int secondQuoteID = 10 * page;
					int firstQuoteID = secondQuoteID + 1 - 10;

					Util.sqlConnect();

					PreparedStatement pst = Util.sqlCon.prepareStatement("SELECT * FROM quotes WHERE id>=" + firstQuoteID + " AND id<=" + secondQuoteID + ";");
					ResultSet rs = pst.executeQuery();
					PreparedStatement secondPst = Util.sqlCon.prepareStatement("SELECT COUNT(id) AS id FROM quotes;");
					ResultSet secondRs = secondPst.executeQuery();

					secondRs.next();

					if (page >= 1 && page <= (int) Math.ceil(secondRs.getDouble("id") / 10))
					{
						event.respond("--- " + Colors.BOLD + "Page " + page + "/" + (int) Math.ceil(secondRs.getDouble("id") / 10) + Colors.NORMAL + " ---");
						Logger.botMsg(event.getUser().getNick(), "--- " + Colors.BOLD + "Page " + page + "/" + Math.ceil(secondRs.getDouble("id") / 10) + Colors.NORMAL + " ---");

						while (rs.next())
						{
							if (rs.getInt("approved") == 1)
							{
								event.respond(rs.getInt("id") + " - " + rs.getString("title"));
								Logger.botMsg(event.getUser().getNick(), rs.getInt("id") + " - " + rs.getString("title"));
							}
						}
					}
					else
					{
						event.respond("That page doesn't exist!");
						Logger.botMsg(event.getUser().getNick(), "That page doesn't exist!");
					}

					Util.sqlCon.abort(null);
				}
				else
				{
					event.respond("Page numbers need to be numerical!");
					Logger.botMsg(event.getUser().getNick(), "Page numbers need to be numerical!");
				}

				break;
			case "view":
				if (args.length == 2)
				{
					event.respond("You need to give me a quote ID!");
					Logger.botMsg(event.getUser().getNick(), "You need to give me a quote ID!");
				}
				else
				{
					if (NumberUtils.isNumber(args[2]))
					{
						Util.sqlConnect();
						PreparedStatement pst = Util.sqlCon.prepareStatement("SELECT * FROM quotes WHERE id='" + args[2] + "'");
						ResultSet rs = pst.executeQuery();

						if (!rs.next())
						{
							event.respond("That quote doesn't exist!");
							Logger.botMsg(event.getUser().getNick(), "That quote doesn't exist!");
						}
						else
						{
							if (rs.getInt("approved") == 1)
							{
								int lines = 0;

								event.respond(Colors.NORMAL + Colors.BOLD + "ID: " + Colors.NORMAL + rs.getString("id") + " - " + Colors.BOLD + "Title: " + Colors.NORMAL + rs.getString("title") + " - " + Colors.BOLD + "Submitter: " + Colors.NORMAL + rs.getString("submitter") + " - " + Colors.BOLD + "Date: " + Colors.NORMAL + Util.getTime(rs.getLong("time") * 1000));
								Logger.botMsg(event.getUser().getNick(), Colors.NORMAL + Colors.BOLD + "ID: " + Colors.NORMAL + rs.getString("id") + " - " + Colors.BOLD + "Title: " + Colors.NORMAL + rs.getString("title") + " - " + Colors.BOLD + "Submitter: " + Colors.NORMAL + rs.getString("submitter") + " - " + Colors.BOLD + "Date: " + Colors.NORMAL + Util.getTime(rs.getLong("time") * 1000));

								for (String s : rs.getString("quote").split("\n"))
								{
									if (lines < 10)
									{
										lines++;
										event.respond(s);
										Logger.botMsg(event.getUser().getNick(), s);
									}
									else
									{
										event.respond("The rest of this quote is too long for IRC. Please see the full quote at http://geforcemods.net/quotes/viewquote.php?id=" + args[2]);
										Logger.botMsg(event.getUser().getNick(), "The rest of this quote is too long for IRC. Please see the full quote at http://geforcemods.net/quotes/viewquote.php?id=" + args[2]);
										break;
									}
								}
							}
							else
							{
								event.respond("That quote hasn't been approved yet!");
								Logger.botMsg(event.getUser().getNick(), "That quote hasn't been approved yet!");
							}
						}

						rs.close();
						pst.close();
						Util.sqlCon.abort(null);
					}
					else
					{
						event.respond("Quote IDs need to be numerical!");
						Logger.botMsg(event.getUser().getNick(), "Quote IDs need to be numerical!");
					}
				}

				break;
			case "add":
				event.respond("You can submit new quotes here: http://geforcemods.net/quotes/addquote.php");
				Logger.botMsg(event.getUser().getNick(), "You can submit new quotes here: http://geforcemods.net/quotes/addquote.php");

				break;
			default:
				event.respond("The argument " + args[1] + " was not recognized! Please see *help quote for arguments that can be used");
				Logger.botMsg(event.getUser().getNick(), "The argument " + args[1] + " was not recognized! Please see *help quote for arguments that can be used");

				break;
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*quote" };
	}
}