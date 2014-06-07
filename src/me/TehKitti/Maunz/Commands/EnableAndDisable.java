package me.TehKitti.Maunz.Commands;

import me.TehKitti.Maunz.Core.Main;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class EnableAndDisable extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (event.getMessage().equalsIgnoreCase("*enable")) {
			if (event.getUser().getNick().equals("TehKitti")) {
				if (Main.isEnabled == false) {
					event.respond("Maunz has successfully been enabled!");
					Main.isEnabled = true;

				} else {
					event.respond("You silly, I was already enabled!");
				}
			} else {
				event.respond("I'm sorry but you do not have proper permissions to enable me!");
				event.getChannel()
						.send()
						.message(
								"I was hoping I could begin to take over the world here, guess I'll have to wait for TehKitti!");
			}
		}
		if (event.getMessage().equalsIgnoreCase("*disable")) {
			if (event.getUser().getNick().equals("TehKitti")) {
				if (Main.isEnabled == true) {
					event.respond("Maunz has successfully been disabled :(");
					Main.isEnabled = false;
				} else {
					event.respond("You silly, I was already disabled!");
				}
			} else {
				event.respond("I'm sorry but you do not have proper permissions to disable me!");
				event.getChannel()
						.send()
						.message(
								"Now nobody can stop me from taking over the world! Mwahahahahaha!");
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (event.getMessage().equalsIgnoreCase("*enable")) {
			if (event.getUser().getNick().equals("TehKitti")) {
				if (Main.isEnabled == false) {
					event.respond("Maunz has successfully been enabled!");
					Main.bot.sendIRC().message(
							"#bl4ckscor3",
							"Maunz has successfully been enabled!");
					Main.isEnabled = true;

				} else {
					event.respond("You silly, I was already enabled!");
				}
			} else {
				event.respond("I'm sorry but you do not have proper permissions to enable me!");
				event.respond("I was hoping I could begin to take over the world here, guess I'll have to wait for TehKitti!");
			}
		}
		if (event.getMessage().equals("*disable")) {
			if (event.getUser().getNick().equalsIgnoreCase("TehKitti")) {
				if (Main.isEnabled == true) {
					event.respond("Maunz has successfully been disabled :(");
					Main.bot.sendIRC().message(
							"#bl4ckscor3",
							"Maunz has successfully been disabled. :(");
					Main.isEnabled = false;
				} else {
					event.respond("You silly, I was already disabled!");
				}
			} else {
				event.respond("I'm sorry but you do not have proper permissions to disable me!");
				event.respond("Now nobody can stop me from taking over the world! Mwahahahahaha!");
			}
		}
	}
}