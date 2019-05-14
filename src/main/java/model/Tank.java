package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tank {
    private int szelesseg = 56;
    private int magassag = 56;
    private int pozicioX;
    private int pozicioY;
    private String irany = "fel";
    private int szog = 0;
    private int palyaSzelesseg;
    private int palyaMagassag;

    private boolean halott = false;

    Logger NAPLOZAS = LoggerFactory.getLogger(Tank.class);

    public Tank(int pozicioX, int pozicioY, int palyaSzelesseg, int palyaMagassag) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.palyaSzelesseg = palyaSzelesseg;
        this.palyaMagassag = palyaMagassag;
        NAPLOZAS.info("tank letrejott");
    }

    public Tank(){

    }

    /**
     * A tank balra mozgásának metódusa.
     * @param lepes A lépések száma.
     */
    public void balra(int lepes){
        setSzog(270);
        setIrany("bal");
        if (getPozicioX() > 0){
            setPozicioX(getPozicioX() - lepes);
        }
    }

    public void jobbra(int lepes){
        setSzog(90);
        setIrany("jobb");
        if (getPozicioX() < (getPalyaSzelesseg() - getSzelesseg())){
            setPozicioX(getPozicioX() + lepes);
        }
    }

    public void fel(int lepes){
        setSzog(0);
        setIrany("fel");
        if (getPozicioY() > 0) {
            setPozicioY(getPozicioY() - lepes);
        }
    }

    public void le(int lepes){
        setSzog(180);
        setIrany("le");
        if (getPozicioY() < (getPalyaMagassag() - getMagassag())) {
            setPozicioY(getPozicioY() + lepes);
        }
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

    public int getSzog() {
        return szog;
    }

    public void setSzog(int szog) {
        this.szog = szog;
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

    public int getPalyaSzelesseg() {
        return palyaSzelesseg;
    }

    public void setPalyaSzelesseg(int palyaSzelesseg) {
        this.palyaSzelesseg = palyaSzelesseg;
    }

    public int getPalyaMagassag() {
        return palyaMagassag;
    }

    public void setPalyaMagassag(int palyaMagassag) {
        this.palyaMagassag = palyaMagassag;
    }
}
