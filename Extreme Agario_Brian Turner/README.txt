----------
Extreme Agario Player Instructions
----------

 -- Agar.io is a web-based multi-player game centered around gaining "mass" (your size), and eating other players smaller than you

--Objects--
 -- The small dots are "proteins", which give you 1 mass and don't move
 -- The green circles are "viruses", which will split you into multiple pieces, which are easier for other players to eat
 -- If playing solo mode, there are "Pathogens" which are AI-controlled Cells made to imitate other players, because the network functionality is only with two players
     -- These will go around getting bigger and try and eat you if they are bigger
     -- Initially there are 6 of "Pathogens", but this can be changed in the Agar.class file

--Controls--
'w' -- Will eject mass from the Cell onto the world
'esc' -- Will exit you from the game by killing you
'enter' -- We left this in because it makes testing the game easier, but it increases your mass as you hold it down
'spacebar' -- Will create another little cell that is yours, and will follow you around until you are big enough to eat it

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

--Private Connection-- (the district-controlled computers here block Greenfoot or any un-signed .jar file from accessing the network, so this is impossible with school computers)
 -- In Greenfoot, under the ServerClient, change the address String to the IP address of the computer running the Server
 -- Compile and run this on the client side. The .jar should still work for the Server, because it is not linked to any address
 ** Wi-Fi may result in low frame-rates

*enjoy