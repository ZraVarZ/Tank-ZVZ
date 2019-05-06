package controller;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class FoMenuController implements Initializable {

    @FXML
    private AnchorPane mindennekAzAlapja;

    @FXML
    private Pane alapMenuPane;

    @FXML
    private Pane adjMegNevetPane;

    @FXML
    private Pane eredmenyekPane;

    @FXML
    private Button kezdesButton;

    @FXML
    private Button eredmenyekButton;

    @FXML
    private Button kilepesButton;

    @FXML
    private Button adjMegNevetButton;

    @FXML
    private TextField adjMegNevetTextField;

    @FXML
    private Button eredmenyekExitButton;

    public String megadottnev;


    public void handleAdjMegNevetButton(ActionEvent event){
        String nevellenorzes = adjMegNevetTextField.getText();
        nevellenorzes = nevellenorzes.replaceAll("\\s+","");
        if (nevellenorzes.equals("") || nevellenorzes == null){}
        else {
            megadottnev = nevellenorzes;
            adjMegNevetPane.setVisible(false);
            alapMenuPane.setOpacity(1);
            alapMenuPane.setDisable(false);
        }
    }

    public void kezdesB(ActionEvent event){
        System.out.println("a hacsa kápog");
        JatekController jatszunkEgyJatekot = new JatekController();
        jatszunkEgyJatekot.jatekLetrehozasa(megadottnev);
    }

    public void eredmenyekB(ActionEvent event){
        alapMenuPane.setOpacity(0.5);
        alapMenuPane.setDisable(true);
        eredmenyekPane.setVisible(true);
    }

    public void kilepesB(ActionEvent event){
        System.out.println("Kilepes...");
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("szevasz");
    }
}
