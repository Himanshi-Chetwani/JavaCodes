/*
 *  Name:
 *      ServerFunctionImplementation
 *  Version:
 *      1.0
 *  Revisions:
 *      None
 */
import java.rmi.RemoteException;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Implementation of Server functions
 */
public class ServerFunctionImplementation extends UnicastRemoteObject implements
        ServerFunction {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Ship> playerOneShips = new ArrayList<>();
    private ArrayList<Ship> playerTwoShips = new ArrayList<>();
    private Board boardObject = new Board();
    private boolean playerOneTurn = true;
    private int countOfShips = 0;
    PlayerFunction[] players = new PlayerFunction[2];
    private static final String ATTENTION = "You just lost a chance";
    private static final String NAMEOFPLAYERONE = "Player-1";
    private static final String NAMEOFPLAYERTWO = "Player-2";
    String promptToEnter = "Enter target coordinates in x,y form: ";

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
    ServerFunctionImplementation() throws RemoteException {
        names.add(NAMEOFPLAYERONE);
        names.add(NAMEOFPLAYERTWO);
    }


    @Override
    public void registerPlayer(PlayerFunction player) throws RemoteException {
        if (player.getPlayerName().equals(NAMEOFPLAYERONE)) {
            players[0] = player;
        } else {
            players[1] = player;
        }
    }

    @Override
    public String getName() {
        String returnName = names.get(0);
        names.remove(0);
        return returnName;
    }


    private void attack(PlayerFunction player, int x, int y) throws
            RemoteException {
        if (boardObject.checkIfMarkedAlready(x, y)) {
            player.executeMessage(ATTENTION);
        }
        boardObject.updateBoard(x, y);
    }

    private void printMessageToServer(PlayerFunction player, int start_x,
                                      int start_y
            , int end_x, int end_y) throws RemoteException {

        System.out.println("STATUS: " + player.getPlayerName() + " " + "set " +
                "ship" +
                " at: " + " ( " + start_x + "," + start_y + ")" + " ,"
                + " ( " + end_x + " ," + end_y + " )");
    }

    @Override
    public void placeShip(PlayerFunction player, int start_x, int start_y,
                          int end_x, int end_y, int number) throws
            RemoteException {

        countOfShips++;
        Ship tempShipOne = null;
        Ship tempShipTwo = null;
        if (number == 2) {
            tempShipOne = new Ship(start_x, start_y, end_x, end_y, number);
            player.setShipOne(tempShipOne);
            printMessageToServer(player, start_x, start_y, end_x, end_y);
        } else {

            tempShipTwo = new Ship(start_x, start_y, end_x,
                    end_y, number);
            player.setShipTwo(tempShipTwo);
            printMessageToServer(player, start_x, start_y, end_x, end_y);
        }
        if (player.getPlayerName().equals("Player-1")) {
            if (!(tempShipOne == null)) {
                playerOneShips.add(tempShipOne);
            }
            if (!(tempShipTwo == null)) {
                playerOneShips.add(tempShipTwo);
            }

        } else {
            if (!(tempShipOne == null)) {
                playerTwoShips.add(tempShipOne);
            }
            if (!(tempShipTwo == null)) {
                playerTwoShips.add(tempShipTwo);
            }

        }
        if (playerOneShips.size() == 2 && playerTwoShips.size() == 2) {
            players[0].executeMessage(promptToEnter);
        }
    }

    private boolean checkPlayerHitHelper(ArrayList<Ship> shipList, int x,
                                         int y) {
        boolean checkFlag = false;
        Ship shipOne = shipList.get(0);
        checkFlag |= shipOne.checkShipStatus(x, y);
        Ship shipTwo = shipList.get(1);
        checkFlag |= shipTwo.checkShipStatus(x, y);
        return checkFlag;
    }

    @Override
    public boolean checkPlayerHit(String name, int x, int y) {
        if (name.equals("Player-1")) {
            return checkPlayerHitHelper(playerTwoShips, x, y);
        } else {
            return checkPlayerHitHelper(playerOneShips, x, y);
        }


    }

    @Override
    public String getGameBoard() {
        return boardObject.toString();
    }

    private boolean areShipsLost(PlayerFunction player) throws RemoteException {
        if (player.getPlayerName().equals(NAMEOFPLAYERONE)) {
            return playerOneShips.get(0).shipIsHit() &&
                    playerOneShips.get(1).shipIsHit();
        } else {
            return playerTwoShips.get(0).shipIsHit() &&
                    playerTwoShips.get(1).shipIsHit();
        }
    }

    private void writeToPlayers(String message) throws RemoteException {
        for (PlayerFunction singlePlayer : players) {
            singlePlayer.executeMessage(message);
        }
    }

    @Override
    public void takeTurn(String message, PlayerFunction player, int x, int y)
            throws RemoteException {
        if (x >= 10 || y >= 10) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (countOfShips == 4) {
            boolean isValid = true;
            if (player.getPlayerName().equals(NAMEOFPLAYERONE) &&
                    playerOneTurn) {
                playerOneTurn = false;
                writeToPlayers(player.getPlayerName() + "'s Turn");
                attack(player, x, y);
                if (checkPlayerHit(player.getPlayerName(), x, y)) {
                    writeToPlayers("HIT: Player-2's ship was hit at "
                            + x + "," + y);
                    boardObject.markShipHit('2', x, y);
                    isValid = checkValidity(players[1]);
                }
                writeToPlayers(boardObject.toString());
                if (isValid) {
                    players[1].executeMessage(promptToEnter);
                }
                if (!isValid) {
                    writeToPlayers(player.getPlayerName() + "'s " +
                            "ships are " +
                            "lost");
                    writeToPlayers("-1,-1");
                }
            } else if (player.getPlayerName().equals(NAMEOFPLAYERTWO) &&
                    !playerOneTurn) {
                writeToPlayers(player.getPlayerName() + "'s Turn");
                attack(player, x, y);
                if (checkPlayerHit(player.getPlayerName(), x, y)) {
                    writeToPlayers("HIT: Player-1's ship was hit " +
                            "at "
                            + x + "," + y);
                    boardObject.markShipHit('1', x, y);
                    isValid = checkValidity(players[0]);
                }
                writeToPlayers(boardObject.toString());
                playerOneTurn = true;
                if (isValid) {
                    players[0].executeMessage(promptToEnter);
                }
                else {
                    writeToPlayers(player.getPlayerName() + "'s " +
                            "ships are " +
                            "lost");
                    writeToPlayers("-1,-1");
                }
            } else {
                player.executeMessage("Not your turn!");
            }
        }
    }


    private boolean checkValidity(PlayerFunction player) throws RemoteException {
        if (areShipsLost(player)) {
            return false;
        }
        return true;
    }
}

