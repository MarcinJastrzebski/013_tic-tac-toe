package com.kodilla.first.individual.project.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuController {

    private MainController mainController;

    @FXML
    public void initialize() {
    }

    @FXML
    public void playSinglePlayer() {
        mainController.loadSinglePlayerScreen();
    }

    @FXML
    public void openSettings() {
        mainController.loadSettingsScreen();
    }

    public void exit() {
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
