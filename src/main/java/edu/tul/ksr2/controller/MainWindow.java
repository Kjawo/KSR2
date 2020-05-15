package edu.tul.ksr2.controller;

import edu.tul.ksr2.Database.DatabaseHandler;
import edu.tul.ksr2.GameEntity;
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

    @FXML
    public Button openDialogButton;

    public MainWindow(FxControllerAndView<SomeDialog, VBox> someDialog) {
        this.someDialog = someDialog;
    }

    @FXML
    public void initialize() {
        try {
            DatabaseHandler.initialize();
            ArrayList<GameEntity> gameEntities = DatabaseHandler.loadAllFromDB();
            System.out.println("LoL - Leauge of Legends");
            System.out.println(gameEntities.get(0).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }
}