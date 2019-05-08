package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Eredmeny;
import model.XMLOlvaso;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoMenuController implements Initializable {

    @FXML
    private AnchorPane mindennekAzAlapja;

    @FXML
    private Pane alapMenuPane;

    @FXML
    private Pane adjMegNevetPane;

    @FXML
    private Pane eredmenyekPane;

    @FXML
    private Button kezdesButton;

    @FXML
    private Button eredmenyekButton;

    @FXML
    private Button kilepesButton;

    @FXML
    private Button adjMegNevetButton;

    @FXML
    private TextField adjMegNevetTextField;

    @FXML
    private Button eredmenyekExitButton;

    @FXML
    private TableView tablazat;

    public String megadottnev;


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
        }
    }

    public void kezdesB(ActionEvent event){
        System.out.println("a hacsa kápog");
        JatekController jatszunkEgyJatekot = new JatekController();
        jatszunkEgyJatekot.jatekLetrehozasa(megadottnev);
    }

    public void eredmenyekB(ActionEvent event){
        tablazatFeltoltes();
        alapMenuPane.setOpacity(0.5);
        alapMenuPane.setDisable(true);
        eredmenyekPane.setVisible(true);
    }

    public void handleEredmenyekExitButton(ActionEvent event){
        alapMenuPane.setOpacity(1.0);
        alapMenuPane.setDisable(false);
        eredmenyekPane.setVisible(false);
    }

    public void kilepesB(ActionEvent event){
        System.out.println("Kilepes...");
        System.exit(0);
    }

    private ObservableList<Eredmeny> eredmenyek = FXCollections.observableArrayList(

    );

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

    //    eredmenyek = eredmenyek.sorted(Comparator.comparing(Integer.valueOf( Eredmeny::getPontszam)));

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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("szevasz");
    }
}
