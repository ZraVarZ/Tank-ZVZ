package ab;

import javafx.beans.property.SimpleStringProperty;

/**
 * Az Eredmeny osztály jelenti az adatbázist feltöltö eredményeket.
 */
public class Eredmeny {

    /**
     * Ez a változó tartalmazza az eredményhez tartozó nevet.
     */
    private final SimpleStringProperty nev;

    /**
     * Ez a változó tartalmazza az eredményhez tartozó pontszámot.
     */
    private final SimpleStringProperty pontszam;

    /**
     * Az Eredmény osztály felépítője.
     * @param nev Az eredményhez tartozó név.
     * @param pontszam Az eredményhez tartozó pontszám.
     */
    public Eredmeny(String nev, Integer pontszam) {
        this.nev = new SimpleStringProperty(nev);
        this.pontszam = new SimpleStringProperty(pontszam.toString());
    }

    /**
     * Az eredmény osztály üres felépítője.
     */
    public Eredmeny() {
        this("", 0);
    }

    /**
     * Ez a név megszerzője.
     * @return A nevet.
     */
    public String getNev() {
        return nev.get();
    }

    /**
     * Ez a név másik megszerzője.
     * @return A nevet.
     */
    public SimpleStringProperty nevProperty() {
        return nev;
    }

    /**
     * Ez a név beállítója.
     * @param nev A nevet.
     */
    public void setNev(String nev) {
        this.nev.set(nev);
    }

    /**
     * Ez a pontszám megszerzője.
     * @return A pontszámot.
     */
    public String getPontszam() {
        return pontszam.get();
    }

    /**
     * Ez a pontszám másik megszerzője.
     * @return A pontszámot.
     */
    public SimpleStringProperty pontszamProperty() {
        return pontszam;
    }

    /**
     * Ez a pontszám beállítója.
     * @param pontszam A pontszámot.
     */
    public void setPontszam(String pontszam) {
        this.pontszam.set(pontszam);
    }
}
