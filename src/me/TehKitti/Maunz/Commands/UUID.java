package me.TehKitti.Maunz.Commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import me.TehKitti.Maunz.Core.Main;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class UUID extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*uuid")) {
				try {
					String[] args = event.getMessage().split(" ");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									new URL("http://api.fishbans.com/uuid/"
											+ args[1]).openStream()));
					String rawdata = reader.readLine();
					String[] rawresponse = rawdata.split("\"");
					if (rawresponse[5].equals("User is not premium.")) {
						event.getChannel()
								.send()
								.message(
										"Username is either an unpaid legacy account or a free username.");
					} else {
						event.getChannel().send().message("" + rawresponse[5]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					event.respond("Provide a username for me please!");
				}
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*uuid")) {
				try {
					String[] args = event.getMessage().split(" ");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									new URL("http://api.fishbans.com/uuid/"
											+ args[1]).openStream()));
					String rawdata = reader.readLine();
					String[] rawresponse = rawdata.split("\"");
					if (rawresponse[5].equals("User is not premium.")) {
						event.respond("Username is either an unpaid legacy account or a free username.");
					} else {
						event.respond("" + rawresponse[5]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					event.respond("Provide a username for me please!");
				}
			}
		}
	}
}