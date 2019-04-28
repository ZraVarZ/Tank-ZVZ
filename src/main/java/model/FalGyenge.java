package model;

import javafx.scene.image.ImageView;

public class FalGyenge {

    private int szelesseg = 64;
    private int magassag = 64;
    private int pozicioX;
    private int pozicioY;
    private int forgas = 0;

    ImageView falKepe;

    public FalGyenge(ImageView falKepe, int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.falKepe = falKepe;
        this.falKepe.setLayoutX(getPozicioX());
        this.falKepe.setLayoutY(getPozicioY());
    }

    public ImageView getFalKepe() {
        return falKepe;
    }

    public void setFalKepe(ImageView falKepe) {
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
