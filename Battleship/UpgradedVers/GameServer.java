/*
 *  Name:
 *      GameServer.java
 *  Version:
 *      1.0
 *  Revisions:
 *      None
 */
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Class used to bind the server in the RMI registry
 */
public class GameServer extends UnicastRemoteObject {

    /**
     * Creates and exports a new UnicastRemoteObject object using an
     * anonymous port.
     *
     * <p>The object is exported with a server socket
     * created using the {@link RMISocketFactory} class.
     *
     * @throws RemoteException if failed to export object
     * @since 1.1
     */
    protected GameServer() throws RemoteException {
    }

    /**
     * Main method
     * @param args hostname, and port number
     * @throws MalformedURLException if URL used for connection is incorrect
     * @throws RemoteException
     * @throws InsufficientArgumentsException if number of arguments != 2
     */
    public static void main(String[] args) throws MalformedURLException,
            RemoteException, InsufficientArgumentsException {
        if (args.length != 2) {
            throw new InsufficientArgumentsException();
        }
        String hostName = args[0];
        String port = args[1];
        ServerFunction serverFunction = new ServerFunctionImplementation();
        Naming.rebind("//" + hostName + ":" + port + "/ServerFunction",
                serverFunction);
        System.out.println("STATUS: Server bound in registry");
    }
}
