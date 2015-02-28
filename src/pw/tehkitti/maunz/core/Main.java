package pw.tehkitti.maunz.core;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class Main 
{
	public static PircBotX bot;
	public static boolean isEnabled = true;

	public static void main(String args[]) throws Exception
	{
		createBot();
	}

	public static void createBot() throws Exception
	{
		Configuration config = new Configuration.Builder()
		.setName("Maunz")
		.setVersion("1.0")
		.setServerHostname("irc.esper.net")
		.setServerPort(6667)
		.setLogin("Maunz")
		.addAutoJoinChannel("#bl4ckscor3")
		.setNickservPassword("HIDDEN")
		.setAutoNickChange(true)
		.setCapEnabled(true)
		.addListener(new Listener())
		.setMessageDelay(400)
		.setRealName("Maunz, an IRC bot coded by TehKitti.")
		.buildConfiguration();

		bot = new PircBotX(config);
		bot.startBot();
		isEnabled = true;
	}
}
