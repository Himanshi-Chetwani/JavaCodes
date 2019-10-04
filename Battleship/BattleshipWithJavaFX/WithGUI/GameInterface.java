import java.rmi.RemoteException;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

public interface GameInterface extends java.rmi.Remote {

public void animation() throws java.rmi.RemoteException;
}
