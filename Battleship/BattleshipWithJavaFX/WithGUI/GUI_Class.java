import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;


public class GUI_Class extends Application implements GameInterface {
    static int numOfClick = 0;
    int x, y;
    ArrayList<String> names = new ArrayList<>();
    static int counterPlayerOne = 0;
    static int counterPlayerTwo = 0;

    public GUI_Class() throws RemoteException {

    }

    public void animation() throws RemoteException {
        launch();
    }


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start( Stage primaryStage ) throws Exception {
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    public Scene createScene() throws RemoteException {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                Button button = new Button();
                button.setStyle("-fx-background-color: \n" +
                        "        #000000,\n" +
                        "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                        "        linear-gradient(#426ab7, #263e75),\n" +
                        "        linear-gradient(#395cab, #223768);\n" +
                        "    -fx-background-insets: 0,1,2,3;\n" +
                        "    -fx-background-radius: 3,2,2,2;\n" +
                        "    -fx-padding: 12 30 12 30;\n" +
                        "    -fx-text-fill: white;\n" +
                        "    -fx-font-size: 12px;");

                button.setOnAction(( ActionEvent e ) -> {
                    if (numOfClick % 2 == 0) {
                        x = GridPane.getRowIndex(button);
                        y = GridPane.getColumnIndex(button);
                        if ((x == 2 && y == 2) || (x == 3 && y == 2) || (x == 4 && y == 4) || ((x == 4 && y == 5)) || (x == 4 && y == 6) || (x == 4 && y == 7)) {
                            button.setStyle(" -fx-background-color: red; ");
                            counterPlayerOne++;
                        } else {
                            button.setStyle(" -fx-background-color: blue;");
                        }
                        numOfClick++;

                    } else {
                        x = GridPane.getRowIndex(button);
                        y = GridPane.getColumnIndex(button);
                        if ((x == 9 && y == 1) || (x == 9 && y == 2) || (x == 5 && y == 8) || ((x == 6 && y == 8)) || (x == 7 && y == 8) || (x == 8 && y == 8)) {
                            button.setStyle(" -fx-background-color: red; ");
                        } else {
                            button.setStyle("-fx-background-color: orange; ");
                            counterPlayerTwo++;
                        }
                        numOfClick++;
                    }
                    if(counterPlayerOne==6 || counterPlayerTwo==6){
                        System.exit(0);
                    }

                });


                GridPane.setRowIndex(button, r);
                GridPane.setColumnIndex(button, c);
                gridPane.getChildren().addAll(button);
            }
        }

        return new Scene(gridPane, 500, 700);
    }


}