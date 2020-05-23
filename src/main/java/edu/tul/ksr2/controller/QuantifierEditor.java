package edu.tul.ksr2.controller;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.Parameters.QuantifierSerialized;
import edu.tul.ksr2.Parameters.QuantifiersSerialized;
import edu.tul.ksr2.Parameters.TableView.QuantifierTableRow;
import edu.tul.ksr2.Parameters.XMLReader;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
@FxmlView("QuantifierEditor.fxml")
public class QuantifierEditor {
    final XYChart.Series<Double, Double> series = new XYChart.Series<>();
    public TableView<QuantifierTableRow> tableView;
    public TableColumn<QuantifierTableRow, String> tableColumnName
            = new TableColumn<>("Name");
    public TableColumn<QuantifierTableRow, StringProperty> tableColumnMembership = new TableColumn<>("Membership function");
    ObservableList<String> membershipOptions = FXCollections.observableArrayList(
            "Trapezoidal",
            "Triangular"
    );

    public TableColumn<QuantifierTableRow, Boolean> tableColumnIsRelative = new TableColumn<>("is relative");
    public TableColumn<QuantifierTableRow, Double> tableColumnA = new TableColumn<>("a");
    public TableColumn<QuantifierTableRow, Double> tableColumnB = new TableColumn<>("b");
    public TableColumn<QuantifierTableRow, Double> tableColumnC = new TableColumn<>("c");
    public TableColumn<QuantifierTableRow, Double> tableColumnD = new TableColumn<>("d");
    public Button readSaved;
    public Button save;
    public LineChart lineChart;
    public Button addRow;
    public Button removeRow;
    public Button plotFunction;
    private ObservableList<QuantifierTableRow> quantifiersTableRowObservableList = FXCollections.observableArrayList();
    @FXML
    private TextField firstNameTextField;

    @FXML
    public void initialize() {
        try {

            initializeTable();
            setTableEditable();

            series.setName("Membership function");
            lineChart.getData().add(series);
            lineChart.setCreateSymbols(false);

            populateTable();

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
            addRow.setOnAction(
                    actionEvent -> {
                        quantifiersTableRowObservableList.add(new QuantifierTableRow("New quantifier name", "Trapezoidal", true, 0, 0, 0, 0));
                    }
            );
            removeRow.setOnAction(
                    actionEvent -> {
                        QuantifierTableRow selectedItem = tableView.getSelectionModel().getSelectedItem();
                        quantifiersTableRowObservableList.remove(selectedItem);
                    }
            );
            plotFunction.setOnAction(
                    actionEvent -> {
                        plotSelected();
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void plotSelected() {

        QuantifierTableRow selectedItem = tableView.getSelectionModel().getSelectedItem();
        MembershipFunction membershipFunction = selectedItem.getMembershipFunction();

        ArrayList<Double> parameters = new ArrayList<>();
        parameters.add(membershipFunction.getA());
        parameters.add(membershipFunction.getB());
        parameters.add(membershipFunction.getC());
        parameters.add(membershipFunction.getD());

        double min = Collections.min(parameters);
        double max = Collections.max(parameters);

        plotLine(membershipFunction, max - min, min, max);


    }

    public void plotLine(final MembershipFunction function, double range, double min, double max) {
        series.getData().clear();
        for (double x = min - 0.1 * range; x <= max + 0.1 * range; x = x + range / 100) {
            plotPoint(x, function.compute(x), series);
        }
    }

    private void plotPoint(final double x, final double y,
                           final XYChart.Series<Double, Double> series) {
        series.getData().add(new XYChart.Data<Double, Double>(x, y));
    }

    public void clear() {
        lineChart.getData().clear();
    }

    private void saveQuantifiers() {
        ArrayList<QuantifierSerialized> quantifiersSerialized = new ArrayList<>();
        for (QuantifierTableRow quantifierTableRow : quantifiersTableRowObservableList) {
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
//        tableColumnMembership.setCellValueFactory(new PropertyValueFactory<>("membership"));
        tableColumnIsRelative.setCellValueFactory(new PropertyValueFactory<>("isRelative"));
        tableColumnA.setCellValueFactory(new PropertyValueFactory<>("a"));
        tableColumnB.setCellValueFactory(new PropertyValueFactory<>("b"));
        tableColumnC.setCellValueFactory(new PropertyValueFactory<>("c"));
        tableColumnD.setCellValueFactory(new PropertyValueFactory<>("d"));


        tableColumnMembership.setCellValueFactory(i -> {
            final StringProperty value = i.getValue().getMembership();
            // binding to constant value
            return Bindings.createObjectBinding(() -> value);
        });

        tableColumnMembership.setCellFactory(col -> {
            TableCell<QuantifierTableRow, StringProperty> c = new TableCell<>();


            final ComboBox<String> comboBox = new ComboBox<>(membershipOptions);
            c.itemProperty().addListener((observable, oldValue, newValue) -> {
                if (oldValue != null) {
                    comboBox.valueProperty().unbindBidirectional(oldValue);
                }
                if (newValue != null) {
                    comboBox.valueProperty().bindBidirectional(newValue);
                }
            });
            c.graphicProperty().bind(Bindings.when(c.emptyProperty()).then((Node) null).otherwise(comboBox));
            return c;
        });

        tableColumnName.setCellFactory(TextFieldTableCell.forTableColumn());
//        tableColumnMembership.setCellFactory(TextFieldTableCell.forTableColumn());
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
                (TableColumn.CellEditEvent<QuantifierTableRow, StringProperty> t) ->
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
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setA(t.getNewValue());
                    plotSelected();
                }
        );
        tableColumnB.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setB(t.getNewValue());
                    plotSelected();
                }
        );
        tableColumnC.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setC(t.getNewValue());
                    plotSelected();
                }
        );
        tableColumnD.setOnEditCommit(
                (TableColumn.CellEditEvent<QuantifierTableRow, Double> t) ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setD(t.getNewValue());
                    plotSelected();
                }
        );
    }

    private void setTableEditable() {
        tableView.setEditable(true);
        // allows the individual cells to be selected
        tableView.getSelectionModel().cellSelectionEnabledProperty().set(true);
        tableColumnMembership.setEditable(true);
    }


}
