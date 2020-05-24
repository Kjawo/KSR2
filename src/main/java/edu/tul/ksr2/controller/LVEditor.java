package edu.tul.ksr2.controller;

import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.Parameters.*;
import edu.tul.ksr2.Parameters.TableView.LVTableRow;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

import static edu.tul.ksr2.LinguisticVariable.ParametersMapping.ParametersMapper;

@Component
@FxmlView("QuantifierEditor.fxml")
public class LVEditor {
    final XYChart.Series<Double, Double> series = new XYChart.Series<>();
    public TableView<LVTableRow> tableView;
    public TableColumn<LVTableRow, String> tableColumnLabel
            = new TableColumn<>("Name");
    public TableColumn<LVTableRow, StringProperty> tableColumnMembership = new TableColumn<>("Membership function");
    public TableColumn<LVTableRow, CheckBox> tableColumnIsRelative = new TableColumn<>("is relative");
    public TableColumn<LVTableRow, Double> tableColumnA = new TableColumn<>("a");
    public TableColumn<LVTableRow, Double> tableColumnB = new TableColumn<>("b");
    public TableColumn<LVTableRow, Double> tableColumnC = new TableColumn<>("c");
    public TableColumn<LVTableRow, Double> tableColumnD = new TableColumn<>("d");
    public Button readSaved;
    public Button save;
    public LineChart lineChart;
    public Button addRow;
    public Button removeRow;
    public Button plotFunction;
    public ComboBox comboBox;
    ObservableList<String> membershipOptions = FXCollections.observableArrayList(
            "Trapezoidal",
            "Triangular"
    );
    private ObservableList<LVTableRow> LVtableRowObservaleList = FXCollections.observableArrayList();
    private ArrayList<LinguisticVariable> linguisticVariables;

    @FXML
    public void initialize() {
        try {

            initializeTable();
            setTableEditable();

            prepareComboBox();

            series.setName("Membership function");
            lineChart.getData().add(series);
            lineChart.setCreateSymbols(false);

            linguisticVariables = MainWindow.getLinguisticVariables();
            populateTable(getLVfromComboBox());

            readSaved.setOnAction(
                    actionEvent -> {
                        linguisticVariables = MainWindow.getLinguisticVariables();
                        populateTable(getLVfromComboBox());
                    }
            );
            save.setOnAction(
                    actionEvent -> {
                        saveLV();
                        linguisticVariables = MainWindow.getLinguisticVariables();
                    }
            );
            addRow.setOnAction(
                    actionEvent -> {
                        LVtableRowObservaleList.add(new LVTableRow("New name", "Trapezoidal", true, 0, 0, 0, 0));
                    }
            );
            removeRow.setOnAction(
                    actionEvent -> {
                        LVTableRow selectedItem = tableView.getSelectionModel().getSelectedItem();
                        LVtableRowObservaleList.remove(selectedItem);
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

        LVTableRow selectedItem = tableView.getSelectionModel().getSelectedItem();
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

    private void OLDsaveLV() {
        ArrayList<LinguisticVarLabelSerialized> linguisticVarLabelSerialized = new ArrayList<>();
    ArrayList<LinguisticVariableSerialized> linguisticVariableSerialized = new ArrayList<>();
    LinguisticVariablesSerialized linguisticVariablesSerialized;


        for(String ParamMapper : ParametersMapper.values()) {
        linguisticVarLabelSerialized = new ArrayList<>();
        for (LVTableRow lvTableRow : LVtableRowObservaleList) {
            linguisticVarLabelSerialized.add(new LinguisticVarLabelSerialized(lvTableRow));
        }

        linguisticVariableSerialized.add(new LinguisticVariableSerialized(ParamMapper, linguisticVarLabelSerialized));
    }
    linguisticVariablesSerialized = new LinguisticVariablesSerialized(linguisticVariableSerialized);

        XMLReader.saveLinguisticVariables(linguisticVariablesSerialized);
}

    private void saveLV() {
        ArrayList<LinguisticVarLabelSerialized> linguisticVarLabelSerialized = new ArrayList<>();
        ArrayList<LinguisticVariableSerialized> linguisticVariableSerialized = new ArrayList<>();
        LinguisticVariablesSerialized linguisticVariablesSerialized;


        for(String ParamMapper : ParametersMapper.values()) {
            if(ParamMapper.equals(comboBox.getSelectionModel().getSelectedItem())) {
                linguisticVarLabelSerialized = new ArrayList<>();
                for (LVTableRow lvTableRow : LVtableRowObservaleList) {
                    linguisticVarLabelSerialized.add(new LinguisticVarLabelSerialized(lvTableRow));
                }
            } else {
                linguisticVarLabelSerialized = getLinguisticVarLabelSerializedFromString(ParamMapper);
            }

            linguisticVariableSerialized.add(new LinguisticVariableSerialized(ParamMapper, linguisticVarLabelSerialized));
        }
        linguisticVariablesSerialized = new LinguisticVariablesSerialized(linguisticVariableSerialized);

        XMLReader.saveLinguisticVariables(linguisticVariablesSerialized);
    }

    private ArrayList<LinguisticVarLabelSerialized> getLinguisticVarLabelSerializedFromString(String name) {
        LinguisticVariable lv = null;
        ArrayList<LinguisticVarLabelSerialized> linguisticVarLabelSerializeds = new ArrayList<>();

        for (LinguisticVariable lvSearch : linguisticVariables)
        {
            if( lvSearch.getName().equals(name)){
                lv = lvSearch;
                break;
            }

        }

        for (int i = 0; i < lv.getLabels().size(); i++)
        {
            linguisticVarLabelSerializeds.add(new LinguisticVarLabelSerialized(new LVTableRow(lv, i)));
        }

        return linguisticVarLabelSerializeds;
    }

    private void prepareComboBox() {
        comboBox.getItems().addAll(ParametersMapper.values());
        comboBox.getSelectionModel().select(ParametersMapper.values().toArray()[0]);
    }

    public void comboAction(ActionEvent actionEvent) {

        populateTable(getLVfromComboBox());
    }

    private LinguisticVariable getLVfromComboBox() {
        for (LinguisticVariable lv : linguisticVariables)
        {
            if( lv.getName().equals(comboBox.getSelectionModel().getSelectedItem()))
                return lv;
        }
        return null;
    }

    private void populateTable(LinguisticVariable lv) {
        LVtableRowObservaleList.clear();
        try {
                for (int i = 0; i < lv.getLabels().size(); i++)
                {
                    LVtableRowObservaleList.add(new LVTableRow(lv, i));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeTable() {
        tableView.setPlaceholder(new Label("No rows to display"));
        tableColumnLabel.setCellValueFactory(new PropertyValueFactory<>("label"));
        tableColumnIsRelative.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LVTableRow, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<LVTableRow, CheckBox> arg0) {
                LVTableRow q = arg0.getValue();

                CheckBox checkBox = new CheckBox();

                checkBox.selectedProperty().setValue(q.getIsRelative().get());


                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                        q.setIsRelative(new SimpleBooleanProperty(new_val));

                    }
                });

                return new SimpleObjectProperty<CheckBox>(checkBox);

            }

        });
        tableColumnIsRelative.setStyle("-fx-alignment: CENTER;");

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
            TableCell<LVTableRow, StringProperty> c = new TableCell<>();


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

        tableColumnLabel.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnA.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tableColumnB.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tableColumnC.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tableColumnD.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setItems(LVtableRowObservaleList);
        tableView.getColumns().addAll(tableColumnLabel, tableColumnMembership, tableColumnIsRelative,
                tableColumnA, tableColumnB, tableColumnC, tableColumnD);


        tableColumnLabel.setOnEditCommit(
                (TableColumn.CellEditEvent<LVTableRow, String> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLabel(t.getNewValue())
        );
        tableColumnMembership.setOnEditCommit(
                (TableColumn.CellEditEvent<LVTableRow, StringProperty> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMembership(t.getNewValue())
        );
        tableColumnA.setOnEditCommit(
                (TableColumn.CellEditEvent<LVTableRow, Double> t) ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setA(t.getNewValue());
                    plotSelected();
                }
        );
        tableColumnB.setOnEditCommit(
                (TableColumn.CellEditEvent<LVTableRow, Double> t) ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setB(t.getNewValue());
                    plotSelected();
                }
        );
        tableColumnC.setOnEditCommit(
                (TableColumn.CellEditEvent<LVTableRow, Double> t) ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setC(t.getNewValue());
                    plotSelected();
                }
        );
        tableColumnD.setOnEditCommit(
                (TableColumn.CellEditEvent<LVTableRow, Double> t) ->
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
