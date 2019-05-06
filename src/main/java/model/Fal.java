package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Fal {

    private int szelesseg = 32;
    private int magassag = 32;
    private int pozicioX;
    private int pozicioY;

    private Image falKepe;
    private Rectangle fal = new Rectangle(szelesseg,magassag);

    public Fal(Image falKepe, int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.falKepe = falKepe;
        fal.setLayoutX(getPozicioX());
        fal.setLayoutY(getPozicioY());
        fal.setFill(new ImagePattern(falKepe));
    }

    public Rectangle getFal() {
        return fal;
    }

    public void setFal(Rectangle fal) {
        this.fal = fal;
    }

    public Image getFalKepe() {
        return falKepe;
    }

    public void setFalKepe(Image falKepe) {
        this.falKepe = falKepe;
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
}
