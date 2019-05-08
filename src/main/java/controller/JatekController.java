package controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;
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
    private boolean spaceGombLenyomva;
    private boolean lohet = true;
    private AnimationTimer idozito;

    private final static String TANK1_IMAGE = "pictures/testtank1.png";
    private final static String TANK2_IMAGE = "pictures/testtank2.png";
    private final static String TANK3_IMAGE = "pictures/testtank3.png";
    private Image ezkell = new Image("pictures/testtank1.png");
    private Image ezkell2 = new Image("pictures/testtank2.png");

    private ImageView palyaKep = new ImageView("pictures/palya.png");
    private Image teglaImg = new Image("pictures/tegla.png");
    private Image betonImg = new Image("pictures/beton.png");
    private Image lovedekImg = new Image("pictures/lovedek.png");

    private ArrayList<Fal> gyengeFalak = new ArrayList<>();

    private ArrayList<Fal> falak = new ArrayList<>();

    Fal torles = null;

    Random random;

    public String megadottnev;
    public Integer szerzettpont = 0;

    private Image tank = new Image("pictures/testtank.png");
    Tank jatekos;
    private ArrayList<Tank> konnyuTankok = new ArrayList<>();
    private ArrayList<Lovedek> lovedekek = new ArrayList<>();

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
                } else if (event.getCode() == KeyCode.SPACE){
                    spaceGombLenyomva = true;
                } else if (event.getCode() == KeyCode.ESCAPE){
                    idozito.stop();

                    XMLKeszito keszito = new XMLKeszito();
                    keszito.keszites(megadottnev, szerzettpont);

                 /*   XMLOlvaso olvaso = new XMLOlvaso();
                    olvaso.olvasas();*/

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
                } else if (event.getCode() == KeyCode.SPACE){
                    spaceGombLenyomva = false;
                }
            }
        });
    }

    public void jatekLetrehozasa(String megadottnev){
        this.megadottnev = megadottnev;
        palyaLetrehozasa();
        tankLetrehozasa();
        enemyTankokLetrehozasa(random.nextInt(832-56), random.nextInt(100));
        loopLetrehozasa();
        jatekStage.show();
    }

    private void palyaLetrehozasa(){
        jatekPane.getChildren().add(palyaKep);
        for (int i = 0; i < Palya.PALYA.length; i++){
            String sor = Palya.PALYA[i];
            for (int j = 0; j < sor.length(); j++){
                switch (sor.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Fal asd = new Fal(teglaImg,j*32,i*32);
                        falak.add(asd);
                        System.out.println(asd.getPozicioX() + " " + asd.getPozicioY());
                        jatekPane.getChildren().add(asd.getFal());
                        break;
                    case '2':
                        Fal asd1 = new Fal(betonImg, j*32, i*32);
                        falak.add(asd1);
                        jatekPane.getChildren().add(asd1.getFal());
                        break;
                }
            }
        }
    }

    private Node falakLetrehozasa(int x, int y, int w, int h, Image kep){
        Rectangle fal = new Rectangle(w, h);
        fal.setTranslateX(x);
        fal.setTranslateY(y);
        fal.setFill(new ImagePattern(kep));
        jatekPane.getChildren().add(fal);
        return fal;
    }

    private void tankLetrehozasa(){
        jatekos = new Tank(tank, 300, 400);
        jatekPane.getChildren().add(jatekos.getTank());
    }

    private void loopLetrehozasa(){
        idozito = new AnimationTimer() {
            @Override
            public void handle(long now) {
                enemyMozgatas();
                lovedekMozgatas();
                utkozesFigyeles();
                tankMozgas();
            }
        };
        idozito.start();
    }

    private void tankMozgas(){
        if (wGombLenyomva && !aGombLenyomva && !sGombLenyomva && !dGombLenyomva){
            jatekos.fel(2);
        }
        if (!wGombLenyomva && aGombLenyomva && !sGombLenyomva && !dGombLenyomva){
            jatekos.balra(2);
        }
        if (!wGombLenyomva && !aGombLenyomva && sGombLenyomva && !dGombLenyomva){
            jatekos.le(2);
        }
        if (!wGombLenyomva && !aGombLenyomva && !sGombLenyomva && dGombLenyomva){
            jatekos.jobbra(2);
        }
        if (spaceGombLenyomva && lohet){
            loves();
          /*  lohet = false;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            lohet = true;*/
        }
    }

    private void enemyTankokLetrehozasa(int X, int Y){
        for (int i = 0; i<3; i++){
            Tank konnyuT = new Tank(ezkell, random.nextInt(432-56), random.nextInt(100) );
            konnyuTankok.add(konnyuT);
            jatekPane.getChildren().add(konnyuT.getTank());
        }

        Tank vadaszT = new Tank(ezkell2, random.nextInt(832-56), random.nextInt(100));
        konnyuTankok.add(vadaszT);
        jatekPane.getChildren().add(vadaszT.getTank());
    }

    private void enemyMozgatas(){
        konnyuTankok.forEach((tankok) -> {
            tankok.jobbra(4);
        });

    }

    private void utkozesFigyeles(){
        falak.forEach((objektum) -> {
            if (jatekos.getTank().getBoundsInParent().intersects(objektum.getFal().getBoundsInParent())){
                System.out.println("működik");
                torles = objektum;
                torles.getFal().setVisible(false);
                szerzettpont++;
            }
        });
     /*   falak.forEach((objektum) -> {
            if (lovedekek.forEach((lovedekekek) -> {
                lovedekekek.getLovedek().getBoundsInParent().intersects(objektum.getFal().getBoundsInParent())
            });)
        });*/
        falak.remove(torles);
    }

    private void loves(){
        String irany = jatekos.getIrany();
        int x = 0;
        int y = 0;
        if (irany.equals("fel")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) -2;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2)) - 30;
            System.out.println("lőttem fel");
        }
        if (irany.equals("le")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) - 2;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2)) + 30;
            System.out.println("lőttem le");
        }
        if (irany.equals("jobb")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) + 30;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2));
            System.out.println("lőttem jobbra");
        }
        if (irany.equals("bal")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) - 30;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2));
            System.out.println("lőttem balra");
        }
        Lovedek lovedek = new Lovedek(lovedekImg, x, y, irany);
        lovedekek.add(lovedek);
        jatekPane.getChildren().add(lovedek.getLovedek());
    }

    private void lovedekMozgatas(){
        lovedekek.forEach((lovedekek) -> {
            if (lovedekek.getIrany().equals("fel")){
                lovedekek.fel(8);
            }
            if (lovedekek.getIrany().equals("le")){
                lovedekek.le(8);
            }
            if (lovedekek.getIrany().equals("jobb")){
                lovedekek.jobbra(8);
            }
            if (lovedekek.getIrany().equals("bal")){
                lovedekek.balra(8);
            }
        });
    }
}
