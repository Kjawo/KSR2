package edu.tul.ksr2.controller;

import edu.tul.ksr2.Database.DatabaseHandler;
import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

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

            prepareSpinner();

            System.out.println("LoL - Leauge of Legends");
            System.out.println(gameEntities.get(0).toString());
            ArrayList<Quantifier> quantifiers = XMLReader.readQuantifier();
//            for (Quantifier q : quantifiers) {
//                System.out.println(q.generateLatexSubsection());
//            }
            System.out.println(quantifiers.get(0).toString());

            ArrayList<LinguisticVariable> linguisticVariables = XMLReader.readLinguisicVariables();
//            for (LinguisticVariable l: linguisticVariables
//                 ) {
//                System.out.println(l.generateLatexSubsection());
//            }


            generateSummarizationForAll();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }

    public void generateComparison(){
        Summarizer summarizer = new Summarizer(spinnerFirstVar.getSelectionModel().getSelectedItem().toString());
        summarizer.loadData(gameEntities);
    }

    private void generateSummarizationForAll() {

        for(String p : ParametersMapper.keySet()) {
            Summarizer summarizer = new Summarizer(p);
            summarizer.loadData(gameEntities);
        }

    }

    private void prepareSpinner() {
        spinnerFirstVar.getItems().addAll(ParametersMapper.keySet());
        spinnerFirstVar.getSelectionModel().select(ParametersMapper.keySet().toArray()[0]);
    }
}