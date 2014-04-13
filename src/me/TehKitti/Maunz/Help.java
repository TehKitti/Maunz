package me.TehKitti.Maunz;

import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class Help extends ListenerAdapter {

	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equals("*help")) {
				event.getUser()
						.send()
						.notice(Colors.TEAL
								+ "------------------ Maunz Help ------------------");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "All Maunz help documents are located in this command. Find the thing you need help with and read its description and syntax!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "All commands listed here can also be done via PM/query to Maunz.");
				event.getUser()
						.send()
						.notice(Colors.TEAL
								+ "---------------- Maunz Commands ----------------");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*stop   Stops Maunz. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*restart   Restarts Maunz. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*enable   Enables Maunz if she has been disabled with *disable. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*disable   Disables Maunz. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*ping   Makes Maunz respond to you with Pong. Very useful for testing ping to the IRC server.");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*say <message>   Makes Maunz say whatever you want her to!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*accinfo <account>   Tells you whether or not a Minecraft account is premium!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*source   Links you to the GitHub page of Maunz, you can submit issues/pull requests here.");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*help   Opens what you're looking at right now!");
				event.getUser()
						.send()
						.notice(Colors.TEAL
								+ "----------------- Maunz Credits ----------------");
				event.getUser().send()
						.notice(Colors.MAGENTA + "Created By TehKitti.");
				event.getUser().send()
						.notice(Colors.MAGENTA + "Help From bl4ckscor3.");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "Premium account status grabbed from http://axis.iaero.me");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "Coded in Java 7 using PircBotX 2.0.1 and its dependencies: https://code.google.com/p/pircbotx/");
			}
		}
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		if (Main.isEnabled == true) {
			if (event.getMessage().equals("*help")) {
				event.getUser()
						.send()
						.notice(Colors.TEAL
								+ "------------------ Maunz Help ------------------");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "All Maunz help documents are located in this command. Find the thing you need help with and read its description and syntax!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "All commands listed here can also be done via PM/query to Maunz.");
				event.getUser()
						.send()
						.notice(Colors.TEAL
								+ "---------------- Maunz Commands ----------------");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*stop   Stops Maunz. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*restart   Restarts Maunz. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*enable   Enables Maunz if she has been disabled with *disable. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*disable   Disables Maunz. Only useable by TehKitti!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*ping   Makes Maunz respond to you with Pong. Very useful for testing ping to the IRC server.");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*say <message>   Makes Maunz say whatever you want her to!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*accinfo <account>   Tells you whether or not a Minecraft account is premium!");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*source   Links you to the GitHub page of Maunz, you can submit issues/pull requests here.");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "*help   Opens what you're looking at right now!");
				event.getUser()
						.send()
						.notice(Colors.TEAL
								+ "----------------- Maunz Credits ----------------");
				event.getUser().send()
						.notice(Colors.MAGENTA + "Created By TehKitti.");
				event.getUser().send()
						.notice(Colors.MAGENTA + "Help From bl4ckscor3.");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "Premium account status grabbed from http://axis.iaero.me");
				event.getUser()
						.send()
						.notice(Colors.MAGENTA
								+ "Coded in Java 7 using PircBotX 2.0.1 and its dependencies: https://code.google.com/p/pircbotx/");
			}
		}
	}
}