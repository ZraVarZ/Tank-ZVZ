package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import adatbazis.Eredmeny;
import adatbazis.XMLOlvaso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoMenuController implements Initializable {

    @FXML
    private Pane alapMenuPane;

    @FXML
    private Pane adjMegNevetPane;

    @FXML
    private Pane eredmenyekPane;

    @FXML
    private TextField adjMegNevetTextField;

    @FXML
    private TableView tablazat;

    public String megadottnev;

    Logger NAPLOZAS = LoggerFactory.getLogger(FoMenuController.class);

    public void handleAdjMegNevetButton(ActionEvent event){
        String nevellenorzes = adjMegNevetTextField.getText();
        nevellenorzes = nevellenorzes.replaceAll("\\s+","");
        if (nevellenorzes.equals("")){

        }
        else {
            megadottnev = nevellenorzes;
            adjMegNevetPane.setVisible(false);
            alapMenuPane.setOpacity(1);
            alapMenuPane.setDisable(false);
            NAPLOZAS.info("meg lett adva a nev");
        }
    }

    public void kezdesB(ActionEvent event){
        System.out.println("a hacsa kápog");
        JatekController jatszunkEgyJatekot = new JatekController();
        jatszunkEgyJatekot.jatekLetrehozasa(megadottnev);
        NAPLOZAS.info("a hacsa kapog /alias/ elindult a jatek");
    }

    public void eredmenyekB(ActionEvent event){
        File bevitel = new File("Pontok.xml");
        if (bevitel.exists() && !bevitel.isDirectory()){
            tablazatFeltoltes();
            alapMenuPane.setOpacity(0.5);
            alapMenuPane.setDisable(true);
            eredmenyekPane.setVisible(true);
            NAPLOZAS.info("eredmenyek lekerdezve");
        }
    }

    public void handleEredmenyekExitButton(ActionEvent event){
        alapMenuPane.setOpacity(1.0);
        alapMenuPane.setDisable(false);
        eredmenyekPane.setVisible(false);
    }

    public void kilepesB(ActionEvent event){
        NAPLOZAS.info("Kilepes a jatekbol");
        System.out.println("Kilepes...");
        System.exit(0);
    }

    private ObservableList<Eredmeny> eredmenyek = FXCollections.observableArrayList();

    public void tablazatFeltoltes()
    {
        XMLOlvaso olvaso = new XMLOlvaso();
        try {
            eredmenyek = olvaso.olvasas();
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        TableColumn nev = new TableColumn("Név");
        nev.setMinWidth(210);
        nev.setMaxWidth(219);
        nev.setCellFactory(TextFieldTableCell.forTableColumn());
        nev.setCellValueFactory(new PropertyValueFactory<Eredmeny, String>("nev"));

        TableColumn pontszam = new TableColumn("Pontszám");
        pontszam.setMinWidth(210);
        pontszam.setMaxWidth(219);
        pontszam.setCellFactory(TextFieldTableCell.forTableColumn());
        pontszam.setCellValueFactory(new PropertyValueFactory<Eredmeny, String>("pontszam"));

        tablazat.getColumns().addAll(nev, pontszam);
        tablazat.setItems(eredmenyek);
        NAPLOZAS.info("tablazat feltoltve");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        NAPLOZAS.info("inicializalva");
        System.out.println("szevasz");
    }
}
