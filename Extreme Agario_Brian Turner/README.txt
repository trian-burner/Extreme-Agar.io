----------
Extreme Agario Run Instructions
----------

 -- For normal Play, simply run the .jar file, hit the 'Run' button on the bottom, and follow the onscreen instructions

 -- For viewing the code, use Greenfoot 2.4.2 or earlier and double-click the .gfar file
	Greenfoot will unpack this file into a folder in the same directory as the .gfar file, and open the project

 -- For using the multiplayer functionality, you can either:
	Do it locally (easiest, and the way it's currently set up)
	Do it over a private Wi-Fi or LAN connection between two computers
	**A max of one client is allowed, any other clients will stop, with a connection timeout exception

--Locally--
 -- Open up two instances of the .jar file, and set them side-by-side on your computer
 -- Name one of them, set it to "Server" and hit 'enter'
 -- Name the other, set it to "Client" and hit 'enter'
 -- This will start the game
 ** An example image is included in this folder, for reference or for demo
 ** Be sure to have the Server started first, before attempting to connect the Client
 ** If you experience any crashes while doing this, your the game may have left a Socket open, preventing any other sockets to be opened on that port for a short while

--Private Connection--
 -- In Greenfoot, under the ServerClient, change the address String to the IP address of the computer running the Server
 -- Compile and run this on the client side. The .jar should still work for the Server, because it is not linked to any address
 ** Wi-Fi may result in low frame-rates



*enjoy
*any questions, e-mail trian.burner@outlook.com and I can get back to you over the weekend, or contact me through classroom