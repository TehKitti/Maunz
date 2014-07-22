package me.TehKitti.Maunz.Commands;

import me.TehKitti.Maunz.Core.Main;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class BulliedMe extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*bulliedme")) {
				String[] args = event.getMessage().split(" ");
				if (args.length == 1) {
					event.respond("Nobody bullied you? Okay then.");
				}
				if (args.length != 1) {
					event.getChannel()
							.send()
							.message(
									args[1]
											+ ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
				}
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*bulliedme")) {
				String[] args = event.getMessage().split(" ");
				if (args.length == 1) {
				}
				event.respond("Nobody bullied you? Okay then.");
				if (args.length != 1) {
					Main.bot.sendIRC()
							.message(
									"#bl4ckscor3",
									args[1]
											+ ": Stop being a bully! Read http://stop-irc-bullying.eu/stop/");
				}
			}
		}
	}
}