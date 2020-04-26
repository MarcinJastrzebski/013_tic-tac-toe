package com.kodilla.first.individual.project.controllers;

import javafx.fxml.FXML;

public class OptionsController {

    private MainController mainController;

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
