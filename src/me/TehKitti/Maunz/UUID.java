package me.TehKitti.Maunz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
					String[] seperate = event.getMessage().split(" ");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(new URL(
									"http://api.fishbans.com/uuid/"
											+ seperate[1]).openStream()));
					String line = reader.readLine();
					String[] newline = line.split("\"");
					if (newline[5].equals("User is not premium.")) {
						event.getChannel()
								.send()
								.message(
										"Username is either an unpaid legacy account or a free username.");
					} else {
						event.getChannel().send().message("" + newline[5]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					event.respond("Provide a username for me please!");
				}
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
	}
}
