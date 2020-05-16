package edu.tul.ksr2.controller;

import edu.tul.ksr2.Database.DatabaseHandler;
import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
@FxmlView("MainWindow.fxml")
public class MainWindow {

    private final FxControllerAndView<SomeDialog, VBox> someDialog;
    public ArrayList<GameEntity> gameEntities;

    @FXML
    public Button openDialogButton;
    public Button generateComparison;



    public MainWindow(FxControllerAndView<SomeDialog, VBox> someDialog) {
        this.someDialog = someDialog;
    }

    @FXML
    public void initialize() {
        try {
            DatabaseHandler.initialize();
            gameEntities = DatabaseHandler.loadAllFromDB();
            System.out.println("LoL - Leauge of Legends");
            System.out.println(gameEntities.get(0).toString());

            ArrayList<Quantifier> quantifiers = XMLReader.read("Quantifiers.xml", false);
            System.out.println(quantifiers.get(0).toString());

            ArrayList<Quantifier> gameQuantifiers = XMLReader.read("MembershipParameters.xml", true);
            System.out.println(gameQuantifiers.get(0).toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }


        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }

    public void generateComparison(){
        System.out.println("ASAFASFas");
        LinguisticVariable linguisticVariable = new LinguisticVariable("gameDuraton");
        linguisticVariable.loadData(gameEntities);
    }

}