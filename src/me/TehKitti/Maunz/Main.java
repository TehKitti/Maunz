package me.TehKitti.Maunz;

import java.io.IOException;
import java.net.InetAddress;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Main {
	public static PircBotX bot;
	static boolean isEnabled = true;

	public static void main(String args[]) throws Exception {
		Configuration config = new Configuration.Builder().setName("Maunz")
				.setVersion("1.0")
				.setServerHostname("chaos.esper.net")
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
				//.addListener(new UUID())
				.setMessageDelay(500)
				.setRealName("Maunz, an IRC bot coded by TehKitti.")
				.buildConfiguration();

		bot = new PircBotX(config);
		bot.startBot();
		isEnabled = true;

	}

	public static void main2() throws IOException, IrcException {
		Configuration config = new Configuration.Builder()
		        .setName("Maunz")
				.setVersion("1.0")
				.setServerHostname("chaos.esper.net")
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
				//.addListener(new UUID())
				.setMessageDelay(500)
				.setRealName("Maunz, an IRC bot coded by TehKitti.")
				.buildConfiguration();

		bot = new PircBotX(config);
		bot.startBot();
		isEnabled = true;

	}
}
