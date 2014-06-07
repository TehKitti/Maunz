package me.TehKitti.Maunz.Commands;

import me.TehKitti.Maunz.Core.Main;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class Say extends ListenerAdapter {

	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*say")) {
				String seperate = event.getMessage().substring(4);
				String msg = seperate.substring(1);

				if (event.getMessage().startsWith("*say -say")) {
					event.getChannel()
							.send()
							.message(
									"Stop trying to abuse us, "
											+ event.getUser().getNick()
											+ "! We aren't spambots, are we, bl4ckb0t?");
				} else {
					event.getChannel().send().message(msg);
				}

			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase().startsWith("*say")) {
				String seperate = event.getMessage().substring(4);
				String msg = seperate.substring(1);

				if (event.getMessage().startsWith("*say -say")) {
					Main.bot.sendIRC()
							.message(
									"#bl4ckscor3",
									"Stop trying to abuse us, "
											+ event.getUser().getNick()
											+ "! We aren't spambots, are we, bl4ckb0t?");

				}

				else {
					Main.bot.sendIRC().message("#bl4ckscor3", msg);
				}

			}
		}
	}
}