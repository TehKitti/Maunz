package me.TehKitti.Maunz;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.output.OutputIRC;

@SuppressWarnings("rawtypes")
public class Restart extends ListenerAdapter {
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equalsIgnoreCase("*restart")) {
				if (event.getUser().getNick().equals("TehKitti")) {
					OutputIRC irc = new OutputIRC(Main.bot);
					event.getChannel()
							.send()
							.message(
									"I have been ordered to restart by "
											+ event.getUser().getNick());
					irc.quitServer();
					Main.main2();
				} else {
					event.respond("I'm sorry but you do not have proper permissions to restart me!");
					event.getChannel()
							.send()
							.message(
									"Now nobody can stop me from taking over the world! Mwahahahahaha!");
				}
			}

		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equalsIgnoreCase("*restart")) {
				if (event.getUser().getNick().equals("TehKitti")) {
					OutputIRC irc = new OutputIRC(Main.bot);
					Main.bot.sendIRC().message(
							"#bl4ckscor3",
							"I have been ordered to restart by "
									+ event.getUser().getNick());
					event.respond("I have been ordered to restart by "
							+ event.getUser().getNick());
					irc.quitServer();
					Main.main2();
				} else {
					event.respond("I'm sorry but you do not have proper permissions to restart me!");
					event.respond("Now nobody can stop me from taking over the world! Mwahahahahaha!");
				}
			}

		}
	}
}