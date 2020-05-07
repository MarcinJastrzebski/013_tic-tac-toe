package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.ExtendedImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
    private Image computer;
    private static Integer oScore = 0;
    private static Integer xScore = 0;
    private static Integer numberOfPlayerMoves = 0;
    private static Integer numberOfComputerMoves = 0;

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
    ImageView xImgV;
    @FXML
    ImageView oImgV;
    @FXML
    Label xLbl;
    @FXML
    Label oLbl;

    @FXML
    Button playBtn;

    @FXML
    private ImageView testImage;

    @FXML
    public void initialize() {
        choiceBoxInit();
        endGame = true;
        xImgV.setImage(XLETTER);
        xImgV.setFitHeight(Parent.BASELINE_OFFSET_SAME_AS_HEIGHT);
        oImgV.setImage(OLETTER);
        oImgV.setFitHeight(Parent.BASELINE_OFFSET_SAME_AS_HEIGHT);
        xLbl.setText(xScore.toString());
        oLbl.setText(oScore.toString());


    }


    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void image00Clicked() {
        if (!endGame && TRANSP.equals(image00.getImage())) {
            image00.setImage(player);
            System.out.println("image " + image00.getImage());
            System.out.println("player " + player);
            System.out.println("xletter" + XLETTER.equals(image00.getImage()));
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image01Clicked() {
        if (!endGame && TRANSP.equals(image01.getImage())) {
            image01.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image02Clicked() {
        if (!endGame && TRANSP.equals(image02.getImage())) {
            image02.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image10Clicked() {
        if (!endGame && TRANSP.equals(image10.getImage())) {
            image10.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image11Clicked() {
        if (!endGame && TRANSP.equals(image11.getImage())) {
            image11.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image12Clicked() {
        if (!endGame && TRANSP.equals(image12.getImage())) {
            image12.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image20Clicked() {
        if (!endGame && TRANSP.equals(image20.getImage())) {
            image20.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image21Clicked() {
        if (!endGame && TRANSP.equals(image21.getImage())) {
            image21.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    @FXML
    public void image22Clicked() {
        if (!endGame && TRANSP.equals(image22.getImage())) {
            image22.setImage(player);
            checkLine();

            computerMoveWithThread();
        }
    }

    public void computerMoveWithThread() {
        if (!endGame) {
//            new Thread(() -> {
//                try {
//                    Thread.sleep(100);
//                    computerMove();
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//            checkLine();

            computerMove();
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
        //image00.setScaleX(0.1);
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
        computer = OLETTER;
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(choiceBox.getItems().get((Integer) t1));
                if ("Krzyżyk".equals(choiceBox.getItems().get((Integer) t1))) {
                    testImage.setImage(XLETTER);
                    player = XLETTER;
                    computer = OLETTER;
                } else {
                    testImage.setImage(OLETTER);
                    player = OLETTER;
                    computer = XLETTER;
                }
            }

        });
    }

    public void checkLine() {
        System.out.println("Sprawdzam linię");
        if (image00.getImage().equals(image01.getImage())
                && image01.getImage().equals(image02.getImage())
                && !TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA BB");
            image00.setImage(changeImage(image00.getImage()));
            System.out.println("B1");
            image01.setImage(changeImage(image01.getImage()));
            System.out.println("B2");

            image02.setImage(changeImage(image02.getImage()));
            System.out.println("B3");

            addPoint(figure(image00.getImage()));
            System.out.println("B4");

            endGame = true;
            System.out.println("B5");

        } else if (image10.getImage().equals(image11.getImage())
                && image11.getImage().equals(image12.getImage())
                && !TRANSP.equals(image10.getImage())) {
            System.out.println("LINIA");
            image10.setImage(changeImage(image10.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image12.setImage(changeImage(image12.getImage()));
            addPoint(figure(image10.getImage()));
            endGame = true;
        } else if (image20.getImage().equals(image21.getImage())
                && image21.getImage().equals(image22.getImage())
                && !TRANSP.equals(image20.getImage())) {
            System.out.println("LINIA");
            image20.setImage(changeImage(image20.getImage()));
            image21.setImage(changeImage(image21.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            addPoint(figure(image20.getImage()));
            endGame = true;
        } else if (image00.getImage().equals(image10.getImage())
                && image10.getImage().equals(image20.getImage())
                && !TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image10.setImage(changeImage(image10.getImage()));
            image20.setImage(changeImage(image20.getImage()));
            addPoint(figure(image00.getImage()));
            endGame = true;
        } else if (image01.getImage().equals(image11.getImage())
                && image11.getImage().equals(image21.getImage())
                && !TRANSP.equals(image01.getImage())) {
            System.out.println("LINIA");
            image01.setImage(changeImage(image01.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image21.setImage(changeImage(image21.getImage()));
            addPoint(figure(image01.getImage()));
            endGame = true;
        } else if (image02.getImage().equals(image12.getImage())
                && image12.getImage().equals(image22.getImage())
                && !TRANSP.equals(image02.getImage())) {
            System.out.println("LINIA");
            image02.setImage(changeImage(image02.getImage()));
            image12.setImage(changeImage(image12.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            addPoint(figure(image02.getImage()));
            endGame = true;
        } else if (image00.getImage().equals(image11.getImage())
                && image11.getImage().equals(image22.getImage())
                && !TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            addPoint(figure(image00.getImage()));
            endGame = true;
        } else if (image02.getImage().equals(image11.getImage())
                && image11.getImage().equals(image20.getImage())
                && !TRANSP.equals(image02.getImage())) {
            System.out.println("LINIA");
            image02.setImage(changeImage(image02.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image20.setImage(changeImage(image20.getImage()));
            addPoint(figure(image02.getImage()));
            endGame = true;
        }
        //xScore+=1;
        //xLbl.setText(xScore.toString());
        //System.out.println(xScore);

    }

    public Image changeImage(Image image) {
        if (XLETTER.equals(image)) {
            return XLETTERRED;
        } else {
            return OLETTERRED;
        }
    }

    public void addPoint(String figure) {
        if ("x".equals(figure)) {
            xScore += 1;
            xLbl.setText(xScore.toString());
        } else {
            oScore += 1;
            oLbl.setText(oScore.toString());
        }

    }

    public String figure(Image image) {
        if (XLETTER.equals(image) || XLETTERRED.equals(image)) {
            return "x";
        } else {
            return "o";
        }
    }

    //ToTO
    //- score
    //popup with endgame
    public void computerMove() {
//        int counter = 0;
//        if (player.equals(image00.getImage()) && TRANSP.equals(image01.getImage())) {
//            image01.setImage(computer);
//        } else {
        blockingStrategyMove();

        //  randomComputerMove();

        //  }
    }

    public void randomComputerMove() {
        if (TRANSP.equals(image11.getImage())) {
            image11.setImage(computer);
        } else if (TRANSP.equals(image01.getImage())) {
            image01.setImage(computer);
        } else if (TRANSP.equals(image10.getImage())) {
            image10.setImage(computer);
        } else if (TRANSP.equals(image22.getImage())) {
            image22.setImage(computer);
        } else if (TRANSP.equals(image00.getImage())) {
            image00.setImage(computer);
        } else if (TRANSP.equals(image02.getImage())) {
            image02.setImage(computer);
        } else if (TRANSP.equals(image12.getImage())) {
            image12.setImage(computer);
        } else if (TRANSP.equals(image20.getImage())) {
            image20.setImage(computer);
        } else if (TRANSP.equals(image21.getImage())) {
            image21.setImage(computer);
        } else {
            System.out.println("PROBLEM");
        }
        System.out.println("endGame: " + endGame);

    }

    public void blockingStrategyMove() {


        if (checkLineToBlock(player, image00, image01, image02).getaBoolean()) {
            checkLineToBlock(player, image00, image01, image02).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image10, image11, image12).getaBoolean()) {
            checkLineToBlock(player, image10, image11, image12).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image20, image21, image22).getaBoolean()) {
            checkLineToBlock(player, image20, image21, image22).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image00, image10, image20).getaBoolean()) {
            checkLineToBlock(player, image00, image10, image20).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image01, image11, image21).getaBoolean()) {
            checkLineToBlock(player, image01, image11, image21).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image02, image12, image22).getaBoolean()) {
            checkLineToBlock(player, image02, image12, image22).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image00, image11, image22).getaBoolean()) {
            checkLineToBlock(player, image00, image11, image22).getImageView().setImage(computer);
        } else if (checkLineToBlock(player, image20, image11, image02).getaBoolean()) {
            checkLineToBlock(player, image20, image11, image02).getImageView().setImage(computer);
        } else {
             randomComputerMove();
        }
    }

    public ExtendedImageView checkLineToBlock(Image pattern, ImageView image1, ImageView image2, ImageView image3) {
        int counter = 0;
        boolean tmpBoolean;

        if (pattern.equals(image1.getImage())) {
            counter += 1;
        }
        if (pattern.equals(image2.getImage())) {
            counter += 1;
        }
        if (pattern.equals(image3.getImage())) {
            counter += 1;
        }
        if (counter == 2) {
            tmpBoolean = true;
            if (TRANSP.equals(image1.getImage())) {
                return new ExtendedImageView(image1, tmpBoolean);
            } else if (TRANSP.equals(image2.getImage())) {
                return new ExtendedImageView(image2, tmpBoolean);
            } else if (TRANSP.equals(image3.getImage())) {
                return new ExtendedImageView(image3, tmpBoolean);
            }
        } else {
            tmpBoolean = false;
            return new ExtendedImageView(image1, tmpBoolean);
        }
        return new ExtendedImageView(new ImageView(), false);
    }


    public int checkImage(Image pattern, Image image) {
        if (pattern.equals(image)) {
            return 1;
        } else {
            return 0;
        }
    }

}
