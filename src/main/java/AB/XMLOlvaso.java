package ab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Az XMLOlvaso osztály olvassa be a meglévő adatbázis adatait
 */
public class XMLOlvaso {
    public ObservableList olvasas()
           throws ParserConfigurationException, SAXException, IOException {

        File bevitel = new File("Pontok.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document dokumentum = db.parse(bevitel);
        ObservableList<Eredmeny> eredmenyek = FXCollections.observableArrayList();
        NodeList csomopontLista = dokumentum.getElementsByTagName("eredmeny");

        for (int i = 0; i < csomopontLista.getLength(); i++){
            Eredmeny eredmeny = new Eredmeny();
            Node csomopont = csomopontLista.item(i);

            if (csomopont.getNodeType() == Node.ELEMENT_NODE){
                Element elem = (Element) csomopont;
                eredmeny.setNev(elem
                        .getElementsByTagName("nev")
                        .item(0)
                        .getTextContent());
                System.out.println(elem
                        .getElementsByTagName("nev")
                        .item(0)
                        .getTextContent());
                eredmeny.setPontszam(elem
                        .getElementsByTagName("pont")
                        .item(0)
                        .getTextContent());
                System.out.println(elem
                        .getElementsByTagName("pont")
                        .item(0)
                        .getTextContent());
            }
            eredmenyek.add(eredmeny);
        }
        return eredmenyek;
    }
}
