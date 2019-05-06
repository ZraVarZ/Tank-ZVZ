package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Lovedek {
    private int szelesseg = 4;
    private int magassag = 4;
    private int pozicioX;
    private int pozicioY;
    private String irany;

    private boolean halott = false;

    private Image lovedekKepe;
    private Rectangle lovedek = new Rectangle(szelesseg, magassag);

    public Lovedek(Image lovedekKepe, int pozicioX, int pozicioY, String irany) {
        this.irany = irany;
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.lovedekKepe = lovedekKepe;
        lovedek.setLayoutX(getPozicioX());
        lovedek.setLayoutY(getPozicioY());
        lovedek.setFill(new ImagePattern(lovedekKepe));
    }

    public void balra(int lepes){
        if (lovedek.getLayoutX() > 0){
            this.lovedek.setLayoutX(getPozicioX() - lepes);
            this.pozicioX -= lepes;
        }
    }

    public void jobbra(int lepes){
        if (lovedek.getLayoutX() < (832 - szelesseg)){
            this.lovedek.setLayoutX(getPozicioX() + lepes);
            this.pozicioX += lepes;
        }
    }

    public void fel(int lepes){
        if (lovedek.getLayoutY() > 0) {
            this.lovedek.setLayoutY(getPozicioY() - lepes);
            this.pozicioY -= lepes;
        }
    }

    public void le(int lepes){
        if (lovedek.getLayoutY() < (832 - magassag)) {
            this.lovedek.setLayoutY(getPozicioY() + lepes);
            this.pozicioY += lepes;
        }
    }

    public Rectangle getLovedek() {
        return lovedek;
    }

    public void setLovedek(Rectangle lovedek) {
        this.lovedek = lovedek;
    }

    public Image getLovedekKepe() {
        return lovedekKepe;
    }

    public void setLovedekKepe(Image lovedekKepe) {
        this.lovedekKepe = lovedekKepe;
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
}
