package com.vauff.maunz.commands;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.vauff.maunz.core.ICommand;
import com.vauff.maunz.core.Util;

import org.pircbotx.Colors;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Notify implements ICommand<MessageEvent, PrivateMessageEvent>
{
	private static HashMap<String, String> confirmationStatus = new HashMap<String, String>();

	@Override
	public void exeChan(MessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");
		String fileName = "map-notification-data/" + event.getUser().getNick() + ".txt";

		if (args.length == 1)
		{
			Util.msg(event, "You need to specify a map or argument! See *help notify for more info");
		}
		else
		{
			if (args[1].equals(""))
			{
				Util.msg(event, "Please keep to one space between arguments to prevent breakage");
			}
			else
			{
				File file = new File(Util.getJarLocation() + fileName);

				if (args[1].equalsIgnoreCase("list"))
				{
					if (Util.getFileContents(fileName).equals(" "))
					{
						Util.msg(event, "You do not have any map notifications set! Use *notify <map> to add or remove one");
					}
					else
					{
						Util.msg(event, "You currently have notifications set for the following maps: " + Colors.BOLD + Util.getFileContents(fileName).replace(",", " | "));
					}
				}

				else if (args[1].equalsIgnoreCase("confirm"))
				{
					if (confirmationStatus.containsKey(event.getUser().getNick()))
					{
						Util.msg(event, "Adding " + Colors.BOLD + confirmationStatus.get(event.getUser().getNick()) + Colors.NORMAL + " to your map notifications!");

						if (Util.getFileContents(fileName).equals(" "))
						{
							FileUtils.writeStringToFile(file, confirmationStatus.get(event.getUser().getNick()), "UTF-8");
						}
						else
						{
							FileUtils.writeStringToFile(file, Util.getFileContents(fileName) + "," + confirmationStatus.get(event.getUser().getNick()), "UTF-8");
						}

						confirmationStatus.remove(event.getUser().getNick());
					}
					else
					{
						Util.msg(event, "You don't have any map notification to confirm!");
					}
				}
				else
				{
					if (StringUtils.containsIgnoreCase(Util.getFileContents(fileName), args[1]))
					{
						Util.msg(event, "Removing " + Colors.BOLD + args[1] + Colors.NORMAL + " from your map notifications!");

						if (!Util.getFileContents(fileName).contains(","))
						{
							FileUtils.writeStringToFile(file, " ", "UTF-8");
						}
						else
						{
							if (StringUtils.containsIgnoreCase(Util.getFileContents(fileName), args[1] + ","))
							{
								FileUtils.writeStringToFile(file, StringUtils.replaceIgnoreCase(Util.getFileContents(fileName), args[1] + ",", ""), "UTF-8");
							}

							else if (StringUtils.containsIgnoreCase(Util.getFileContents(fileName), "," + args[1]))
							{
								FileUtils.writeStringToFile(file, StringUtils.replaceIgnoreCase(Util.getFileContents(fileName), "," + args[1], ""), "UTF-8");
							}
						}
					}
					else
					{
						if (StringUtils.containsIgnoreCase(Util.getFileContents("maps.txt"), args[1]))
						{
							Util.msg(event, "Adding " + Colors.BOLD + args[1] + Colors.NORMAL + " to your map notifications!");

							if (Util.getFileContents(fileName).equals(" "))
							{
								FileUtils.writeStringToFile(file, args[1], "UTF-8");
							}
							else
							{
								FileUtils.writeStringToFile(file, Util.getFileContents(fileName) + "," + args[1], "UTF-8");
							}
						}
						else
						{
							Util.msg(event, "The map " + Colors.BOLD + args[1] + Colors.NORMAL + " is not in my maps database, are you sure you'd like to add it? Type *notify confirm to confirm, otherwise ignore this message");
							confirmationStatus.put(event.getUser().getNick(), args[1]);

						}
					}
				}
			}
		}
	}
	
	@Override
	public void exePrivate(PrivateMessageEvent event) throws Exception
	{
		String[] args = event.getMessage().split(" ");
		String fileName = "map-notification-data/" + event.getUser().getNick() + ".txt";

		if (args.length == 1)
		{
			Util.msg(event, "You need to specify a map or argument! See *help notify for more info");
		}
		else
		{
			if (args[1].equals(""))
			{
				Util.msg(event, "Please keep to one space between arguments to prevent breakage");
			}
			else
			{
				File file = new File(Util.getJarLocation() + fileName);

				if (args[1].equalsIgnoreCase("list"))
				{
					if (Util.getFileContents(fileName).equals(" "))
					{
						Util.msg(event, "You do not have any map notifications set! Use *notify <map> to add or remove one");
					}
					else
					{
						Util.msg(event, "You currently have notifications set for the following maps: " + Colors.BOLD + Util.getFileContents(fileName).replace(",", " | "));
					}
				}

				else if (args[1].equalsIgnoreCase("confirm"))
				{
					if (confirmationStatus.containsKey(event.getUser().getNick()))
					{
						Util.msg(event, "Adding " + Colors.BOLD + confirmationStatus.get(event.getUser().getNick()) + Colors.NORMAL + " to your map notifications!");

						if (Util.getFileContents(fileName).equals(" "))
						{
							FileUtils.writeStringToFile(file, confirmationStatus.get(event.getUser().getNick()), "UTF-8");
						}
						else
						{
							FileUtils.writeStringToFile(file, Util.getFileContents(fileName) + "," + confirmationStatus.get(event.getUser().getNick()), "UTF-8");
						}

						confirmationStatus.remove(event.getUser().getNick());
					}
					else
					{
						Util.msg(event, "You don't have any map notification to confirm!");
					}
				}
				else
				{
					if (StringUtils.containsIgnoreCase(Util.getFileContents(fileName), args[1]))
					{
						Util.msg(event, "Removing " + Colors.BOLD + args[1] + Colors.NORMAL + " from your map notifications!");

						if (!Util.getFileContents(fileName).contains(","))
						{
							FileUtils.writeStringToFile(file, " ", "UTF-8");
						}
						else
						{
							if (StringUtils.containsIgnoreCase(Util.getFileContents(fileName), args[1] + ","))
							{
								FileUtils.writeStringToFile(file, StringUtils.replaceIgnoreCase(Util.getFileContents(fileName), args[1] + ",", ""), "UTF-8");
							}

							else if (StringUtils.containsIgnoreCase(Util.getFileContents(fileName), "," + args[1]))
							{
								FileUtils.writeStringToFile(file, StringUtils.replaceIgnoreCase(Util.getFileContents(fileName), "," + args[1], ""), "UTF-8");
							}
						}
					}
					else
					{
						if (StringUtils.containsIgnoreCase(Util.getFileContents("maps.txt"), args[1]))
						{
							Util.msg(event, "Adding " + Colors.BOLD + args[1] + Colors.NORMAL + " to your map notifications!");

							if (Util.getFileContents(fileName).equals(" "))
							{
								FileUtils.writeStringToFile(file, args[1], "UTF-8");
							}
							else
							{
								FileUtils.writeStringToFile(file, Util.getFileContents(fileName) + "," + args[1], "UTF-8");
							}
						}
						else
						{
							Util.msg(event, "The map " + Colors.BOLD + args[1] + Colors.NORMAL + " is not in my maps database, are you sure you'd like to add it? Type *notify confirm to confirm, otherwise ignore this message");
							confirmationStatus.put(event.getUser().getNick(), args[1]);

						}
					}
				}
			}
		}
	}

	@Override
	public String[] getAliases()
	{
		return new String[] { "*notify" };
	}
}