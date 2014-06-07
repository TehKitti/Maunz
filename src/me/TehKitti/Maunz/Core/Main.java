package me.TehKitti.Maunz.Core;

import me.TehKitti.Maunz.Commands.AccountInfo;
import me.TehKitti.Maunz.Commands.EnableAndDisable;
import me.TehKitti.Maunz.Commands.Help;
import me.TehKitti.Maunz.Commands.Ping;
import me.TehKitti.Maunz.Commands.Restart;
import me.TehKitti.Maunz.Commands.Say;
import me.TehKitti.Maunz.Commands.Source;
import me.TehKitti.Maunz.Commands.Stop;
import me.TehKitti.Maunz.Commands.UUID;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Main {
	public static PircBotX bot;
	public static boolean isEnabled = true;

		static Configuration config = new Configuration.Builder().setName("Maunz")
				.setVersion("1.0")
				.setServerHostname("irc.esper.net")
				.setServerPort(6667)
				.setLogin("Maunz")
				.addAutoJoinChannel("#bl4ckscor3")
				.setNickservPassword("HIDDEN")
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.addListener(new Stop())
				.addListener(new Restart())
				.addListener(new Ping())
				.addListener(new Help())
				.addListener(new Say())
				.addListener(new Other())
				.addListener(new EnableAndDisable())
				.addListener(new AccountInfo())
				.addListener(new Source())
				.addListener(new UUID())
				.setMessageDelay(400)
				.setRealName("Maunz, an IRC bot coded by TehKitti.")
				.buildConfiguration();

	public static void main(String args[]) throws Exception {
		bot = new PircBotX(config);
		bot.startBot();
		isEnabled = true;

	}

	public static void main2() throws Exception {
		bot = new PircBotX(config);
		bot.startBot();
		isEnabled = true;

	}
}
