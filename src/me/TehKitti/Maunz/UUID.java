package me.TehKitti.Maunz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

//temporarily disabled while i try to iron out issues

@SuppressWarnings("rawtypes")
public class UUID extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().startsWith("*uuid")) {
				try {
					String[] seperate = event.getMessage().split(" ");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									new URL("http://connorlinfoot.com/uuid/api/?user="
											+ seperate[1] + "&get=uuid").openStream()));
					String line = reader.readLine();
					System.out.println(line);



				} catch (ArrayIndexOutOfBoundsException e) {
					event.respond("Provide a username for me please!");
				}
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
	}
}