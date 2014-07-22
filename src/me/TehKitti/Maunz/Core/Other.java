package me.TehKitti.Maunz.Core;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class Other extends ListenerAdapter {

	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().toLowerCase()
					.endsWith("We aren't spambots, are we, Maunz?")) {
				if (event.getUser().getNick().equalsIgnoreCase("bl4ckb0t")) {
					event.getChannel().send()
							.message("No, we aren't, bl4ckb0t!");
				}
			}
		}
	}
}