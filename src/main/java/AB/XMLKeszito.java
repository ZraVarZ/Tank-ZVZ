package ab;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Az XMLKeszito osztály készíti el az új adatbázist.
 */
public class XMLKeszito {

    /**
     * A keszites metódus hozza létre szükség esetén az új fájlt, meglévő
     * esetén pedig hozzáilleszt.
     * @param megadottnev A játékban megadott név.
     * @param szerzettpont A játékban szerzett pont.
     */
    public void keszites(String megadottnev, Integer szerzettpont) {
        File bevitel = new File("Pontok.xml");
        if (bevitel.exists() && !bevitel.isDirectory()) {
            try {
                XMLHozzaado hozzaado = new XMLHozzaado();
                hozzaado.hozzaadas(megadottnev, szerzettpont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                DocumentBuilderFactory dbf =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document dokumentum = db.newDocument();

                Element gyoker = dokumentum.createElement("eredmenyek");
                dokumentum.appendChild(gyoker);

                Element eredmeny = dokumentum.createElement("eredmeny");
                gyoker.appendChild(eredmeny);

                Element nev = dokumentum.createElement("nev");
                nev.appendChild(dokumentum.createTextNode(megadottnev));
                eredmeny.appendChild(nev);

                Element pont = dokumentum.createElement("pont");
                pont.appendChild(dokumentum.createTextNode(szerzettpont.toString()));
                eredmeny.appendChild(pont);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer osszefuzes = tf.newTransformer();

                DOMSource forras = new DOMSource(dokumentum);
                StreamResult veglet = new StreamResult(new File("Pontok.xml"));

                osszefuzes.setOutputProperty(OutputKeys.INDENT, "yes");
                osszefuzes.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                osszefuzes.transform(forras, veglet);

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }
}
