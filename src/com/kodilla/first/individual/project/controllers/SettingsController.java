package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.Settings;
import com.kodilla.first.individual.project.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class SettingsController {

    private MainController mainController;
    @FXML
    ChoiceBox<String> choiceBoxOfPickedFigure;
    @FXML
    ChoiceBox<String> choiceBoxOfStartingFigure;
    @FXML
    ImageView imageViewOfPickedFigure;
    @FXML
    ImageView imageViewOfStartingFigure;
    @FXML
    Button easyBtn;
    @FXML
    Button mediumBtn;
    @FXML
    Button hardBtn;
    @FXML
    Button oneBtn;
    @FXML
    Button threeBtn;
    @FXML
    Button fiveBtn;
    @FXML
    Button resetBtn;
    @FXML
    Button playSinglePlayerBtn;
    @FXML
    Button menuBtn;

    @FXML
    public void backMenu(){

        mainController.loadMenuScreen();

    }

    @FXML
    public void initialize() {
        choiceBoxInit();
        menuInit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void easyOnClick(){
        easyBtn.setDefaultButton(true);
        mediumBtn.setDefaultButton(false);
        hardBtn.setDefaultButton(false);
        Settings.getInstance().setLevel(Settings.EASY);
    }
    @FXML
    public void mediumOnClick(){
        easyBtn.setDefaultButton(false);
        mediumBtn.setDefaultButton(true);
        hardBtn.setDefaultButton(false);
        Settings.getInstance().setLevel(Settings.MEDIUM);
    }
    @FXML
    public void hardOnClick(){
        easyBtn.setDefaultButton(false);
        mediumBtn.setDefaultButton(false);
        hardBtn.setDefaultButton(true);
        Settings.getInstance().setLevel(Settings.HARD);
    }
    @FXML
    public void oneOnClick(){
        oneBtn.setDefaultButton(true);
        threeBtn.setDefaultButton(false);
        fiveBtn.setDefaultButton(false);
        Settings.getInstance().setNumberOfGames(1);
    }
    @FXML
    public void threeOnClick(){
        oneBtn.setDefaultButton(false);
        threeBtn.setDefaultButton(true);
        fiveBtn.setDefaultButton(false);
        Settings.getInstance().setNumberOfGames(3);

    }
    @FXML
    public void fiveOnClick(){
        oneBtn.setDefaultButton(false);
        threeBtn.setDefaultButton(false);
        fiveBtn.setDefaultButton(true);
        Settings.getInstance().setNumberOfGames(5);

    }
    @FXML
    public void playSinglePlayer(){
        mainController.loadSinglePlayerScreen();
    }

    @FXML
    public void scoreBtnMouseEntered(){
        //Button button = this.getClass().
        resetBtn.setDefaultButton(true);
    }
    @FXML
    public void scoreBtnMouseExited(){
        //Button button = this.getClass().
        resetBtn.setDefaultButton(false);
    }
    @FXML
    public void playSinglePlayerBtnMouseEntered(){
        playSinglePlayerBtn.setDefaultButton(true);
    }
    @FXML
    public void playSinglePlayerBtnMouseExited(){
        playSinglePlayerBtn.setDefaultButton(false);
    }
    @FXML
    public void menuBtnMouseEntered(){
        menuBtn.setDefaultButton(true);
    }
    @FXML
    public void menuBtnMouseExited(){
        menuBtn.setDefaultButton(false);
    }


    public void menuInit() {
        if (Settings.HARD.equals(Settings.getInstance().getLevel())) {
            hardBtn.setDefaultButton(true);
        } else if (Settings.MEDIUM.equals(Settings.getInstance().getLevel())) {
            mediumBtn.setDefaultButton(true);
        } else if (Settings.EASY.equals(Settings.getInstance().getLevel())) {
            easyBtn.setDefaultButton(true);
        }
        if (Settings.getInstance().getNumberOfGames()==1) {
            oneBtn.setDefaultButton(true);
        } else if (Settings.getInstance().getNumberOfGames()==3) {
            threeBtn.setDefaultButton(true);
        } else if (Settings.getInstance().getNumberOfGames()==5) {
            fiveBtn.setDefaultButton(true);
        }

    }


    private void choiceBoxInit() {
        choiceBoxOfPickedFigure.getItems().add("Kółko");
        choiceBoxOfPickedFigure.getItems().add("Krzyżyk");
        choiceBoxOfPickedFigure.setValue("Krzyżyk");
        imageViewOfPickedFigure.setImage(AppController.XLETTERRED);
        AppController.player = AppController.XLETTER;
        AppController.computer = AppController.OLETTER;
        choiceBoxOfPickedFigure.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(choiceBoxOfPickedFigure.getItems().get((Integer) t1));
                if ("Krzyżyk".equals(choiceBoxOfPickedFigure.getItems().get((Integer) t1))) {
                    imageViewOfPickedFigure.setImage(AppController.XLETTERRED);
                    AppController.player = AppController.XLETTER;
                    AppController.computer = AppController.OLETTER;
                } else {
                    imageViewOfPickedFigure.setImage(AppController.OLETTERRED);
                    AppController.player = AppController.OLETTER;
                    AppController.computer = AppController.XLETTER;
                }
            }
        });

        choiceBoxOfStartingFigure.getItems().add("Kółko");
        choiceBoxOfStartingFigure.getItems().add("Krzyżyk");
        choiceBoxOfStartingFigure.setValue("Krzyżyk");
        imageViewOfStartingFigure.setImage(AppController.XLETTERRED);
        AppController.player = AppController.XLETTER;
        AppController.computer = AppController.OLETTER;
        choiceBoxOfStartingFigure.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(choiceBoxOfStartingFigure.getItems().get((Integer) t1));
                if ("Krzyżyk".equals(choiceBoxOfStartingFigure.getItems().get((Integer) t1))) {
                    imageViewOfStartingFigure.setImage(AppController.XLETTERRED);
                    AppController.player = AppController.XLETTER;
                    AppController.computer = AppController.OLETTER;
                } else {
                    imageViewOfStartingFigure.setImage(AppController.OLETTERRED);
                    AppController.player = AppController.OLETTER;
                    AppController.computer = AppController.XLETTER;
                }
            }
        });
    }
}
