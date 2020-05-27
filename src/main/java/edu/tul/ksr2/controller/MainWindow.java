package edu.tul.ksr2.controller;

import edu.tul.ksr2.Database.DatabaseHandler;
import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;
import edu.tul.ksr2.Summary.FirstTypeSummarizationObject;
import edu.tul.ksr2.Summary.SummaryGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.CheckComboBox;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import static edu.tul.ksr2.LinguisticVariable.ParametersMapping.ParametersMapper;

@Component
@FxmlView("MainWindow.fxml")
public class MainWindow {

    private final FxControllerAndView<SomeDialog, VBox> someDialog;
    public ArrayList<GameEntity> gameEntities;
    private static ArrayList<Quantifier> quantifiers;
    private static ArrayList<LinguisticVariable> linguisticVariables;

    @FXML
    public Button openDialogButton;
    public Button generateComparison;
    public ComboBox spinnerFirstVar;
    public TableView<FirstTypeSummarizationObject> tableView;
    public TableColumn<FirstTypeSummarizationObject, String> tableColumnText
            = new TableColumn<>("Summarization");
    public TableColumn<FirstTypeSummarizationObject, Double> tableColumnT1 = new TableColumn<>("T");
    private ObservableList<FirstTypeSummarizationObject> summarizationsObservableList = FXCollections.observableArrayList();
    private HashMap<String, Summarizer> summarizers = new HashMap<>();



    public MainWindow(FxControllerAndView<SomeDialog, VBox> someDialog) {
        this.someDialog = someDialog;
    }

    public static ArrayList<Quantifier> getQuantifiers() {
        setQuantifiers(XMLReader.readQuantifier());
        return quantifiers;
    }

    public static void setQuantifiers(ArrayList<Quantifier> quantifiers) {
        MainWindow.quantifiers = quantifiers;
    }

    public static ArrayList<LinguisticVariable> getLinguisticVariables() {
        setLinguisticVariables(XMLReader.readLinguisicVariables());
        return linguisticVariables;
    }

    public static void setLinguisticVariables(ArrayList<LinguisticVariable> linguisticVariables) {
        MainWindow.linguisticVariables = linguisticVariables;
    }

    @FXML
    public void initialize() {
        try {

            DatabaseHandler.initialize();
            gameEntities = DatabaseHandler.loadAllFromDB();

            prepareSpinner();

            System.out.println("LoL - Leauge of Legends");
            System.out.println(gameEntities.get(0).toString());
            setQuantifiers(XMLReader.readQuantifier());
//            for (Quantifier q : quantifiers) {
//                System.out.println(q.generateLatexSubsection());
//            }
            System.out.println(getQuantifiers().get(0).toString());

            linguisticVariables = XMLReader.readLinguisicVariables();
//            for (LinguisticVariable l: linguisticVariables
//                 ) {
//                System.out.println(l.generateLatexSubsection());
//            }

            prepareTable();

//            generateSummarizationForAll();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }



    private void prepareTable() {
        tableView.setPlaceholder(new Label("No rows to display"));
        tableColumnText.setCellValueFactory(new PropertyValueFactory<>("Text"));
        tableColumnT1.setCellValueFactory(new PropertyValueFactory<>("T1"));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setItems(summarizationsObservableList);
        tableView.getColumns().addAll(tableColumnText, tableColumnT1);
    }

    public void generateComparison(){
        summarizationsObservableList.clear();
//        summarizationsObservableList.addAll(SummaryGenerat\or.summarizeAmmounts(spinnerFirstVar.getSelectionModel().getSelectedItem().toString(), quantifiers, gameEntities));
        summarizationsObservableList.addAll(SummaryGenerator.generateFirstTypeSummarization(gameEntities, getQuantifiers(),
                getSelectedLinguisticVariable().getSummarizers(
                        spinnerFirstVar.getSelectionModel().getSelectedItem().toString()
                )));

    }

//    private void generateSummarizationForAll() {
//
//        for(String p : ParametersMapper.keySet()) {
//            Summarizer summarizer = new Summarizer(p);
//            summarizer.loadData(gameEntities);
//
//        }
//
//    }

    private LinguisticVariable getSelectedLinguisticVariable() {
        String LVname = spinnerFirstVar.getSelectionModel().getSelectedItem().toString();
        LVname =  ParametersMapper.get(LVname);
        LinguisticVariable selectedLV = linguisticVariables.get(0);

        for(LinguisticVariable lv : linguisticVariables) {
            if(lv.getName().equals(LVname)) {
                selectedLV = lv;
                return selectedLV;
            }
        }
        return selectedLV;
    }

    private void prepareSpinner() {
        spinnerFirstVar.getItems().addAll(ParametersMapper.keySet());
        spinnerFirstVar.getSelectionModel().select(ParametersMapper.keySet().toArray()[0]);
    }
}