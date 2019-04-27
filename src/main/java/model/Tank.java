package model;

import javafx.scene.image.ImageView;

public class Tank {
    private int szelesseg = 56;
    private int magassag = 56;
    private int pozicioX;
    private int pozicioY;
    private int forgas = 0;


    ImageView tankKepe;

    public Tank(ImageView tankKepe, int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.tankKepe = tankKepe;
        this.tankKepe.setLayoutX(getPozicioX());
        this.tankKepe.setLayoutY(getPozicioY());
    }

    public void balra(int lepes){
        this.tankKepe.setRotate(270);
        if (tankKepe.getLayoutX() > 0){
            this.tankKepe.setLayoutX(getPozicioX() - lepes);
            this.pozicioX -= lepes;
        }
    }

    public void jobbra(int lepes){
        this.tankKepe.setRotate(90);
        if (tankKepe.getLayoutX() < (832 - szelesseg)){
            this.tankKepe.setLayoutX(getPozicioX() + lepes);
            this.pozicioX += lepes;
        }
    }

    public void fel(int lepes){
        this.tankKepe.setRotate(0);
        if (tankKepe.getLayoutY() > 0) {
            this.tankKepe.setLayoutY(getPozicioY() - lepes);
            this.pozicioY -= lepes;
        }
    }

    public void le(int lepes){
        this.tankKepe.setRotate(180);
        if (tankKepe.getLayoutY() < (832 - magassag)) {
            this.tankKepe.setLayoutY(getPozicioY() + lepes);
            this.pozicioY += lepes;
        }
    }

    public ImageView getTankKepe() {
        return tankKepe;
    }

    public void setTankKepe(ImageView tankKepe) {
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
}
