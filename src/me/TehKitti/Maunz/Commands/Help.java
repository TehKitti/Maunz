package me.TehKitti.Maunz.Commands;

import me.TehKitti.Maunz.Core.Main;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class Help extends ListenerAdapter {

	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equalsIgnoreCase("*help")) {
				event.respond("Help documents are located at http://tehkitti.pw/maunz.html");
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equalsIgnoreCase("*help")) {
				event.respond("Help documents are located at http://tehkitti.pw/maunz.html");
			}
		}
	}
}