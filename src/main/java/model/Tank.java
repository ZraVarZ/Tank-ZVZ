package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Tank osztály jelenti a tankokat a játékban.
 */
public class Tank {

    /**
     * Ez a naplózás.
     */
    private static final Logger NAPLOZAS = LoggerFactory.getLogger(Tank.class);

    /**
     * Ez a változó tartalmazza a tank szélességét.
     */
    private int szelesseg = 56;

    /**
     * Ez a változó tartalmazza a tank magasságát.
     */
    private int magassag = 56;

    /**
     * Ez a változó tartalmazza a tank X pozícióját.
     */
    private int pozicioX;

    /**
     * Ez a változó tartalmazza a tank Y pozícióját.
     */
    private int pozicioY;

    /**
     * Ez a változó tartalmazza a tank irányát.
     */
    private String irany = "fel";

    /**
     * Ez a változó tartalmazza a tank fordulási szögét.
     */
    private int szog = 0;

    /**
     * Ez a változó tartalmazza a pálya szélességét.
     */
    private int palyaSzelesseg;

    /**
     * Ez a változó tartalmazza a pálya magasságát.
     */
    private int palyaMagassag;

    /**
     * Ez a változó tartalmazza a tank állapotát.
     */
    private boolean halott = false;

    /**
     * Ez az osztály felépítője {@code Tank}.
     * @param pozicioX A tank X pozíciója {@code int}.
     * @param pozicioY A tank Y pozíciója {@code int}.
     * @param palyaSzelesseg A pálya szelessége {@code int}.
     * @param palyaMagassag A pálya magassága {@code int}.
     */
    public Tank(int pozicioX, int pozicioY,
                int palyaSzelesseg, int palyaMagassag) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.palyaSzelesseg = palyaSzelesseg;
        this.palyaMagassag = palyaMagassag;
        NAPLOZAS.info("tank letrejott");
    }

    /**
     * Ez az osztály üres felépítője.
     */
    public Tank() {

    }

    /**
     * A tank balra mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void balra(int lepes) {
        setSzog(270);
        setIrany("bal");
        if (getPozicioX() > 0) {
            setPozicioX(getPozicioX() - lepes);
        }
    }

    /**
     * A tank jobbra mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void jobbra(int lepes) {
        setSzog(90);
        setIrany("jobb");
        if (getPozicioX() < (getPalyaSzelesseg() - getSzelesseg())) {
            setPozicioX(getPozicioX() + lepes);
        }
    }

    /**
     * A tank fel mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void fel(int lepes) {
        setSzog(0);
        setIrany("fel");
        if (getPozicioY() > 0) {
            setPozicioY(getPozicioY() - lepes);
        }
    }

    /**
     * A tank le mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void le(int lepes) {
        setSzog(180);
        setIrany("le");
        if (getPozicioY() < (getPalyaMagassag() - getMagassag())) {
            setPozicioY(getPozicioY() + lepes);
        }
    }

    /**
     * A tank X pozíciójának a megszerzője.
     * @return A tank X pozíciója.
     */
    public int getPozicioX() {
        return pozicioX;
    }

    /**
     * A tank X pozíciójának a beállítója.
     * @param pozicioX A tank X pozíciója.
     */
    public void setPozicioX(int pozicioX) {
        this.pozicioX = pozicioX;
    }

    /**
     * A tank Y pozíciójának a megszerzője.
     * @return A tank Y pozíciója.
     */
    public int getPozicioY() {
        return pozicioY;
    }

    /**
     * A tank Y pozíciójának a beállítója.
     * @param pozicioY A tank Y pozíciója.
     */
    public void setPozicioY(int pozicioY) {
        this.pozicioY = pozicioY;
    }

    /**
     * A tank állapotának a megszerzője.
     * @return A tank állapota.
     */
    public boolean isHalott() {
        return halott;
    }

    /**
     * A tank állapotának a beállítója.
     * @param halott A tank állapota.
     */
    public void setHalott(boolean halott) {
        this.halott = halott;
    }

    /**
     * A tank irányának a megszerzője.
     * @return A tank iránya.
     */
    public String getIrany() {
        return irany;
    }

    /**
     * A tank irányának a beállítója.
     * @param irany A tank iránya.
     */
    public void setIrany(String irany) {
        this.irany = irany;
    }

    /**
     * A tank szögének a megszerzője.
     * @return A tank szöge.
     */
    public int getSzog() {
        return szog;
    }

    /**
     * A tank szögének a beállítója.
     * @param szog A tank szöge.
     */
    public void setSzog(int szog) {
        this.szog = szog;
    }

    /**
     * A tank szélességének a megszerzője.
     * @return A tank szélessége.
     */
    public int getSzelesseg() {
        return szelesseg;
    }

    /**
     * A tank szélességének a beállítója.
     * @param szelesseg A tank szélessége.
     */
    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }

    /**
     * A tank magasságának a megszerzője.
     * @return A tank magassága.
     */
    public int getMagassag() {
        return magassag;
    }

    /**
     * A tank magasságának a beállítója.
     * @param magassag A tank magassága.
     */
    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    /**
     * A pálya szélességének a megszerzője.
     * @return A pálya szélessége.
     */
    public int getPalyaSzelesseg() {
        return palyaSzelesseg;
    }

    /**
     * A pálya szélességének a beállítója.
     * @param palyaSzelesseg A pálya szélessége
     */
    public void setPalyaSzelesseg(int palyaSzelesseg) {
        this.palyaSzelesseg = palyaSzelesseg;
    }

    /**
     * A pálya magasságának a megszerzője.
     * @return A pálya magassága.
     */
    public int getPalyaMagassag() {
        return palyaMagassag;
    }

    /**
     * A pálya megasságának a beállítója.
     * @param palyaMagassag A pálya magassága.
     */
    public void setPalyaMagassag(int palyaMagassag) {
        this.palyaMagassag = palyaMagassag;
    }
}
