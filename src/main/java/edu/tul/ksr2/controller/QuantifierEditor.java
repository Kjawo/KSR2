package edu.tul.ksr2.controller;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.QuantifierSerialized;
import edu.tul.ksr2.Parameters.QuantifiersSerialized;
import edu.tul.ksr2.Parameters.TableView.QuantifierTableRow;
import edu.tul.ksr2.Parameters.XMLReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;

@Component
@FxmlView("QuantifierEditor.fxml")
public class QuantifierEditor {
    public TableView<QuantifierTableRow> tableView;
    public TableColumn<QuantifierTableRow, String> tableColumnName
            = new TableColumn<>("Name");
    public TableColumn<QuantifierTableRow, String> tableColumnMembership = new TableColumn<>("Membership function");
    public TableColumn<QuantifierTableRow, Boolean> tableColumnIsRelative = new TableColumn<>("is relative");
    public TableColumn<QuantifierTableRow, Double> tableColumnA = new TableColumn<>("a");
    public TableColumn<QuantifierTableRow, Double> tableColumnB = new TableColumn<>("b");
    public TableColumn<QuantifierTableRow, Double> tableColumnC = new TableColumn<>("c");
    public TableColumn<QuantifierTableRow, Double> tableColumnD = new TableColumn<>("d");
    public Button readSaved;
    public Button save;
    private ObservableList<QuantifierTableRow> quantifiersTableRowObservableList = FXCollections.observableArrayList();

    @FXML
    private TextField firstNameTextField;

    @FXML
    public void initialize() {
        try {

            initializeTable();
            setTableEditable();


            readSaved.setOnAction(
                    actionEvent -> {
                        populateTable();
                    }
            );
            save.setOnAction(
                    actionEvent -> {
                        saveQuantifiers();
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void saveQuantifiers() {
        ArrayList<QuantifierSerialized> quantifiersSerialized = new ArrayList<>();
        for(QuantifierTableRow quantifierTableRow : quantifiersTableRowObservableList)
        {
            quantifiersSerialized.add(new QuantifierSerialized(quantifierTableRow));
        }
        XMLReader.saveQuantifiers(new QuantifiersSerialized(quantifiersSerialized));
    }

    private void populateTable() {
        quantifiersTableRowObservableList.clear();
        try {
            for (Quantifier q : MainWindow.getQuantifiers()
            ) {
                quantifiersTableRowObservableList.add(new QuantifierTableRow(q));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeTable() {
        tableView.setPlaceholder(new Label("No rows to display"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnMembership.setCellValueFactory(new PropertyValueFactory<>("membership"));
        tableColumnIsRelative.setCellValueFactory(new PropertyValueFactory<>("isRelative"));
        tableColumnA.setCellValueFactory(new PropertyValueFactory<>("a"));
        tableColumnB.setCellValueFactory(new PropertyValueFactory<>("b"));
        tableColumnC.setCellValueFactory(new PropertyValueFactory<>("c"));
        tableColumnD.setCellValueFactory(new PropertyValueFactory<>("d"));

        tableColumnName.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnMembership.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnIsRelative.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        tableColumnA.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tableColumnB.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tableColumnC.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tableColumnD.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setItems(quantifiersTableRowObservableList);
        tableView.getColumns().addAll(tableColumnName, tableColumnMembership, tableColumnIsRelative,
                                            tableColumnA, tableColumnB, tableColumnC, tableColumnD);


        tableColumnName.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, String> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue())
        );
        tableColumnMembership.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, String> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMembership(t.getNewValue())
        );
        tableColumnIsRelative.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Boolean> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setIsRelative(t.getNewValue())
        );
        tableColumnA.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setA(t.getNewValue())
        );
        tableColumnB.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setB(t.getNewValue())
        );
        tableColumnC.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setC(t.getNewValue())
        );
        tableColumnD.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setD(t.getNewValue())
        );
    }

    private void setTableEditable() {
        tableView.setEditable(true);
        // allows the individual cells to be selected
        tableView.getSelectionModel().cellSelectionEnabledProperty().set(true);
        tableColumnMembership.setEditable(true);
    }


}
