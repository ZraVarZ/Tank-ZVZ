package model;

public class TankModel {
    private int szelesseg = 56;
    private int magassag = 56;
    private int pozicioX;
    private int pozicioY;
    private int sebesseg = 4;

    public TankModel(int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
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

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }
}
