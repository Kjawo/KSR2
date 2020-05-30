package edu.tul.ksr2.controller;

import edu.tul.ksr2.Database.DatabaseHandler;
import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;
import edu.tul.ksr2.Summary.SummarizationObject;
import edu.tul.ksr2.Summary.SummaryGenerator;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
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

    public TableView<Summarizer> summarizerTableView;
    public TableColumn<Summarizer, String> summarizerColumnValue = new TableColumn<>("Name");

    public TableView<SummarizationObject> tableView;
    public TableColumn<SummarizationObject, String> tableColumnText
            = new TableColumn<>("Summarization");
    public TableColumn<SummarizationObject, String> tableColumnT1 = new TableColumn<>("T1");
    public TableColumn<SummarizationObject, String> tableColumnT2 = new TableColumn<>("T2");
    public TableColumn<SummarizationObject, String> tableColumnT3 = new TableColumn<>("T3");
    public TableColumn<SummarizationObject, String> tableColumnT4 = new TableColumn<>("T4");
    public TableColumn<SummarizationObject, String> tableColumnT5 = new TableColumn<>("T5");
    public TableColumn<SummarizationObject, String> tableColumnT6 = new TableColumn<>("T6");
    public TableColumn<SummarizationObject, String> tableColumnT7 = new TableColumn<>("T7");
    public TableColumn<SummarizationObject, String> tableColumnT8 = new TableColumn<>("T8");
    public TableColumn<SummarizationObject, String> tableColumnT9 = new TableColumn<>("T9");
    public TableColumn<SummarizationObject, String> tableColumnT10 = new TableColumn<>("T10");
    public TableColumn<SummarizationObject, String> tableColumnT11 = new TableColumn<>("T11");
    public ComboBox summarizersComboBox;
    public ComboBox qualifiersComboBox;
    public Button addSummarizer;
    public Button removeSummarizer;
    public CheckBox useQualifierCheckBox;
    private ObservableList<SummarizationObject> summarizationsObservableList = FXCollections.observableArrayList();
    private HashMap<String, Summarizer> summarizers = new HashMap<>();
    private ObservableList<Summarizer> summarizersObservableList = FXCollections.observableArrayList();;


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
            prepareSummarizersTable();

//            generateSummarizationForAll();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );

        addSummarizer.setOnAction(
                actionEvent -> {
                    summarizersObservableList.addAll((Summarizer) summarizersComboBox.getSelectionModel().getSelectedItem());
                }
        );

        removeSummarizer.setOnAction(
                actionEvent -> {
                    Summarizer selectedItem = summarizerTableView.getSelectionModel().getSelectedItem();
                    summarizersObservableList.remove(selectedItem);
                }
        );
    }

    private void prepareSummarizersTable() {
        summarizerTableView.setPlaceholder(new Label("No rows to display"));
        summarizerColumnValue.setCellValueFactory(new PropertyValueFactory<>("tableValue"));

        summarizerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        summarizerTableView.getColumns().add(summarizerColumnValue);

        summarizerTableView.setItems(summarizersObservableList);
    }


    private void prepareTable() {
        tableView.setPlaceholder(new Label("No rows to display"));
        tableColumnText.setCellValueFactory(new PropertyValueFactory<>("Text"));
        tableColumnT1.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT1()));
        tableColumnT2.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT2()));
        tableColumnT3.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT3()));
        tableColumnT4.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT4()));
        tableColumnT5.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT5()));
        tableColumnT6.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT6()));
        tableColumnT7.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT7()));
        tableColumnT8.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT8()));
        tableColumnT9.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT9()));
        tableColumnT10.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT10()));
        tableColumnT11.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getT11()));

//        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableColumnText.prefWidthProperty().bind(tableView.widthProperty().divide(1.0 / 0.55));
        tableColumnT1.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT2.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT3.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT4.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT5.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT6.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT7.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT8.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT9.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT10.prefWidthProperty().bind(tableView.widthProperty().divide(25));
        tableColumnT11.prefWidthProperty().bind(tableView.widthProperty().divide(25));

        tableView.setItems(summarizationsObservableList);
        tableView.getColumns().addAll(tableColumnText,
                tableColumnT1,
                tableColumnT2,
                tableColumnT3,
                tableColumnT4,
                tableColumnT5,
                tableColumnT6,
                tableColumnT7,
                tableColumnT8,
                tableColumnT9,
                tableColumnT10,
                tableColumnT11
                );

        tableColumnT1.setComparator(tableColumnT1.getComparator().reversed());
        tableView.getSortOrder().add(tableColumnT1);
    }

    public void generateSummarizationFirstType(){
        summarizationsObservableList.clear();
        summarizationsObservableList.addAll(SummaryGenerator.generateFirstTypeSummarization(gameEntities, getQuantifiers(),
               new ArrayList<>(summarizersObservableList)));
        tableView.getSortOrder().add(tableColumnT1);
    }

    public void generateSummarizationSecondType(ActionEvent actionEvent) {
        summarizationsObservableList.clear();
        summarizationsObservableList.addAll(SummaryGenerator.generateSecondTypeSummarization(gameEntities, getQuantifiers(), getQualifier(),
                new ArrayList<>(summarizersObservableList), useQualifierCheckBox.isSelected()));
        tableView.getSortOrder().add(tableColumnT1);
    }

    private Summarizer getQualifier() {
        return (Summarizer) qualifiersComboBox.getSelectionModel().getSelectedItem();
    }

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

        summarizersComboBox.getItems().clear();
        summarizersComboBox.getItems().addAll(getSelectedLinguisticVariable().getSummarizers(
                spinnerFirstVar.getSelectionModel().getSelectedItem().toString()
        ));
        summarizersComboBox.getSelectionModel().select(0);

        qualifiersComboBox.getItems().clear();
        qualifiersComboBox.getItems().addAll(getSelectedLinguisticVariable().getSummarizers(
                spinnerFirstVar.getSelectionModel().getSelectedItem().toString()
        ));
        qualifiersComboBox.getSelectionModel().select(0);
    }

    public void comboActionLV(ActionEvent actionEvent) {
        summarizersComboBox.getItems().clear();
        summarizersComboBox.getItems().addAll(getSelectedLinguisticVariable().getSummarizers(
                spinnerFirstVar.getSelectionModel().getSelectedItem().toString()
        ));
        summarizersComboBox.getSelectionModel().select(0);

        qualifiersComboBox.getItems().clear();
        qualifiersComboBox.getItems().addAll(getSelectedLinguisticVariable().getSummarizers(
                spinnerFirstVar.getSelectionModel().getSelectedItem().toString()
        ));
        qualifiersComboBox.getSelectionModel().select(0);
    }


}