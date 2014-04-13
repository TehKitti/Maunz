package me.TehKitti.Maunz;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class bl4ckb0tListener extends ListenerAdapter {

	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().endsWith(
					"We aren't spambots, are we, Maunz?")) {
				if (event.getUser().getNick().equalsIgnoreCase("bl4ckb0t")) {
					event.getChannel().send()
							.message("No, we aren't, bl4ckb0t!");

				}
			}
		}
	}
}