package com.kodilla.first.individual.project.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;


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
    public void backMenu(){
        mainController.loadMenuScreen();

    }

    @FXML
    public void initialize() {
        choiceBoxInit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void easyOnClick(){
        easyBtn.setDefaultButton(true);
        mediumBtn.setDefaultButton(false);
        hardBtn.setDefaultButton(false);
    }
    @FXML
    public void mediumOnClick(){
        easyBtn.setDefaultButton(false);
        mediumBtn.setDefaultButton(true);
        hardBtn.setDefaultButton(false);
    }
    @FXML
    public void hardOnClick(){
        easyBtn.setDefaultButton(false);
        mediumBtn.setDefaultButton(false);
        hardBtn.setDefaultButton(true);
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
