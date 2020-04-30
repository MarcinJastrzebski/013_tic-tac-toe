package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;

public class MenuController {

    private MainController mainController;
    @FXML
    private Pane menuPane;
    @FXML
    private ImageView menuBackground;

    @FXML
    public void initialize() {
        System.out.println("testy");
        File file = new File("resources/ideaOfMenu.png");
        Image menuBackgroundImage = new Image(file.toURI().toString());
        menuBackground.setImage(menuBackgroundImage);
        menuBackground.setFitHeight(100);
        menuBackground.setFitWidth(100);
        BackgroundImage backgroundImage = new BackgroundImage(menuBackgroundImage,null, null,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        //menuBackground.setPreserveRatio(true);
        System.out.println(file.toURI().toString());
        //Group root = new Group();
        //root.getChildren().addAll(menuBackground);
    }

    @FXML
    public void openApplication(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/AppScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppController appController = loader.getController();
        appController.setMainController(mainController);
        mainController.setScreen(pane);



    }

    @FXML
    public void openOptions(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/OptionsScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OptionsController optionsController = loader.getController();
        optionsController.setMainController(mainController);
        mainController.setScreen(pane);
    }

    public void exit(){
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
