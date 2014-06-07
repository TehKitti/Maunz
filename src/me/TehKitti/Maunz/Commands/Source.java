package me.TehKitti.Maunz.Commands;

import me.TehKitti.Maunz.Core.Main;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class Source extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equalsIgnoreCase("*source")) {
				event.respond("https://github.com/TehKitti/Maunz");

			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equalsIgnoreCase("*source")) {
				event.respond("https://github.com/TehKitti/Maunz");

			}
		}
	}
}