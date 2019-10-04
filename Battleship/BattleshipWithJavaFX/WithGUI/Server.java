import java.rmi.Naming;

public class Server {
    public Server(){

    }

    public static void main( String[] args ) {
        try{
            GameInterface obj = new GUI_Class();
            Naming.rebind("//localhost/IAmAGameImp",obj);
            System.out.println("Hello Server bound in registry");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
