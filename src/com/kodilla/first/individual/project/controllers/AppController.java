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
    private final static Image OLETTERRED = new Image("file:resources/o-letter-red.png");
    private final static Image XLETTERRED = new Image("file:resources/x-letter-red.png");
    private final static Image TRANSP = new Image("file:resources/transp.png");
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
        if (!endGame) {
            image01.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image02Clicked() {
        if (!endGame) {
            image02.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image10Clicked() {
        if (!endGame) {
            image10.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image11Clicked() {
        if (!endGame) {
            image11.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image12Clicked() {
        if (!endGame) {
            image12.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image20Clicked() {
        if (!endGame) {
            image20.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image21Clicked() {
        if (!endGame) {
            image21.setImage(player);
            checkLine();
        }
    }

    @FXML
    public void image22Clicked() {
        if (!endGame) {
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
            endGame = false;
            playBtn.setText(RESET);
        } else {
            choiceBox.setVisible(true);
            playBtn.setText(GRAJ);
            endGame = true;
        }

        image00.setImage(TRANSP);
        image01.setImage(TRANSP);
        image02.setImage(TRANSP);
        image10.setImage(TRANSP);
        image11.setImage(TRANSP);
        image12.setImage(TRANSP);
        image20.setImage(TRANSP);
        image21.setImage(TRANSP);
        image22.setImage(TRANSP);
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
        if (image00.getImage().equals(image01.getImage())
                && image01.getImage().equals(image02.getImage())
                && !TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image01.setImage(changeImage(image01.getImage()));
            image02.setImage(changeImage(image02.getImage()));
            endGame = true;
        } else if (image10.getImage().equals(image11.getImage())
                && image11.getImage().equals(image12.getImage())
                && !TRANSP.equals(image10.getImage())) {
            System.out.println("LINIA");
            image10.setImage(changeImage(image10.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image12.setImage(changeImage(image12.getImage()));
            endGame = true;
        } else if (image20.getImage().equals(image21.getImage())
                && image21.getImage().equals(image22.getImage())
                && !TRANSP.equals(image20.getImage())) {
            System.out.println("LINIA");
            image20.setImage(changeImage(image20.getImage()));
            image21.setImage(changeImage(image21.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            endGame = true;
        } else if (image00.getImage().equals(image10.getImage())
                && image10.getImage().equals(image20.getImage())
                && !TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image10.setImage(changeImage(image10.getImage()));
            image20.setImage(changeImage(image20.getImage()));
            endGame = true;
        } else if (image01.getImage().equals(image11.getImage())
                && image11.getImage().equals(image21.getImage())
                && !TRANSP.equals(image01.getImage())) {
            System.out.println("LINIA");
            image01.setImage(changeImage(image01.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image21.setImage(changeImage(image21.getImage()));
            endGame = true;
        } else if (image02.getImage().equals(image12.getImage())
                && image12.getImage().equals(image22.getImage())
                && !TRANSP.equals(image02.getImage())) {
            System.out.println("LINIA");
            image02.setImage(changeImage(image02.getImage()));
            image12.setImage(changeImage(image12.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            endGame = true;
        } else if (image00.getImage().equals(image11.getImage())
                && image11.getImage().equals(image22.getImage())
                && !TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            endGame = true;
        } else if (image02.getImage().equals(image11.getImage())
                && image11.getImage().equals(image20.getImage())
                && !TRANSP.equals(image02.getImage())) {
            System.out.println("LINIA");
            image02.setImage(changeImage(image02.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image20.setImage(changeImage(image20.getImage()));
            endGame = true;
        }

    }

    public Image changeImage(Image image) {
        if (XLETTER.equals(image)) {
            return XLETTERRED;
        } else {
            return OLETTERRED;
        }
    }

    //ToTO
    //- score
    //popup with endgame
}
