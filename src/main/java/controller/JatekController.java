package controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Tank;

import java.util.Random;

public class JatekController {
    private AnchorPane jatekPane;
    private Scene jatekScene;
    private Stage jatekStage;

    private static final int GAME_WIDTH = 832;
    private static final int GAME_HEIGHT = 832;

    private boolean wGombLenyomva;
    private boolean aGombLenyomva;
    private boolean sGombLenyomva;
    private boolean dGombLenyomva;
    private int angle;
    private AnimationTimer idozito;

    private final static String TANK1_IMAGE = "pictures/testtank1.png";
    private final static String TANK2_IMAGE = "pictures/testtank2.png";
    private final static String TANK3_IMAGE = "pictures/testtank3.png";
    private ImageView[] konnyuTank;
    private ImageView[] vadaszTank;
    private ImageView[] nehezTank;
   // private ImageView tank;
    private ImageView wall;
    private ImageView wall2;
    Random random;

    private ImageView tank2 = new ImageView("pictures/testtank.png");
    Tank jatekos = new Tank(tank2, 300, 600);

    JatekController(){
        initStage();
        initGombnyomas();
        random = new Random();
    }

    public void initStage(){
        jatekPane = new AnchorPane();
        jatekScene = new Scene(jatekPane, GAME_WIDTH, GAME_HEIGHT);
        jatekStage = new Stage();
        jatekStage.setScene(jatekScene);
    }

    public void initGombnyomas(){
        jatekScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.W){
                    wGombLenyomva = true;
                } else if (event.getCode() == KeyCode.A){
                    aGombLenyomva = true;
                } else if (event.getCode() == KeyCode.S){
                    sGombLenyomva = true;
                } else if (event.getCode() == KeyCode.D){
                    dGombLenyomva = true;
                } else if (event.getCode() == KeyCode.ESCAPE){
                    idozito.stop();
                    jatekStage.hide();
                }
            }
        });

        jatekScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.W){
                    wGombLenyomva = false;
                } else if (event.getCode() == KeyCode.A){
                    aGombLenyomva = false;
                } else if (event.getCode() == KeyCode.S){
                    sGombLenyomva = false;
                } else if (event.getCode() == KeyCode.D){
                    dGombLenyomva = false;
                }
            }
        });
    }

    public void jatekLetrehozasa(){
        tankLetrehozasa();
        enemyTankokLetrehozasa();
        loopLetrehozasa();
        jatekStage.show();

    }

    private void tankLetrehozasa(){
    //    tank = new ImageView("pictures/testtank.png");
    //    tank.setLayoutX(GAME_WIDTH/2);
    //    tank.setLayoutY(GAME_HEIGHT - 90);
    //    jatekPane.getChildren().add(tank);
        wall = new ImageView("pictures/testwall.png");
        wall.setLayoutX(0);
        wall.setLayoutY(64);
        jatekPane.getChildren().add(wall);
        wall2 = new ImageView("pictures/testwall.png");
        wall2.setLayoutX(128);
        wall2.setLayoutY(64);
        jatekPane.getChildren().add(wall2);
        jatekPane.getChildren().add(jatekos.getTankKepe());
    }

    private void loopLetrehozasa(){
        idozito = new AnimationTimer() {
            @Override
            public void handle(long now) {
                enemyMozgatas();
                enemyPozicioFigyelesEsUjrasorsolas();
                utkozesFigyeles();
                tankMozgas();
            }
        };
        idozito.start();
    }

    private void tankMozgas(){
        if(wGombLenyomva && !aGombLenyomva && !sGombLenyomva && !dGombLenyomva){
            jatekos.fel(4);
        }
        if(!wGombLenyomva && aGombLenyomva && !sGombLenyomva && !dGombLenyomva){
            jatekos.balra(4);
        }
        if(!wGombLenyomva && !aGombLenyomva && sGombLenyomva && !dGombLenyomva){
            jatekos.le(4);
        }
        if(!wGombLenyomva && !aGombLenyomva && !sGombLenyomva && dGombLenyomva){
            jatekos.jobbra(4);
        }
    }

    private void enemyTankokLetrehozasa(){
        konnyuTank = new ImageView[3];
        for(int i=0; i<konnyuTank.length; i++){
            konnyuTank[i] = new ImageView(TANK1_IMAGE);
            ujRandomPozicio(konnyuTank[i]);
            jatekPane.getChildren().add(konnyuTank[i]);
        }
        vadaszTank = new ImageView[3];
        for(int i=0; i<vadaszTank.length; i++){
            vadaszTank[i] = new ImageView(TANK2_IMAGE);
            ujRandomPozicio(vadaszTank[i]);
            jatekPane.getChildren().add(vadaszTank[i]);
        }
        nehezTank = new ImageView[3];
        for(int i=0; i<nehezTank.length; i++){
            nehezTank[i] = new ImageView(TANK3_IMAGE);
            ujRandomPozicio(nehezTank[i]);
            jatekPane.getChildren().add(nehezTank[i]);
        }
    }

    private void enemyMozgatas(){
        for(int i=0; i<konnyuTank.length; i++){
            konnyuTank[i].setLayoutY(konnyuTank[i].getLayoutY()+7);
            konnyuTank[i].setRotate(konnyuTank[i].getRotate()+4);
        }
        for(int i=0; i<vadaszTank.length; i++){
            vadaszTank[i].setLayoutY(vadaszTank[i].getLayoutY()+7);
            vadaszTank[i].setRotate(vadaszTank[i].getRotate()+4);
        }
        for(int i=0; i<nehezTank.length; i++){
            nehezTank[i].setLayoutY(nehezTank[i].getLayoutY()+7);
            nehezTank[i].setRotate(nehezTank[i].getRotate()+4);
        }
    }

    private void enemyPozicioFigyelesEsUjrasorsolas(){
        for(int i=0; i<konnyuTank.length; i++){
            if (konnyuTank[i].getLayoutY() > 800) {
                ujRandomPozicio(konnyuTank[i]);
            }
        }
        for(int i=0; i<vadaszTank.length; i++){
            if (vadaszTank[i].getLayoutY() > 800) {
                ujRandomPozicio(vadaszTank[i]);
            }
        }
        for(int i=0; i<nehezTank.length; i++){
            if (nehezTank[i].getLayoutY() > 800) {
                ujRandomPozicio(nehezTank[i]);
            }
        }
    }

    private void utkozesFigyeles(){
        for(int i=0; i<konnyuTank.length; i++){
            if (konnyuTank[i].getBoundsInParent().intersects(jatekos.getTankKepe().getBoundsInParent())){
                System.out.println("konnyu puff xDD");
            }
        }
        for(int i=0; i<vadaszTank.length; i++){
            if (vadaszTank[i].getBoundsInParent().intersects(jatekos.getTankKepe().getBoundsInParent())){
                System.out.println("vadasz puff xDD");
            }
        }
        for(int i=0; i<nehezTank.length; i++){
            if (nehezTank[i].getBoundsInParent().intersects(jatekos.getTankKepe().getBoundsInParent())){
                System.out.println("nehez puff xDD");
            }
        }
        if(jatekos.getTankKepe().getBoundsInParent().intersects(wall.getBoundsInParent())){
            System.out.println("wall xDD");
        }
        if(jatekos.getTankKepe().getBoundsInParent().intersects(wall2.getBoundsInParent())){
            System.out.println("wall xDD");
        }
    }

    private void ujRandomPozicio(ImageView image){
        image.setLayoutX(random.nextInt(832-56));
        image.setLayoutY(random.nextInt(100));
    }
}
