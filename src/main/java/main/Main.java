package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene menuJelenet;

    public Scene getMenuJelenet() {
        return menuJelenet;
    }

    @Override
    public void start(Stage ablak) throws Exception{
        FXMLLoader foMenuLoader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/MindenIS.fxml"));
        Parent menuGyoker = foMenuLoader.load();
        ablak.setTitle("TANK-ZVZ");
        menuJelenet = new Scene(menuGyoker);
        ablak.setScene(menuJelenet);
     //   ablak.setResizable(false);
        ablak.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
