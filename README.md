#Maunz

Maunz is an IRC bot created by me with some help from bl4ckscor3 in Java using PircBotX. She is currently on multiple channels on the EsperNet IRC network and one on Freenode. Maunz can take commands through both PM and channels she is in. If you want to help Maunz development feel free to suggest ideas on Trello in the features or if you find any, even bugs in the bugs list :(

#Commands

Italic ones cannot be done by everyone and are restricted to just me. [] indicates that the argument is optional, \<> indicates the argument is required.

__Channel and PM Syntax__
 
*about - Gives information about Maunz such as version and uptime.
 
*accinfo \<username> - Gives you full information about any Minecraft account.

*changelog [version] - Tells you the changelog of the Maunz version you specify.

*chans - Lists the channels that Maunz is currently in.
 
_*disable_ - Disables Maunz.
 
_*enable_ - Enables Maunz.

*help \[command] - Links you to the README or gives command help if a command is given. Please note that command specific help defaults to channel syntax by default.

_*join \<channel>_ - Makes Maunz join a channel.

_*nick \<network> \<nickname>_ - Changes Maunz's nickname on a specific network.

*ping - Makes Maunz respond to you with pong. Very useful for testing ping to the IRC server!

*quote \<view/list/add> \<quoteid> [page] - Allows you to view IRC quotes.

*reddit \<subreddit> - Links you to a subreddit that you provide.

*reset - Resets the Cleverbot session in the channel sent in.

_*restart_ - Restarts Maunz.
 
*source - Links you to the GitHub page of Maunz, you can submit issues/pull requests here.

*steam \<steamid> - Links you to a Steam profile based on a Steam ID.

_*stop_ - Stops Maunz.

*trello - Links you to the Trello board of Maunz. Feature requests and bug reports can be made here.

_*update_ - This command automatically updates and restarts Maunz.

*whosay - Tells you the last person who used the *say command.

__Channel Only Syntax__

*bulliedme [channel] \<username> - Did somebody bully you? This will send them a link to stop with their bullying ways.

*bullyme [channel] \<username> Do you want somebody to bully you? This will send them a link to start with their bullying ways.

_*leave [channel]_ - Makes Maunz leave a channel.

*say [channel] \<message> - Makes Maunz say whatever you want her to!

__PM Only Syntax__

*bulliedme \<channel> \<username> - Did somebody bully you? This will send them a link to stop with their bullying ways.

*bullyme \<channel> \<username> Do you want somebody to bully you? This will send them a link to start with their bullying ways.

_*leave \<channel>_ - Makes Maunz leave a channel.

*say \<channel> \<message> - Makes Maunz say whatever you want her to!

#Dependencies

Maunz depends on some java libraries to function, some are PircBotX dependencies and some are mine that I've added for some features. These can be downloaded manually or automatically with Maven using Maunz's pom.xml. They are with their versions listed below.

Chatter Bot API - 1.3.3

Apache Commons Codec - 1.10

Apache Commons Lang - 3.4

Apache Commons IO - 2.5

Guava - 19.0

log4j-api - 2.5

log4j-core - 2.5

PircBotX - 2.1

slf4j-api - 1.7.21

slf4j-nop - 1.7.21

jsoup - 1.9.1

rome-utils - 1.6.0

rome - 1.6.0

jdom - 2.0.6

mysql-connector-java - 6.0.2
