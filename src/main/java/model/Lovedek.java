package model;

/**
 * A Lovedek osztály jelenti a lövedéket a játékban.
 */
public class Lovedek {

    /**
     * Ez a változó tartalmazza a lövedék szélességét.
     */
    private int szelesseg = 4;

    /**
     * Ez a változó tartalmazza a lövedék magasságát.
     */
    private int magassag = 4;

    /**
     * Ez a változó tartalmazza a lövedék X pozícióját.
     */
    private int pozicioX;

    /**
     * Ez a változó tartalmazza a lövedék Y pozícióját.
     */
    private int pozicioY;

    /**
     * Ez a változó tartalmazza a lövedék irányát.
     */
    private String irany;

    /**
     * Ez a változó tartalmazza a pálya szélességét.
     */
    private int palyaSzelesseg;

    /**
     * Ez a változó tartalmazza a pálya magasságát.
     */
    private int palyaMagassag;

    /**
     * Ez a változó tartalmazza a lövedék állapotát.
     */
    private boolean halott = true;

    /**
     * Ez az osztály felépítője {@code Lovedek}.
     * @param pozicioX A lövedék X pozíciója {@code int}.
     * @param pozicioY A lövedék Y pozíciója {@code int}.
     * @param irany A lövedék iránya {@code String}.
     * @param palyaSzelesseg A pálya szélessége {@code int}.
     * @param palyaMagassag A pálya magassága {@code int}.
     */
    public Lovedek(int pozicioX, int pozicioY, String irany,
                   int palyaSzelesseg, int palyaMagassag) {
        this.irany = irany;
        this.pozicioX = pozicioX;
        this.pozicioY = pozicioY;
        this.palyaSzelesseg = palyaSzelesseg;
        this.palyaMagassag = palyaMagassag;
    }

    /**
     * Ez az osztály üres felépítője.
     */
    public Lovedek() {

    }

    /**
     * A lövedék balra mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void balra(int lepes) {
        if (getPozicioX() > 0) {
            setPozicioX(getPozicioX() - lepes);
        }
    }

    /**
     * A lövedék jobbra mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void jobbra(int lepes) {
        if (getPozicioX() < (getPalyaSzelesseg() - getSzelesseg())) {
            setPozicioX(getPozicioX() + lepes);
        }
    }

    /**
     * A lövedék fel mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void fel(int lepes) {
        if (getPozicioY() > 0) {
            setPozicioY(getPozicioY() - lepes);
        }
    }

    /**
     * A lövedék le mozgásának metódusa.
     * @param lepes A lépések száma {@code int}.
     */
    public void le(int lepes) {
        if (getPozicioY() < (getPalyaMagassag() - getMagassag())) {
            setPozicioY(getPozicioY() + lepes);
        }
    }

    /**
     * A lövedék X pozíciójának a megszerzője.
     * @return A lövedék X pozíciója.
     */
    public int getPozicioX() {
        return pozicioX;
    }

    /**
     * A lövedék X pozíciójának a beállítója.
     * @param pozicioX A lövedék X pozíciója.
     */
    public void setPozicioX(int pozicioX) {
        this.pozicioX = pozicioX;
    }

    /**
     * A lövedék Y pozíciójának a megszerzője.
     * @return A lövedék Y pozíciója.
     */
    public int getPozicioY() {
        return pozicioY;
    }

    /**
     * A lövedék Y pozíciójának a beállítója.
     * @param pozicioY A lövedék Y pozíciója.
     */
    public void setPozicioY(int pozicioY) {
        this.pozicioY = pozicioY;
    }

    /**
     * A lövedék állapotának a megszerzője.
     * @return A lövedék állapota.
     */
    public boolean isHalott() {
        return halott;
    }

    /**
     * A lövedék állapotának a beállítója.
     * @param halott A lövedék állapota.
     */
    public void setHalott(boolean halott) {
        this.halott = halott;
    }

    /**
     * A lövedék irányának a megszerzője.
     * @return A lövedék iránya.
     */
    public String getIrany() {
        return irany;
    }

    /**
     * A lövedék irányának a beállítója.
     * @param irany A lövedék iránya.
     */
    public void setIrany(String irany) {
        this.irany = irany;
    }

    /**
     * A lövedék szélességének a megszerzője.
     * @return A lövedék szélessége.
     */
    public int getSzelesseg() {
        return szelesseg;
    }

    /**
     * A lövedék szélességének a beállítója.
     * @param szelesseg A lövedék szélessége.
     */
    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }

    /**
     * A lövedék magasságának a megszerzője.
     * @return A lövedék magassága.
     */
    public int getMagassag() {
        return magassag;
    }

    /**
     * A lövedék magasságának a beállítója.
     * @param magassag A lövedék magassága.
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
