package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;

public class MenuController {

    private MainController mainController;
    @FXML
    private Pane menuPane;

    @FXML
    public void initialize() {

    }

    @FXML
    public void playSinglePlayer(){
        mainController.loadSinglePlayerScreen();
    }

    @FXML
    public void openRules(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/SettingsScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SettingsController settingsController = loader.getController();
        settingsController.setMainController(mainController);
        ImageView imageView = new ImageView(new Image("file:resources/boardEmpty.png"));
        mainController.setBackgroundAndScreen(imageView,pane);
    }

    public void exit(){
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
