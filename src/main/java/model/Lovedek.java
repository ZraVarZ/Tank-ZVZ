package model;

public class Lovedek {
    private int szelesseg = 4;
    private int magassag = 4;
    private int pozicioX;
    private int pozicioY;
    private String irany;
    private int palyaSzelesseg;
    private int palyaMagassag;

    private boolean halott = true;

    public Lovedek(int pozicioX, int pozicioY, String irany, int palyaSzelesseg, int palyaMagassag) {
        this.irany = irany;
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.palyaSzelesseg = palyaSzelesseg;
        this.palyaMagassag = palyaMagassag;
    }

    public Lovedek(){}

    public void balra(int lepes){
        if (getPozicioX() > 0){
            setPozicioX(getPozicioX() - lepes);
        }
    }

    public void jobbra(int lepes){
        if (getPozicioX() < (getPalyaSzelesseg() - getSzelesseg())){
            setPozicioX(getPozicioX() + lepes);
        }
    }

    public void fel(int lepes){
        if (getPozicioY() > 0) {
            setPozicioY(getPozicioY() - lepes);
        }
    }

    public void le(int lepes){
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
