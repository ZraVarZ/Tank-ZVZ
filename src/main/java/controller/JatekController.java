package controller;

import adatbazis.XMLKeszito;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

/**
 * A JatekController osztály tartalmazza a játék elemeit.
 */
public class JatekController {

    /**
     * Naplózás.
     */
    Logger NAPLOZAS = LoggerFactory.getLogger(JatekController.class);

    /**
     * Az alap lap.
     */
    private AnchorPane jatekPane;

    /**
     * A jelenet.
     */
    private Scene jatekScene;

    /**
     * A színpad.
     */
    private Stage jatekStage;

    /**
     * Az ablak szélessége.
     */
    private static final int JATEK_SZELESSEG = 832;

    /**
     * Az ablak magassága.
     */
    private static final int JATEK_MAGASSAG = 832;

    /**
     * A tankok sebessége.
     */
    private int tankSebesseg = 2;

    /**
     * A lövedék sebessége.
     */
    private int lovedekSebesseg = 8;

    /**
     * W gomb lenyomás érzékelő.
     */
    private boolean wGombLenyomva;

    /**
     * A gomb lenyomás érzékelő.
     */
    private boolean aGombLenyomva;

    /**
     * S gomb lenyomás érzékelő.
     */
    private boolean sGombLenyomva;

    /**
     * D gomb lenyomás érzékelő.
     */
    private boolean dGombLenyomva;

    /**
     * Space lenyomás érzékelő.
     */
    private boolean spaceGombLenyomva;

    /**
     * Időzítő.
     */
    private AnimationTimer idozito;

    /**
     * A pálya háttere.
     */
    private ImageView palyaKep = new ImageView("pictures/palya.png");

    /**
     * Egyik ellenség képe.
     */
    private Image testtank3 = new Image("pictures/testtank3.png");

    /**
     * Másik ellenség képe.
     */
    private Image testtank2 = new Image("pictures/testtank2.png");

    /**
     * Tégla képe.
     */
    private Image teglaImg = new Image("pictures/tegla.png");

    /**
     * Beton képe.
     */
    private Image betonImg = new Image("pictures/beton.png");

    /**
     * Lövedék képe.
     */
    private Image lovedekImg = new Image("pictures/lovedek.png");

    /**
     * Játékos tank képe.
     */
    private Image tank = new Image("pictures/jatekostankja.png");

    /**
     * A tégla falakat tároló lista.
     */
    private ArrayList<Rectangle> gyengeFalak = new ArrayList<>();

    /**
     * A beton falakat tároló lista.
     */
    private ArrayList<Rectangle> erosFalak = new ArrayList<>();

    /**
     * A törlendő elem.
     */
    private Rectangle kockaTorles = null;

    /**
     * A játék elején megadott név.
     */
    private String megadottnev;

    /**
     * A játék során szerzett pont.
     */
    private Integer szerzettpont = 0;

    /**
     * A játékos.
     */
    private Tank jatekos;

    /**
     * Egyik ellenség.
     */
    private Tank ellenseg1;

    /**
     * Másik ellenség.
     */
    private Tank ellenseg2;

    /**
     * A játékos négyzete.
     */
    private Rectangle jatekosKocka;

    /**
     * Egyik ellenség négyzete.
     */
    private Rectangle ellensegKocka1;

    /**
     * Másik ellenség négyzete.
     */
    private Rectangle ellensegKocka2;

    /**
     * Lövedék.
     */
    private Lovedek lovedek;

    /**
     * Lövedék négyzete.
     */
    private Rectangle lovedekKocka;

    /**
     * random szám.
     */
    private int random;

    /**
     * A JatekController létrehozója.
     */
    JatekController(){
        initStage();
        initGombnyomas();
    }

    /**
     * Létrehozza a teret.
     */
    private void initStage(){
        jatekPane = new AnchorPane();
        jatekScene = new Scene(jatekPane, JATEK_SZELESSEG, JATEK_MAGASSAG);
        jatekStage = new Stage();
        jatekStage.setScene(jatekScene);
        NAPLOZAS.info("jatek inicializalva");
    }

    /**
     * Létrehozza a gombnyomásokat.
     */
    private void initGombnyomas(){
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
        NAPLOZAS.info("gombnyomas letrejott");
    }

    /**
     * Létrehozza a játék elemeit.
     * @param megadottnev A megadott név.
     */
    public void jatekLetrehozasa(String megadottnev){
        this.megadottnev = megadottnev;
        palyaLetrehozasa();
        tankLetrehozasa();
        lovedekLetrehozas();
        ellensegTankokLetrehozasa();
        loopLetrehozasa();
        jatekStage.show();
        NAPLOZAS.info("itt is kapog a hacsa -- letrejott minden");
    }

    /**
     * Létrehozza a pályát.
     */
    private void palyaLetrehozasa(){
        jatekPane.getChildren().add(palyaKep);
        for (int i = 0; i < Palya.PALYA.length; i++){
            String sor = Palya.PALYA[i];
            for (int j = 0; j < sor.length(); j++){
                switch (sor.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Fal gyengeFal = new Fal(j*32, i*32);
                        Rectangle gyengeFalKocka = new Rectangle(gyengeFal.getSzelesseg(), gyengeFal.getMagassag());
                        gyengeFalKocka.setLayoutX(gyengeFal.getPozicioX());
                        gyengeFalKocka.setLayoutY(gyengeFal.getPozicioY());
                        gyengeFalKocka.setFill(new ImagePattern(teglaImg));
                        gyengeFalak.add(gyengeFalKocka);
                        jatekPane.getChildren().add(gyengeFalKocka);
                        break;
                    case '2':
                        Fal erosFal = new Fal(j*32, i*32);
                        Rectangle erosFalKocka = new Rectangle(erosFal.getSzelesseg(), erosFal.getMagassag());
                        erosFalKocka.setLayoutX(erosFal.getPozicioX());
                        erosFalKocka.setLayoutY(erosFal.getPozicioY());
                        erosFalKocka.setFill(new ImagePattern(betonImg));
                        erosFalak.add(erosFalKocka);
                        jatekPane.getChildren().add(erosFalKocka);
                        break;
                }
            }
        }
        NAPLOZAS.info("palya elokerult -- atlantisz felterkepezve");
    }

    /**
     * Létrehozza a játékos tankját.
     */
    private void tankLetrehozasa(){
        jatekos = new Tank(300, 400, JATEK_SZELESSEG, JATEK_MAGASSAG);
        jatekosKocka = new Rectangle(jatekos.getSzelesseg(), jatekos.getMagassag());
        jatekosKocka.setLayoutX(jatekos.getPozicioX());
        jatekosKocka.setLayoutY(jatekos.getPozicioY());
        jatekosKocka.setFill(new ImagePattern(tank));
        jatekPane.getChildren().add(jatekosKocka);
        NAPLOZAS.info("sajat tank feltankolva");
    }

    /**
     * Létrehozza a lövedéket.
     */
    private void lovedekLetrehozas(){
        lovedek = new Lovedek(-100, -100, "fel", JATEK_SZELESSEG, JATEK_MAGASSAG);
        lovedekKocka = new Rectangle(lovedek.getSzelesseg(), lovedek.getMagassag());
        lovedekKocka.setLayoutX(lovedek.getPozicioX());
        lovedekKocka.setLayoutY(lovedek.getPozicioY());
        lovedekKocka.setFill(new ImagePattern(lovedekImg));
        jatekPane.getChildren().add(lovedekKocka);
        NAPLOZAS.info("lovedekek keszen allnak");
    }

    /**
     * Létrehozza az ellenséges tankokat.
     */
    private void ellensegTankokLetrehozasa(){
        ellenseg1 = new Tank(4,4, JATEK_SZELESSEG, JATEK_MAGASSAG);
        ellensegKocka1 = new Rectangle(ellenseg1.getSzelesseg(), ellenseg1.getMagassag());
        ellensegKocka1.setLayoutX(ellenseg1.getPozicioX());
        ellensegKocka1.setLayoutY(ellenseg1.getPozicioY());
        ellensegKocka1.setFill(new ImagePattern(testtank2));
        jatekPane.getChildren().add(ellensegKocka1);

        ellenseg2 = new Tank(4,772, JATEK_SZELESSEG, JATEK_MAGASSAG);
        ellensegKocka2 = new Rectangle(ellenseg2.getSzelesseg(), ellenseg2.getMagassag());
        ellensegKocka2.setLayoutX(ellenseg2.getPozicioX());
        ellensegKocka2.setLayoutY(ellenseg2.getPozicioY());
        ellensegKocka2.setFill(new ImagePattern(testtank3));
        jatekPane.getChildren().add(ellensegKocka2);

        NAPLOZAS.info("ellenseg uzemkesz");
    }

    /**
     * Létrehozza a játék folyamatát.
     */
    private void loopLetrehozasa(){
        idozito = new AnimationTimer() {
            @Override
            public void handle(long now) {
                tankMozgas();
                tankUjraRajzolas();
                lovedekMozgatas();
                lovedekUjraRajzolas();
                ellensegMozgatas();
                ellensegUjraRajzolas();
                utkozesFigyeles();
            }
        };
        idozito.start();
    }

    /**
     * Figyeli a lenyomott gombokat.
     */
    private void tankMozgas(){
        if (wGombLenyomva && !aGombLenyomva && !sGombLenyomva && !dGombLenyomva){
            jatekos.fel(tankSebesseg);
        }
        if (!wGombLenyomva && aGombLenyomva && !sGombLenyomva && !dGombLenyomva){
            jatekos.balra(tankSebesseg);
        }
        if (!wGombLenyomva && !aGombLenyomva && sGombLenyomva && !dGombLenyomva){
            jatekos.le(tankSebesseg);
        }
        if (!wGombLenyomva && !aGombLenyomva && !sGombLenyomva && dGombLenyomva){
            jatekos.jobbra(tankSebesseg);
        }
        if (spaceGombLenyomva && lovedek.isHalott()){
            loves();
        }
    }

    /**
     * Irányítja a lövést.
     */
    private void loves(){
        lovedek.setHalott(false);
        String irany = jatekos.getIrany();
        int x = 0;
        int y = 0;
        if (irany.equals("fel")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) -1;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2)) - 29;
        }
        if (irany.equals("le")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) - 1;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2)) + 29;
        }
        if (irany.equals("jobb")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) + 29;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2));
        }
        if (irany.equals("bal")){
            x = (jatekos.getPozicioX()+(jatekos.getSzelesseg()/2)) - 29;
            y = (jatekos.getPozicioY()+(jatekos.getMagassag()/2));
        }
        lovedek.setPozicioX(x);
        lovedek.setPozicioY(y);
        lovedekKocka.setVisible(true);
        lovedek.setIrany(irany);
    }

    /**
     * Újrarajzolja a tankot.
     */
    private void tankUjraRajzolas(){
        jatekosKocka.setLayoutX(jatekos.getPozicioX());
        jatekosKocka.setLayoutY(jatekos.getPozicioY());
        jatekosKocka.setRotate(jatekos.getSzog());
    }

    /**
     * Irányítja a lövedéket.
     */
    private void lovedekMozgatas(){
        if (lovedek.getIrany().equals("fel")){
            lovedek.fel(lovedekSebesseg);
        }
        if (lovedek.getIrany().equals("le")){
            lovedek.le(lovedekSebesseg);
        }
        if (lovedek.getIrany().equals("jobb")){
            lovedek.jobbra(lovedekSebesseg);
        }
        if (lovedek.getIrany().equals("bal")){
            lovedek.balra(lovedekSebesseg);
        }
    }

    /**
     * Újrarajzolja a lövedéket.
     */
    private void lovedekUjraRajzolas(){
        lovedekKocka.setLayoutX(lovedek.getPozicioX());
        lovedekKocka.setLayoutY(lovedek.getPozicioY());
    }

    /**
     * Irányítja az ellenségeket.
     */
    private void ellensegMozgatas(){
        random = new Random().nextInt(12);
        if (random == 0 || random == 1 || random == 2){
            ellenseg1.balra(2);
        }
        if (random == 3 || random == 4 || random == 5){
            ellenseg1.fel(2);
        }
        if (random == 6 || random == 7 || random == 8){
            ellenseg1.jobbra(2);
        }
        if (random == 9 || random == 10 || random == 11){
            ellenseg1.le(2);
        }
        random = new Random().nextInt(12);
        if (random == 0 || random == 1 || random == 2){
            ellenseg2.balra(2);
        }
        if (random == 3 || random == 4 || random == 5){
            ellenseg2.fel(2);
        }
        if (random == 6 || random == 7 || random == 8){
            ellenseg2.jobbra(2);
        }
        if (random == 9 || random == 10 || random == 11){
            ellenseg2.le(2);
        }
    }

    /**
     * Újrarajzolja az ellenségeket.
     */
    private void ellensegUjraRajzolas(){
        ellensegKocka1.setLayoutX(ellenseg1.getPozicioX());
        ellensegKocka1.setLayoutY(ellenseg1.getPozicioY());
        ellensegKocka1.setRotate(ellenseg1.getSzog());
        ellensegKocka2.setLayoutX(ellenseg2.getPozicioX());
        ellensegKocka2.setLayoutY(ellenseg2.getPozicioY());
        ellensegKocka2.setRotate(ellenseg2.getSzog());
    }

    /**
     * Figyeli az ütközéseket.
     */
    private void utkozesFigyeles(){
        gyengeFalak.forEach((objektum) -> {
            if (jatekosKocka.getBoundsInParent().intersects(objektum.getBoundsInParent())){
                kockaTorles = objektum;
                kockaTorles.setVisible(false);
                szerzettpont++;
            }
        });

        gyengeFalak.forEach((objektum) -> {
            if (lovedekKocka.getBoundsInParent().intersects(objektum.getBoundsInParent())){
                kockaTorles = objektum;
                lovedek.setHalott(true);
                kockaTorles.setVisible(false);
                lovedekKocka.setVisible(false);
                lovedek.setIrany("");
                szerzettpont++;
            }
        });
        gyengeFalak.remove(kockaTorles);

        if (lovedek.getPozicioX() < 5 || lovedek.getPozicioX() > JATEK_SZELESSEG - 5
                || lovedek.getPozicioY() < 5 || lovedek.getPozicioY() > JATEK_MAGASSAG - 5){
            lovedek.setHalott(true);
            lovedekKocka.setVisible(false);
            lovedek.setIrany("");
        }

        if (lovedekKocka.getBoundsInParent().intersects(ellensegKocka1.getBoundsInParent()) && !lovedek.isHalott()){
            lovedek.setHalott(true);
            lovedekKocka.setVisible(false);
            lovedek.setIrany("");
            ellenseg1.setHalott(true);
            ellensegKocka1.setVisible(false);
            szerzettpont += 1000;
            random = new Random().nextInt(JATEK_SZELESSEG - ellenseg1.getSzelesseg());
            ellenseg1.setPozicioX(random);
            random = new Random().nextInt(JATEK_MAGASSAG - ellenseg1.getMagassag());
            ellenseg1.setPozicioY(random);
            ellenseg1.setHalott(false);
            ellensegKocka1.setVisible(true);
        }

        if (lovedekKocka.getBoundsInParent().intersects(ellensegKocka2.getBoundsInParent()) && !lovedek.isHalott()){
            lovedek.setHalott(true);
            lovedekKocka.setVisible(false);
            lovedek.setIrany("");
            ellenseg2.setHalott(true);
            ellensegKocka2.setVisible(false);
            szerzettpont += 1000;
            random = new Random().nextInt(JATEK_SZELESSEG - ellenseg2.getSzelesseg());
            ellenseg2.setPozicioX(random);
            random = new Random().nextInt(JATEK_MAGASSAG - ellenseg2.getMagassag());
            ellenseg2.setPozicioY(random);
            ellenseg2.setHalott(false);
            ellensegKocka2.setVisible(true);
        }
    }
}