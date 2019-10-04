Convert your battleship game to use a central server to control gameplay. This means that two clients will connect to the server and the server will manage gameplay. Your two clients should never directly communicate, all communication will pass through the server. 

Your communication protocol will be RMI. 

You may choose your own design for the game protocol. 

Please keep the following in your implementation from the previous assignment,

Prior to connection, each client will implement functionality to set ships. The number of ships will be as follows, 1 ship that is 2 grid positions long and 1 ship that is 4 positions long. Ships can be positioned in a horizontal or vertical alignment. 

The grid scale for each client will be 10x10.

Between rounds clients should be presenting to the user a view of the enemy waters showing unknown grid locations, grid locations that have been hit, and grid locations that were misses.

When a client has had all of their battleships sunk, they will indicate that the game is over.

Each client will then reset ready to either connect to or receive a connection for another game. This includes potentially resetting ship locations. 
