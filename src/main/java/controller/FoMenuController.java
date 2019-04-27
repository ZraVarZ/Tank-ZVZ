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
    private Pane jatekPane;

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

    ImageView image = new ImageView();


    public void handleAdjMegNevetButton(ActionEvent event){
        if (adjMegNevetTextField.getText().equals("")){}
        else {
            adjMegNevetPane.setVisible(false);
            alapMenuPane.setOpacity(1);
            alapMenuPane.setDisable(false);
        }
    }

    public void kezdesB(ActionEvent event) throws IOException {
        System.out.println("a hacsa kápog");
    //    GameViewManager gVM = new GameViewManager();
    //    gVM.createNewGame();
        JatekController jatszunkEgyJatekot = new JatekController();
        jatszunkEgyJatekot.jatekLetrehozasa();
     /*   alapMenuPane.setVisible(false);
        jatekPane.setVisible(true);
        jatekPane.setFocusTraversable(true);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        draw(window);*/
    }

    public void eredmenyekB(ActionEvent event){}

    public void kilepesB(ActionEvent event){
        System.exit(0);
    }

    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    Rectangle kocka = new Rectangle();

    public boolean gombnyomas(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    @FXML
    public void keyHandler(KeyEvent keyCode){
        System.out.println("aaaaa");
        if (keyCode.getCode().equals(KeyCode.E)){
            System.out.println("hehehehe");
            kocka.setTranslateY(kocka.getTranslateY() + 4);
        }
    }

    public void update() {
        while(true) {
         /*   try{
                Thread.sleep(24);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }*/
            if (gombnyomas(KeyCode.W)) {
                System.out.println("W");
                kocka.setRotate(0);
                if (kocka.getLayoutY() > 0)
                    kocka.setLayoutY(kocka.getLayoutY() - 4);
                System.out.println(kocka.getLayoutY());
                break;
            }
            if (gombnyomas(KeyCode.A)) {
                System.out.println("A");
                kocka.setRotate(-90);
                if (kocka.getLayoutX() > 0)
                    kocka.setLayoutX(kocka.getLayoutX() - 4);
                System.out.println(kocka.getLayoutX());
                break;
            }
            if (gombnyomas(KeyCode.S)) {
                System.out.println("S");
                kocka.setRotate(180);
                if (kocka.getLayoutY() < jatekPane.getHeight() - kocka.getHeight())
                    kocka.setLayoutY(kocka.getLayoutY() + 4);
                System.out.println(kocka.getLayoutY());
                break;
            }
            if (gombnyomas(KeyCode.D)) {
                System.out.println("D");
                kocka.setRotate(90);
                if (kocka.getLayoutX() < jatekPane.getWidth() - kocka.getWidth())
                    kocka.setLayoutX(kocka.getLayoutX() + 4);
                System.out.println(kocka.getLayoutX());
                break;
            }
            if (gombnyomas(KeyCode.ESCAPE)) {
                System.out.println("Exiting program...");
                System.exit(0);
            }
            break;
        }
    }

    private void draw(Stage window){
        Image image = new Image("Pictures/testtank.png");
        kocka.setLayoutX(56);
        kocka.setLayoutY(56);
        kocka.setWidth(56);
        kocka.setHeight(56);
        kocka.setId("kockaa");
        kocka.setFill(new ImagePattern(image));
      //  kocka.setFill(Color.RED);
        jatekPane.getChildren().add(kocka);

        jatekPane.setOnKeyPressed(event->keys.put(event.getCode(),true));
        jatekPane.setOnKeyReleased(event-> {
            keys.put(event.getCode(), false);
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            //    update();
                window.getScene().setOnKeyPressed(e -> {
                    switch (e.getCode()) {
                        case W:
                            kocka.setRotate(0);
                            if (kocka.getLayoutY() > 0)
                                kocka.setLayoutY(kocka.getLayoutY() - 4);
                            System.out.println(kocka.getLayoutY());
                            break;
                        case A:
                            kocka.setRotate(-90);
                            if (kocka.getLayoutX() > 0)
                                kocka.setLayoutX(kocka.getLayoutX() - 4);
                            System.out.println(kocka.getLayoutX());
                            break;
                        case S:
                            kocka.setRotate(180);
                            if (kocka.getLayoutY() < jatekPane.getHeight() - kocka.getHeight())
                                kocka.setLayoutY(kocka.getLayoutY() + 4);
                            System.out.println(kocka.getLayoutY());
                            break;
                        case D:
                            kocka.setRotate(90);
                            if (kocka.getLayoutX() < jatekPane.getWidth() - kocka.getWidth())
                                kocka.setLayoutX(kocka.getLayoutX() + 4);
                            System.out.println(kocka.getLayoutX());
                            break;
                        case ESCAPE:
                            System.out.println("Exiting program...");
                            System.exit(0);
                        default:
                            break;
                    }
                });
            }
        };
        timer.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("szevasz");
    }
}
