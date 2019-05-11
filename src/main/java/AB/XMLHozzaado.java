package AB;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLHozzaado {
    public void hozzaadas(String megadottnev, Integer szerzettpont) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("Pontok.xml");

        Element root = document.getDocumentElement();

        Element ujEredmeny = document.createElement("eredmeny");
        root.appendChild(ujEredmeny);

        Element ujNev = document.createElement("nev");
        ujNev.appendChild(document.createTextNode(megadottnev));
        ujEredmeny.appendChild(ujNev);

        Element ujPont = document.createElement("pont");
        ujPont.appendChild(document.createTextNode(szerzettpont.toString()));
        ujEredmeny.appendChild(ujPont);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult("Pontok.xml");

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }
}
