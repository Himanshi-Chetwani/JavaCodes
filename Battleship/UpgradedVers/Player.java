/*
 * Name:
 *      Player.java
 * Version:
 *      2.0
 * Revisions:
 *      Communication is through RMI
 */
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Class used to describe a Player
 */
public class Player extends UnicastRemoteObject implements Serializable,
        PlayerFunction {
    private String name;
    private Ship shipOne;
    private Ship shipTwo;
    static boolean exit = false;
    private boolean hit = false;
    static final String BOARD = "\nBOARD: ";
    private static final String ATTACK = "ATTACK";
    boolean notHit = true;
    volatile String serverMessage = "";


    private Player() throws RemoteException {
        super();
    }

    /**
     * Get name of player from server, and set it as player name
     *
     * @param serverFunctionObject object sed for access to remote method
     *                             getName()
     * @throws RemoteException Communication related exception that could be
     *                         thrown during execution of remote method.
     */
    @Override
    public void setName(ServerFunction serverFunctionObject) throws
            RemoteException {
        name = serverFunctionObject.getName();
        System.out.println("Your name is: " + name);
    }

    private String getShipCoordinates() {
        System.out.println("Enter start position of ship in x,y form: ");
        Scanner playerInput = new Scanner(System.in);
        String startPosition = playerInput.nextLine();
        System.out.println("Enter end position of ship in x,y form: ");
        String endPosition = playerInput.nextLine();
        return "S: " + startPosition + ";" + "E: " + endPosition;
    }

    private String[] splitStringInput(String input) {
        String[] resultantCoordinates;
        resultantCoordinates = input.split(",");
        return resultantCoordinates;
    }

    private String[] createInputStringArray(String input) {
        String[] inputCoordinates = new String[2];
        int i = input.indexOf(" ");
        String start = input.substring(i + 1, i + 4);
        int j = input.lastIndexOf(" ");
        String end = input.substring(j + 1, j + 4);
        inputCoordinates[0] = start;
        inputCoordinates[1] = end;
        return inputCoordinates;
    }

    private Player getPlayer() {
        System.out.println(this);
        return this;
    }

    @Override
    public void placeClientShips(ServerFunction serverFunctionObject)
            throws RemoteException {
        String input = getShipCoordinates();
        String[] inputArray;
        inputArray = createInputStringArray(input);
        String[] shipStartCoordinates = splitStringInput(inputArray[0]);
        String[] shipEndCoordinates = splitStringInput(inputArray[1]);
        int startX = Integer.parseInt(shipStartCoordinates[0]);
        int startY = Integer.parseInt(shipStartCoordinates[1]);
        int endX = Integer.parseInt(shipEndCoordinates[0]);
        int endY = Integer.parseInt(shipEndCoordinates[1]);
        int length =
                1 + (int) Math.sqrt(((endX - startX) * (endX - startX)) +
                        ((endY - startY) * (endY - startY)));
        serverFunctionObject.placeShip(getPlayer(), startX, startY, endX, endY
                , length);

    }

    @Override
    public void executeMessage(String message) {
        System.out.println("RECEIVED COMMUNICATION: " + message);
        serverMessage = message;
        if (message.contains("-1,-1")) {
            exit = true;
            notHit = false;
        }

    }

    @Override
    public void setShipOne(Ship ship) {
        shipOne = ship;
    }

    @Override
    public void setShipTwo(Ship ship) {
        shipTwo = ship;
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public int[] getTargetCoordinates() {
        int[] targetPosition = new int[2];

        if (exit) return new int[]{-1, -1};
        System.out.println("Enter target coordinates in x,y form: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("10,10")) {
            throw new IndexOutOfBoundsException();
        }

        String[] targetPositionStrings = splitStringInput(input);
        for (int i = 0; i < targetPositionStrings.length; i++) {
            targetPosition[i] = Integer.parseInt(targetPositionStrings[i]);
        }
        return targetPosition;
    }

    @Override
    public void makePlay(ServerFunction serverFunction, PlayerFunction player)
            throws RemoteException {
        do {
            if (true) {
                if (serverMessage.length() != 0 && serverMessage.contains(
                        "Enter")) {
                    int[] attackCoordinates = getTargetCoordinates();
                    serverFunction.takeTurn(ATTACK, player, attackCoordinates[0],
                            attackCoordinates[1]);
                    notHit = true;
                }

            }
        } while (!exit);
        UnicastRemoteObject.unexportObject(player, false);

    }

    public static void main(String[] args) throws RemoteException,
            NotBoundException, MalformedURLException,
            InsufficientArgumentsException {


        if (args.length != 2) {
            throw new InsufficientArgumentsException();
        }
        String hostName = args[0];
        String port = args[1];
        PlayerFunction player = new Player();
        Naming.rebind("//" + hostName + ":" + port + "/playerFunction",
                player);

        ServerFunction serverFunction = (ServerFunction) Naming.lookup
                ("rmi://" + hostName + ":" + port + "/ServerFunction");

        player.setName(serverFunction);

        serverFunction.registerPlayer(player);

        System.out.println("Enter details for Ship: Destroyer");
        player.placeClientShips(serverFunction);

        System.out.println("Enter details for Ship: Battleship");
        player.placeClientShips(serverFunction);

        System.out.println(serverFunction.getGameBoard());

        player.makePlay(serverFunction, player);


    }
}
