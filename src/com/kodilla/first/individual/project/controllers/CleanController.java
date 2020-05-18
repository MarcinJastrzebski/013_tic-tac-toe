package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.Settings;
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
    public void play(){
        Settings.getInstance().resetScore();
        mainController.loadAppScreen();
    }
    @FXML
    public void backMenu(){
        Settings.getInstance().resetScore();
        mainController.loadMenuScreen();
    }
    @FXML
    public void settingsMenu(){
        Settings.getInstance().resetScore();
        mainController.loadSettingsScreen();
    }
}
