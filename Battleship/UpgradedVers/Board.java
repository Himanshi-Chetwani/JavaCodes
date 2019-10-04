/*
 * Name:
 *  Board.java
 * Version:
 *   1.0
 * Revisions:
 *   None
 */

/**
 * Creates a game board
 */
public class Board {
    private int boardSize = 10;
    private char[][] gameBoard = new char[boardSize][boardSize];
    private StringBuilder boardRepresentation;

    Board() {
        initializeBoard();
    }

    void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    void updateBoard(int x, int y) {
        if (gameBoard[x][y] == 'X' || gameBoard[x][y] == '1'|| gameBoard[x][y] == '2') return;
        gameBoard[x][y] = 'X';
    }

    void markShipHit(char c,int x, int y){
        gameBoard[x][y] = c;
    }
    void printBoard() {
        boardRepresentation = new StringBuilder();
        boardRepresentation.append(Player.BOARD);
        boardRepresentation.append("\n");
        boardRepresentation.append("\n");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardRepresentation.append(" ").append(gameBoard[i][j]);
            }
            boardRepresentation.append("\n");
        }

    }

    public String toString() {
        printBoard();
        return boardRepresentation.toString();
    }

    boolean checkIfMarkedAlready(int x, int y){
        return gameBoard[x][y] == 'X' || gameBoard[x][y] == '1'|| gameBoard[x][y]=='2';
    }

}