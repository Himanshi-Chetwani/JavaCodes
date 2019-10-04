import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Player {
    Ship shipOne,shipTwo;
    String name;
    private Player(){


    }

    public static void main( String[] args ) {
        Player player = new Player();
        try{
            Registry registry = LocateRegistry.getRegistry(null);
            GameInterface obj = (GameInterface) Naming.lookup("//localhost" +
                    "/IAmAGameImp");
            obj.animation();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

