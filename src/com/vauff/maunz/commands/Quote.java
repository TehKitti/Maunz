package com.vauff.maunz.commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Executor;

import org.apache.commons.lang3.math.NumberUtils;

import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

public class Quote implements ICommand<MessageEvent, PrivateMessageEvent>
{
	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");

		if (args.length == 1)
		{
			Util.msg(event, "You can view the quotes site here: http://geforcemods.net/quotes/");
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
						Util.msg(event, "--- " + Colors.BOLD + "Page " + page + "/" + (int) Math.ceil(secondRs.getDouble("id") / 10) + Colors.NORMAL + " ---");

						while (rs.next())
						{
							if (rs.getInt("approved") == 1)
							{
								Util.msg(event, rs.getInt("id") + " - " + rs.getString("title"));
							}
						}
					}
					else
					{
						Util.msg(event, "That page doesn't exist!");
					}

					Util.sqlCon.abort(new Executor()
					{
						@Override
						public void execute(Runnable command)
						{
						}
					});
				}
				else
				{
					Util.msg(event, "Page numbers need to be numerical!");
				}

				break;
			case "view":
				if (args.length == 2)
				{
					Util.msg(event, "You need to give me a quote ID!");
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
							Util.msg(event, "That quote doesn't exist!");
						}
						else
						{
							if (rs.getInt("approved") == 1)
							{
								int lines = 0;

								Util.msg(event, Colors.NORMAL + Colors.BOLD + "ID: " + Colors.NORMAL + rs.getString("id") + " - " + Colors.BOLD + "Title: " + Colors.NORMAL + rs.getString("title") + " - " + Colors.BOLD + "Submitter: " + Colors.NORMAL + rs.getString("submitter") + " - " + Colors.BOLD + "Date: " + Colors.NORMAL + Util.getTime(rs.getLong("time") * 1000));

								for (String s : rs.getString("quote").split("\n"))
								{
									if (lines < 10)
									{
										lines++;
										Util.msg(event, s);
									}
									else
									{
										Util.msg(event, "The rest of this quote is too long for IRC. Please see the full quote at http://geforcemods.net/quotes/viewquote.php?id=" + args[2]);
										break;
									}
								}
							}
							else
							{
								Util.msg(event, "That quote hasn't been approved yet!");
							}
						}

						rs.close();
						pst.close();
						Util.sqlCon.abort(new Executor()
						{
							@Override
							public void execute(Runnable command)
							{
							}
						});
					}
					else
					{
						Util.msg(event, "Quote IDs need to be numerical!");
					}
				}

				break;
			case "add":
				Util.msg(event, "You can submit new quotes here: http://geforcemods.net/quotes/addquote.php");

				break;
			default:
				Util.msg(event, "The argument " + args[1] + " was not recognized! Please see *help quote for arguments that can be used");

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
			Util.msg(event, "You can view the quotes site here: http://geforcemods.net/quotes/");
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
						Util.msg(event, "--- " + Colors.BOLD + "Page " + page + "/" + (int) Math.ceil(secondRs.getDouble("id") / 10) + Colors.NORMAL + " ---");

						while (rs.next())
						{
							if (rs.getInt("approved") == 1)
							{
								Util.msg(event, rs.getInt("id") + " - " + rs.getString("title"));
							}
						}
					}
					else
					{
						Util.msg(event, "That page doesn't exist!");
					}

					Util.sqlCon.abort(new Executor()
					{
						@Override
						public void execute(Runnable command)
						{
						}
					});
				}
				else
				{
					Util.msg(event, "Page numbers need to be numerical!");
				}

				break;
			case "view":
				if (args.length == 2)
				{
					Util.msg(event, "You need to give me a quote ID!");
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
							Util.msg(event, "That quote doesn't exist!");
						}
						else
						{
							if (rs.getInt("approved") == 1)
							{
								int lines = 0;

								Util.msg(event, Colors.NORMAL + Colors.BOLD + "ID: " + Colors.NORMAL + rs.getString("id") + " - " + Colors.BOLD + "Title: " + Colors.NORMAL + rs.getString("title") + " - " + Colors.BOLD + "Submitter: " + Colors.NORMAL + rs.getString("submitter") + " - " + Colors.BOLD + "Date: " + Colors.NORMAL + Util.getTime(rs.getLong("time") * 1000));

								for (String s : rs.getString("quote").split("\n"))
								{
									if (lines < 10)
									{
										lines++;
										Util.msg(event, s);
									}
									else
									{
										Util.msg(event, "The rest of this quote is too long for IRC. Please see the full quote at http://geforcemods.net/quotes/viewquote.php?id=" + args[2]);
										break;
									}
								}
							}
							else
							{
								Util.msg(event, "That quote hasn't been approved yet!");
							}
						}

						rs.close();
						pst.close();
						Util.sqlCon.abort(new Executor()
						{
							@Override
							public void execute(Runnable command)
							{
							}
						});
					}
					else
					{
						Util.msg(event, "Quote IDs need to be numerical!");
					}
				}

				break;
			case "add":
				Util.msg(event, "You can submit new quotes here: http://geforcemods.net/quotes/addquote.php");

				break;
			default:
				Util.msg(event, "The argument " + args[1] + " was not recognized! Please see *help quote for arguments that can be used");

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