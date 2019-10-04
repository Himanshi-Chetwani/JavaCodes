/*
 * Name:
 *  PlayerFunction
 * Version:
 *    1.0
 * Revisions:
 *    None
 */

/**
 * Interface to describe player functionality
 */
public interface PlayerFunction extends java.rmi.Remote {
    void executeMessage(String message) throws java.rmi.RemoteException;

    void setName(ServerFunction serverFunction) throws java.rmi.RemoteException;

    void placeClientShips(ServerFunction serverFunctionObject) throws java.rmi.RemoteException;

    String getPlayerName() throws java.rmi.RemoteException;

    void setShipOne(Ship shipOne) throws java.rmi.RemoteException;

    void setShipTwo(Ship shipTwo) throws java.rmi.RemoteException;

    int[] getTargetCoordinates() throws java.rmi.RemoteException;

    void makePlay(ServerFunction serverFunction, PlayerFunction player)
            throws java.rmi.RemoteException;
}
