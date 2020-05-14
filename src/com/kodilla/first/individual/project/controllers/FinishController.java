package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.Settings;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class FinishController {
    private MainController mainController;

    @FXML
    ImageView winnerImgV;

    public void initialize(){
        if (Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getxScore())){
            winnerImgV.setImage(Settings.XLETTERRED);
        } else {
            winnerImgV.setImage(Settings.OLETTERRED);
        }
    }

    @FXML
    public void play(){
        Settings.getInstance().resetScore();
        mainController.loadSinglePlayerScreen();
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

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
