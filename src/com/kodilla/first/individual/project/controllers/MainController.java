package com.kodilla.first.individual.project.controllers;

import java.io.IOException;

import com.kodilla.first.individual.project.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;



public class MainController {

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/MenuScreen.fxml"));
        Pane pane = null;
        //System.out.println(Main.class.getResource("fxml/MenuScreen.fxml"));
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStackPane.getChildren().add(pane);
    }
}