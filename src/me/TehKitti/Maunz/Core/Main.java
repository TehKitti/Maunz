package me.TehKitti.Maunz.Core;

import me.TehKitti.Maunz.Commands.AccountInfo;
import me.TehKitti.Maunz.Commands.BulliedMe;
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
		static Configuration config = new Configuration.Builder().setName("SpookyMaunz")
				.setVersion("1.0")
				.setServerHostname("irc.esper.net")
				.setServerPort(6667)
				.setLogin("Maunz")
				.addAutoJoinChannel("#bl4ckscor3")
				.setNickservPassword("HIDDEN")
				.setAutoNickChange(true)
				.setCapEnabled(true)
				.addListener(new AccountInfo())
				.addListener(new BulliedMe())
				.addListener(new EnableAndDisable())
				.addListener(new Help())
				.addListener(new Other())
				.addListener(new Ping())
				.addListener(new Restart())
				.addListener(new Say())
				.addListener(new Source())
				.addListener(new Stop())
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
