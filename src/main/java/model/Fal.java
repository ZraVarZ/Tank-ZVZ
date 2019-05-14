package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Fal osztály jelenti a falakat a játékban.
 */
public class Fal {

    /**
     * Ez a naplózás.
     */
    Logger NAPLOZAS = LoggerFactory.getLogger(Fal.class);

    /**
     * Ez a változó tartalmazza a fal szélességét.
     */
    private int szelesseg = 32;

    /**
     * Ez a változó tartalmazza a fal magasságát.
     */
    private int magassag = 32;

    /**
     * Ez a változó tartalmazza a fal X pozícióját.
     */
    private int pozicioX;

    /**
     * Ez a változó tartalmazza a fal Y pozícióját.
     */
    private int pozicioY;

    /**
     * A Fal osztály felépítője.
     * @param pozicioX A fal X pozíciója.
     * @param pozicioY A fal Y pozíciója.
     */
    public Fal(int pozicioX, int pozicioY) {
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        NAPLOZAS.info("fal letrejott");
    }

    /**
     * A fal osztály üres felépítője.
     */
    public Fal(){

    }

    /**
     *A fal szélességének a megszerzője.
     * @return A fal szélessége.
     */
    public int getSzelesseg() {
        return szelesseg;
    }

    /**
     * A fal szélességének a beállítója.
     * @param szelesseg A fal szélessége.
     */
    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }

    /**
     * A fal magasságának a megszerzője.
     * @return A fal magassága.
     */
    public int getMagassag() {
        return magassag;
    }

    /**
     * A fal magasságának a beállítója.
     * @param magassag A fal magassága.
     */
    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    /**
     * A fal X pozíciójának a megszerzője.
     * @return A fal X pozíciója.
     */
    public int getPozicioX() {
        return pozicioX;
    }

    /**
     * A fal X pozíciójának a beállítója.
     * @param pozicioX A fal X pozíciója.
     */
    public void setPozicioX(int pozicioX) {
        this.pozicioX = pozicioX;
    }

    /**
     * A fal Y pozíciójának a megszerzője.
     * @return A fal Y pozíciója.
     */
    public int getPozicioY() {
        return pozicioY;
    }

    /**
     * A fal Y pozíciójának a beállítója.
     * @param pozicioY A fal Y pozíciója.
     */
    public void setPozicioY(int pozicioY) {
        this.pozicioY = pozicioY;
    }
}
