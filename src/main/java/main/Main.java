package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A Main osztály a program alapja.
 */
public class Main extends Application {

    /**
     * Ez a menü "jelenete".
     */
    private Scene menuJelenet;

    /**
     * Ez a start metódus. A main indítja el.
     * @param ablak Az ablak jelenet.
     * @throws Exception Kivétel.
     */
    @Override
    public void start(Stage ablak) throws Exception {
        FXMLLoader foMenuLoader = new FXMLLoader(
                getClass().getClassLoader().getResource("FXML/MindenIS.fxml"));
        Parent menuGyoker = foMenuLoader.load();
        ablak.setTitle("TANK-ZVZ");
        menuJelenet = new Scene(menuGyoker);
        ablak.setScene(menuJelenet);
        ablak.show();
    }

    /**
     * A main.
     * @param args Argumentumok.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
