package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.Settings;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuController {

    private MainController mainController;

    @FXML
    public void playSinglePlayer() {
        if (!Settings.getInstance().isSoloGame()){
            Settings.getInstance().resetScore();
        }
        Settings.getInstance().setSoloGame(true);
        mainController.loadAppScreen();
    }

    @FXML
    public void playDuoGame() {
        if (Settings.getInstance().isSoloGame()){
            Settings.getInstance().resetScore();
        }
        Settings.getInstance().setSoloGame(false);
        mainController.loadAppScreen();
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