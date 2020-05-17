package edu.tul.ksr2.controller;

import edu.tul.ksr2.Database.DatabaseHandler;
import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Qualifier;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.tul.ksr2.LinguisticVariable.ParametersMapping.ParametersMapper;

@Component
@FxmlView("MainWindow.fxml")
public class MainWindow {

    private final FxControllerAndView<SomeDialog, VBox> someDialog;
    public ArrayList<GameEntity> gameEntities;

    @FXML
    public Button openDialogButton;
    public Button generateComparison;
    public ComboBox spinnerFirstVar;



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
            ArrayList<Quantifier> quantifiers = XMLReader.readQuantifier();
            System.out.println(quantifiers.get(0).toString());

            ArrayList<LinguisticVariable> linguisticVariables = XMLReader.readLinguisicVariables();
//            for (LinguisticVariable l: linguisticVariables
//                 ) {
//                System.out.println(l.generateLatexSubsection());
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }

    public void generateComparison(){
        Qualifier qualifier = new Qualifier("blueDragonKills");
        qualifier.loadData(gameEntities);
    }

}