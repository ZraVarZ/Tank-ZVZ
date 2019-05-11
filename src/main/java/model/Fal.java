package model;

public class Fal {

    private int szelesseg = 32;
    private int magassag = 32;
    private int pozicioX;
    private int pozicioY;

    public Fal(int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
    }

    public Fal(){

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
