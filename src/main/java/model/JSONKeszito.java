package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONKeszito {
    private String megadottNev;
    private Integer szerzettPont;
    public JSONKeszito(String megadottNev, Integer szerzettPont){
        this.megadottNev = megadottNev;
        this.szerzettPont = szerzettPont;
    }

    public void keszites(){
        JSONObject foObjekt = new JSONObject();
        JSONObject objekt = new JSONObject();
        JSONArray lista = new JSONArray();
        objekt.put("nev", getMegadottNev());
        objekt.put("pont", getSzerzettPont());
        lista.put(objekt);
        foObjekt.put("eredmenyek", lista);


        try(FileWriter fajl = new FileWriter("Pontok.json", true)) {
            fajl.write(foObjekt.toString());
            fajl.flush();
            fajl.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(objekt);
    }

    public String getMegadottNev() {
        return megadottNev;
    }

    public void setMegadottNev(String megadottNev) {
        this.megadottNev = megadottNev;
    }

    public Integer getSzerzettPont() {
        return szerzettPont;
    }

    public void setSzerzettPont(Integer szerzettPont) {
        this.szerzettPont = szerzettPont;
    }
}
