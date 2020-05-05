package com.kodilla.first.individual.project.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

import java.io.File;

public class AppController {
    private final static Image OLETTER = new Image("file:resources/o-letter.png");
    private final static Image XLETTER = new Image("file:resources/x-letter.png");
    private final static String GRAJ = "Graj!";
    private final static String RESET = "Nowa gra";
    private static boolean endGame;
    private Image player;

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
    Button playBtn;

    @FXML
    private ImageView testImage;

    @FXML
    public void initialize() {
        choiceBoxInit();
        endGame = true;


    }


    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void image00Clicked() {
        if (!endGame) {
            image00.setImage(player);
            System.out.println("image " + image00.getImage());
            System.out.println("player " + player);
            System.out.println("xletter" + XLETTER.equals(image00.getImage()));
            checkLine();
        }
    }

    @FXML
    public void image01Clicked() {
        if (!endGame){
            image01.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image02Clicked() {
        if (!endGame){
            image02.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image10Clicked() {
        if (!endGame){
            image10.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image11Clicked() {
        if (!endGame){
            image11.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image12Clicked() {
        if (!endGame){
            image12.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image20Clicked() {
        if (!endGame){
            image20.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image21Clicked() {
        if (!endGame){
            image21.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image22Clicked() {
        if (!endGame){
            image22.setImage(player);
            checkLine();
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void play() {

        if (GRAJ.equals(playBtn.getText())) {
            choiceBox.setVisible(false);
            endGame=false;
            playBtn.setText(RESET);
        } else {
            choiceBox.setVisible(true);
            playBtn.setText(GRAJ);
        }

        image00.setImage(null);
        image01.setImage(null);
        image02.setImage(null);
        image10.setImage(null);
        image11.setImage(null);
        image12.setImage(null);
        image20.setImage(null);
        image21.setImage(null);
        image22.setImage(null);
    }

    private void choiceBoxInit() {
        choiceBox.getItems().add("Kółko");
        choiceBox.getItems().add("Krzyżyk");
        choiceBox.setValue("Krzyżyk");
        testImage.setImage(XLETTER);
        player = XLETTER;
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(choiceBox.getItems().get((Integer) t1));
                if ("Krzyżyk".equals(choiceBox.getItems().get((Integer) t1))) {
                    testImage.setImage(XLETTER);
                    player = XLETTER;
                } else {
                    testImage.setImage(OLETTER);
                    player = OLETTER;
                }
            }

        });
    }

    public void checkLine() {
        System.out.println("Sprawdzam linię");
        if (XLETTER.equals(image00.getImage())
                && XLETTER.equals(image01.getImage())
                && XLETTER.equals(image02.getImage())) {
            System.out.println("LINIA");;
            endGame =true;
        }

    }
}
