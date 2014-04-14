package me.TehKitti.Maunz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class AccountInfo extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*accinfo")) {
				try {
					String[] seperate = event.getMessage().split(" ");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									new URL(
											"http://axis.iaero.me/accstatus?username="
													+ seperate[1]
													+ "&format=plain")
											.openStream()));
					String status = reader.readLine();
					if (status.equalsIgnoreCase("FREE")) {
						event.getChannel()
								.send()
								.message(
										"The Minecraft account name "
												+ seperate[1]
												+ " is free and does not belong to any account!");
					}
					if (status.equalsIgnoreCase("REGISTERED")) {
						event.getChannel()
								.send()
								.message(
										"The Minecraft account name "
												+ seperate[1]
												+ " belongs to an unpaid legacy account.");
					}
					if (status.equalsIgnoreCase("PREMIUM")) {
						event.getChannel()
								.send()
								.message(
										"The Minecraft account name "
												+ seperate[1]
												+ " belongs to a paid account.");
					}
					if (status
							.equalsIgnoreCase("Username must be 16 characters or less.")) {
						event.getChannel()
								.send()
								.message(
										"The Minecraft account name "
												+ seperate[1]
												+ " must be 16 characters or less.");
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					event.respond("Provide a username for me please!");
				}
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*accinfo")) {
				try {
					String[] seperate = event.getMessage().split(" ");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									new URL(
											"http://axis.iaero.me/accstatus?username="
													+ seperate[1]
													+ "&format=plain")
											.openStream()));
					String status = reader.readLine();
					if (status.equalsIgnoreCase("FREE")) {
						event.respond("The Minecraft account name "
								+ seperate[1]
								+ " is free and does not belong to any account!");
					}
					if (status.equalsIgnoreCase("REGISTERED")) {
						event.respond("The Minecraft account name "
								+ seperate[1]
								+ " belongs to an unpaid legacy account.");
					}
					if (status.equalsIgnoreCase("PREMIUM")) {
						event.respond("The Minecraft account name "
								+ seperate[1] + " belongs to a paid account.");
					}
					if (status
							.equalsIgnoreCase("Username must be 16 characters or less.")) {
						event.respond("The Minecraft account name "
								+ seperate[1]
								+ " must be 16 characters or less.");
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					event.respond("Provide a username for me please!");
				}

			}
		}
	}
}