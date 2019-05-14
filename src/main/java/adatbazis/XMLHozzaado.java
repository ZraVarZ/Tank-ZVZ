package adatbazis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * A XMLHozzaado osztály képes egy meglévő adatbázishoz új sort hozzáfűzni.
 */
public class XMLHozzaado {

    /**
     * A hozzaadas metódus adja hozzá az adatbázishoz az új sort.
     * @param megadottnev A játékban megadott név.
     * @param szerzettpont A játékban szerzett pont.
     * @throws Exception Kivételek korábban kezelve.
     */
    public void hozzaadas(String megadottnev, Integer szerzettpont)
            throws Exception {
        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder dB = dBF.newDocumentBuilder();
        Document dokumentum = dB.parse("Pontok.xml");

        Element gyoker = dokumentum.getDocumentElement();

        Element ujEredmeny = dokumentum.createElement("eredmeny");
        gyoker.appendChild(ujEredmeny);

        Element ujNev = dokumentum.createElement("nev");
        ujNev.appendChild(dokumentum.createTextNode(megadottnev));
        ujEredmeny.appendChild(ujNev);

        Element ujPont = dokumentum.createElement("pont");
        ujPont.appendChild(dokumentum.createTextNode(szerzettpont.toString()));
        ujEredmeny.appendChild(ujPont);

        TransformerFactory tF = TransformerFactory.newInstance();
        Transformer osszefuzes = tF.newTransformer();

        DOMSource forras = new DOMSource(dokumentum);
        StreamResult eredmeny = new StreamResult("Pontok.xml");

        osszefuzes.setOutputProperty(OutputKeys.INDENT, "yes");
        osszefuzes.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4"
        );
        osszefuzes.transform(forras, eredmeny);
    }
}
