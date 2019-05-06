package model;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

public class JSONOlvaso {
    public JSONOlvaso(){

    }

 /*   public void olvasas(){
        JSONParser olvasott = new JSONParser();

        try {
            Object objekt = olvasott.parse(new FileReader("Pontok.json"));
            JSONObject jsonObject = (JSONObject) objekt;
            String nev = (String) jsonObject.get("nev");
            System.out.println(nev);
            Integer pont = (Integer) jsonObject.get("pont");
            System.out.println(" " + pont);

            JSONArray eredmenyekArray = (JSONArray) jsonObject.get("eredmenyek");
            Iterator<Object> iterator = eredmenyekArray.iterator();
            while (iterator.hasNext()){
                System.out.println("eredmeny: " + iterator.next());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
