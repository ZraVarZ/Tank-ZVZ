package AB;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLKeszito {
    public void keszites(String megadottnev, Integer szerzettpont) {
        File input = new File("Pontok.xml");
        if (input.exists() && !input.isDirectory()) {
            try {
                XMLHozzaado hozzaado = new XMLHozzaado();
                hozzaado.hozzaadas(megadottnev, szerzettpont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.newDocument();

                Element root = document.createElement("eredmenyek");
                document.appendChild(root);

                Element eredmeny = document.createElement("eredmeny");
                root.appendChild(eredmeny);

                Element nev = document.createElement("nev");
                nev.appendChild(document.createTextNode(megadottnev));
                eredmeny.appendChild(nev);

                Element pont = document.createElement("pont");
                pont.appendChild(document.createTextNode(szerzettpont.toString()));
                eredmeny.appendChild(pont);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File("Pontok.xml"));

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                transformer.transform(source, result);

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
