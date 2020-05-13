package com.kodilla.first.individual.project.controllers;

import java.io.IOException;

import com.kodilla.first.individual.project.Logic.Settings;
import com.kodilla.first.individual.project.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class MainController {

    @FXML
    private StackPane mainStackPane;


    @FXML
    public void initialize() {
        loadMenuScreen();
    }

    public void loadMenuScreen() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/MenuScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setScreen(pane);
    }

    public void loadSinglePlayerScreen(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/AppScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppController appController = loader.getController();
        appController.setMainController(this);
        ImageView imageView = new ImageView(new Image("file:resources/woodenBcg.jpg"));
        //  imageView.setScaleX(1.1);
        imageView.setFitHeight(400);
        imageView.setY(130);
        setBackgroundAndScreen(imageView, pane);
        //mainController.setScreen(pane);
    }

    public void setScreen(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }

    public void setBackground(ImageView imageView) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(imageView);
    }
    public void setBackgroundAndScreen(ImageView imageView, Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(imageView);
        mainStackPane.getChildren().add(pane);
    }

}