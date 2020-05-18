package com.kodilla.first.individual.project.controllers;

import javafx.fxml.FXML;

public class CleanController {
    private MainController mainController;

    @FXML
    public void clickOnPane() {
        mainController.loadAppScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void play() {
        mainController.loadAppScreen();
    }

    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void settingsMenu() {
        mainController.loadSettingsScreen();
    }
}
