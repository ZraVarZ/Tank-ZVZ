package model;

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

import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseUnsignedInt;

public class XMLOlvaso {
    public ObservableList olvasas() throws ParserConfigurationException, SAXException, IOException{

        File input = new File("Pontok.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(input);
        ObservableList<Eredmeny> eredmenyek = FXCollections.observableArrayList();
        NodeList nodeList = document.getElementsByTagName("eredmeny");

        int j = 1;
        for (int i = 0; i < nodeList.getLength(); i++){
            Eredmeny eredmeny = new Eredmeny();
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                eredmeny.setNev(element
                        .getElementsByTagName("nev")
                        .item(0)
                        .getTextContent());
                System.out.println(element
                        .getElementsByTagName("nev")
                        .item(0)
                        .getTextContent());
                eredmeny.setPontszam(element
                        .getElementsByTagName("pont")
                        .item(0)
                        .getTextContent());
                System.out.println(element
                        .getElementsByTagName("pont")
                        .item(0)
                        .getTextContent());

            }
            eredmenyek.add(eredmeny);
        }
        return eredmenyek;


   /*     for (int i = 0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                System.out.println("Név: "+element.getElementsByTagName("nev").item(0).getTextContent());
                System.out.println("Pont: "+element.getElementsByTagName("pont").item(0).getTextContent());
            }
        }

        System.out.println(document.getDocumentElement().getNodeName());*/
    }
}
