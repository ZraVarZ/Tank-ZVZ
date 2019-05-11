package AB;

import javafx.beans.property.SimpleStringProperty;

public class Eredmeny {
    private final SimpleStringProperty nev;
    private final SimpleStringProperty pontszam;

    public Eredmeny(String nev, Integer pontszam){
        this.nev = new SimpleStringProperty(nev);
        this.pontszam = new SimpleStringProperty(pontszam.toString());
    }

    public Eredmeny(){
        this("",0);
    }

    public String getNev() {
        return nev.get();
    }

    public SimpleStringProperty nevProperty() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public String getPontszam() {
        return pontszam.get();
    }

    public SimpleStringProperty pontszamProperty() {
        return pontszam;
    }

    public void setPontszam(String pontszam) {
        this.pontszam.set(pontszam);
    }
}
