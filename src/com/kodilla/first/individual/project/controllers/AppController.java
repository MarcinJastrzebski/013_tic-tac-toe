package com.kodilla.first.individual.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

import java.io.File;

public class AppController {
    public final static Image OLETTER = new Image("file:resources/o-letter.png");
    public final static Image XLETTER = new Image("file:resources/x-letter.png");

    private MainController mainController;
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    ImageView image00;
    @FXML
    ImageView image01;
    @FXML
    ImageView image02;
    @FXML
    ImageView image10;
    @FXML
    ImageView image11;
    @FXML
    ImageView image12;
    @FXML
    ImageView image20;
    @FXML
    ImageView image21;
    @FXML
    ImageView image22;

    @FXML
    private ImageView testImage;

    @FXML
    public void initialize(){
        choiceBoxInit();

        File file = new File("resources/o-letter.png");
        Image kolko = new Image(file.toURI().toString());
        System.out.println(file.toURI().toString());
        testImage.setImage(kolko);
    }
    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }
    @FXML
    public void image00Clicked(){
        image00.setImage(OLETTER);
    }

    @FXML
    public void image01Clicked(){
        image01.setImage(XLETTER);
    }
    @FXML
    public void image02Clicked(){
        image02.setImage(XLETTER);
    }
    @FXML
    public void image10Clicked(){
        image10.setImage(XLETTER);
    }
    @FXML
    public void image11Clicked(){
        image11.setImage(XLETTER);
    }
    @FXML
    public void image12Clicked(){
        image12.setImage(XLETTER);
    }
    @FXML
    public void image20Clicked(){
        image20.setImage(XLETTER);
    }
    @FXML
    public void image21Clicked(){
        image21.setImage(XLETTER);
    }
    @FXML
    public void image22Clicked(){
        image22.setImage(XLETTER);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void choiceBoxInit(){
        choiceBox.getItems().add("Kółko");
        choiceBox.getItems().add("Krzyżyk");
        choiceBox.setValue("Krzyżyk");
    }
}
