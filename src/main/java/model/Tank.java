package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tank {

    private int szelesseg = 56;
    private int magassag = 56;
    private int pozicioX;
    private int pozicioY;
    private String irany = "fel";

    private boolean halott = false;

    private Image tankKepe;
    private Rectangle tank = new Rectangle(szelesseg, magassag);

    public Tank(Image tankKepe, int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.tankKepe = tankKepe;
        tank.setLayoutX(getPozicioX());
        tank.setLayoutY(getPozicioY());
        tank.setFill(new ImagePattern(tankKepe));
    }

    public void balra(int lepes){
        this.tank.setRotate(270);
        irany = "bal";
        if (tank.getLayoutX() > 0){
            this.tank.setLayoutX(getPozicioX() - lepes);
            this.pozicioX -= lepes;
        }
    }

    public void jobbra(int lepes){
        this.tank.setRotate(90);
        irany = "jobb";
        if (tank.getLayoutX() < (832 - szelesseg)){
            this.tank.setLayoutX(getPozicioX() + lepes);
            this.pozicioX += lepes;
        }
    }

    public void fel(int lepes){
        this.tank.setRotate(0);
        irany = "fel";
        if (tank.getLayoutY() > 0) {
            this.tank.setLayoutY(getPozicioY() - lepes);
            this.pozicioY -= lepes;
        }
    }

    public void le(int lepes){
        this.tank.setRotate(180);
        irany = "le";
        if (tank.getLayoutY() < (832 - magassag)) {
            this.tank.setLayoutY(getPozicioY() + lepes);
            this.pozicioY += lepes;
        }
    }

    public Rectangle getTank() {
        return tank;
    }

    public void setTank(Rectangle tank) {
        this.tank = tank;
    }

    public Image getTankKepe() {
        return tankKepe;
    }

    public void setTankKepe(Image tankKepe) {
        this.tankKepe = tankKepe;
    }

    public int getPozicioX() {
        return pozicioX;
    }

    public void setPozicioX(int pozicioX) {
        this.pozicioX = pozicioX;
    }

    public int getPozicioY() {
        return pozicioY;
    }

    public void setPozicioY(int pozicioY) {
        this.pozicioY = pozicioY;
    }

    public boolean isHalott() {
        return halott;
    }

    public void setHalott(boolean halott) {
        this.halott = halott;
    }

    public String getIrany() {
        return irany;
    }

    public void setIrany(String irany) {
        this.irany = irany;
    }

    public int getSzelesseg() {
        return szelesseg;
    }

    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }
}
