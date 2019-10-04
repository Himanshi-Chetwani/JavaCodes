/*
 * Name:
 *  ServerFunction
 * Version:
 *  1.0
 * Revisions:
 *  None
 */

/**
 * Interface for Server functions
 */
public interface ServerFunction extends java.rmi.Remote {
    void registerPlayer(PlayerFunction player) throws java.rmi.RemoteException;

    String getName() throws java.rmi.RemoteException;

    void placeShip(PlayerFunction player, int x, int y, int x1,
                   int y1, int shipNumber) throws java.rmi.RemoteException;

    String getGameBoard() throws java.rmi.RemoteException;

    void takeTurn(String message, PlayerFunction player, int x, int y)
            throws java.rmi.RemoteException;

    boolean checkPlayerHit(String playerName, int x, int y) throws
            java.rmi.RemoteException;
}
