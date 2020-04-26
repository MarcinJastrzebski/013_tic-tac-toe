package com.kodilla.first.individual.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

import java.io.File;

public class AppController {

    private MainController mainController;

    @FXML
    private ImageView testImage;

    @FXML
    public void initialize(){
        File file = new File("resources/o-letter.png");
        Image kolko = new Image(file.toURI().toString());
        System.out.println(file.toURI().toString());
        testImage.setImage(kolko);
    }
    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
