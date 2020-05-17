package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.ExtendedImageView;
import com.kodilla.first.individual.project.Logic.Settings;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class AppController {

    private MainController mainController;
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
    Label scoreLbl;

    @FXML
    public void initialize() {
        initScoreBoard();
        play();
    }

    public void checkIfGameIsFinished() {
        if (Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getxScore())
                || Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getoScore())) {
            mainController.loadFinishScreen();
        }
    }

    public void initFirstMove() {
        System.out.println("wszedlem w init");
        System.out.println("player : " + Settings.getInstance().getPlayer().getUrl());
        System.out.println("starting figure : " + Settings.getInstance().getStartingFigure().getUrl());
        if (!Settings.getInstance().getStartingFigure().getUrl().equals(Settings.getInstance().getPlayer().getUrl())) {
            image11.setImage(Settings.getInstance().getComputer());
            System.out.println("powinienem rysowac");
        }

    }

    public void initScoreBoard() {
        scoreLbl.setTextFill(Color.web("#000000", 1));

        if (Settings.XLETTER.getUrl().equals(Settings.getInstance().getPlayer().getUrl())) {
            xImgV.setImage(Settings.XLETTERRED);
            xImgV.setFitHeight(Parent.BASELINE_OFFSET_SAME_AS_HEIGHT);
            xLbl.setText(Settings.getInstance().getxScore().toString());
            xLbl.setTextFill(Color.web("#88001b", 1));

            oImgV.setImage(Settings.OLETTER);
            oImgV.setFitHeight(Parent.BASELINE_OFFSET_SAME_AS_HEIGHT);
            oLbl.setText(Settings.getInstance().getoScore().toString());
            oLbl.setTextFill(Color.web("#000000", 1));


        } else {
            xImgV.setImage(Settings.XLETTER);
            xImgV.setFitHeight(Parent.BASELINE_OFFSET_SAME_AS_HEIGHT);
            xLbl.setText(Settings.getInstance().getxScore().toString());
            xLbl.setTextFill(Color.web("#000000", 1));

            oImgV.setImage(Settings.OLETTERRED);
            oImgV.setFitHeight(Parent.BASELINE_OFFSET_SAME_AS_HEIGHT);
            oLbl.setText(Settings.getInstance().getoScore().toString());
            oLbl.setTextFill(Color.web("#88001b", 1));
        }

    }


    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void settingsMenu() {
        mainController.loadSettingsScreen();
    }

    @FXML
    public void image00Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image00.getImage())) {
            image00.setImage(Settings.getInstance().getPlayer());
            System.out.println("image " + image00.getImage());
            System.out.println("player " + Settings.getInstance().getPlayer());
            System.out.println("xletter" + Settings.XLETTER.equals(image00.getImage()));


            gameLogicForButton();
        }
    }

    public void gameLogicForButton() {
        checkLine();
        if (Settings.getInstance().isSoloGame()) {
            logicForSoloGame();
        } else {
            logicForDuoGame();
        }
    }

    public void logicForDuoGame() {
        changePlayer();
        initScoreBoard();
    }


    public void changePlayer() {
        Image tmpImage = Settings.getInstance().getPlayer();
        Image tmpImageRed = Settings.getInstance().getPlayerRed();
        Settings.getInstance().setPlayer(Settings.getInstance().getComputer());
        Settings.getInstance().setPlayerRed(Settings.getInstance().getComputerRed());
        Settings.getInstance().setComputer(tmpImage);
        Settings.getInstance().setComputerRed(tmpImageRed);
    }

    @FXML
    public void image01Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image01.getImage())) {
            image01.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image02Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image02.getImage())) {
            image02.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image10Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image10.getImage())) {
            image10.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image11Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image11.getImage())) {
            image11.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image12Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image12.getImage())) {
            image12.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image20Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image20.getImage())) {
            image20.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image21Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image21.getImage())) {
            image21.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    @FXML
    public void image22Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image22.getImage())) {
            image22.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
    }

    public void logicForSoloGame() {
        computerMove();
        checkLine();
        checkIfGameIsFinished();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void play() {

        Settings.getInstance().setEndGame(false);
        image00.setImage(Settings.TRANSP);
        //image00.setScaleX(0.1);
        image01.setImage(Settings.TRANSP);
        image02.setImage(Settings.TRANSP);
        image10.setImage(Settings.TRANSP);
        image11.setImage(Settings.TRANSP);
        image12.setImage(Settings.TRANSP);
        image20.setImage(Settings.TRANSP);
        image21.setImage(Settings.TRANSP);
        image22.setImage(Settings.TRANSP);

        if (Settings.getInstance().isSoloGame()) {
            initFirstMove();
        }
    }


    public void checkLine() {
        System.out.println("Sprawdzam linię");
        if (Settings.getInstance().isEndGame()) {
            return;
        }
        if (image00.getImage().equals(image01.getImage())
                && image01.getImage().equals(image02.getImage())
                && !Settings.TRANSP.equals(image00.getImage())) {
            image00.setImage(changeImage(image00.getImage()));
            image01.setImage(changeImage(image01.getImage()));
            image02.setImage(changeImage(image02.getImage()));
            addPoint(figure(image00.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();

        } else if (image10.getImage().equals(image11.getImage())
                && image11.getImage().equals(image12.getImage())
                && !Settings.TRANSP.equals(image10.getImage())) {
            System.out.println("LINIA");
            image10.setImage(changeImage(image10.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image12.setImage(changeImage(image12.getImage()));
            addPoint(figure(image10.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        } else if (image20.getImage().equals(image21.getImage())
                && image21.getImage().equals(image22.getImage())
                && !Settings.TRANSP.equals(image20.getImage())) {
            System.out.println("LINIA");
            image20.setImage(changeImage(image20.getImage()));
            image21.setImage(changeImage(image21.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            addPoint(figure(image20.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        } else if (image00.getImage().equals(image10.getImage())
                && image10.getImage().equals(image20.getImage())
                && !Settings.TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image10.setImage(changeImage(image10.getImage()));
            image20.setImage(changeImage(image20.getImage()));
            addPoint(figure(image00.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        } else if (image01.getImage().equals(image11.getImage())
                && image11.getImage().equals(image21.getImage())
                && !Settings.TRANSP.equals(image01.getImage())) {
            System.out.println("LINIA");
            image01.setImage(changeImage(image01.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image21.setImage(changeImage(image21.getImage()));
            addPoint(figure(image01.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        } else if (image02.getImage().equals(image12.getImage())
                && image12.getImage().equals(image22.getImage())
                && !Settings.TRANSP.equals(image02.getImage())) {
            System.out.println("LINIA");
            image02.setImage(changeImage(image02.getImage()));
            image12.setImage(changeImage(image12.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            addPoint(figure(image02.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        } else if (image00.getImage().equals(image11.getImage())
                && image11.getImage().equals(image22.getImage())
                && !Settings.TRANSP.equals(image00.getImage())) {
            System.out.println("LINIA");
            image00.setImage(changeImage(image00.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image22.setImage(changeImage(image22.getImage()));
            addPoint(figure(image00.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        } else if (image02.getImage().equals(image11.getImage())
                && image11.getImage().equals(image20.getImage())
                && !Settings.TRANSP.equals(image02.getImage())) {
            System.out.println("LINIA");
            image02.setImage(changeImage(image02.getImage()));
            image11.setImage(changeImage(image11.getImage()));
            image20.setImage(changeImage(image20.getImage()));
            addPoint(figure(image02.getImage()));
            Settings.getInstance().setEndGame(true);
            Settings.getInstance().reverseStartingFigure();
        }
    }

    public Image changeImage(Image image) {
        if (Settings.XLETTER.getUrl().equals(image.getUrl())) {
            return Settings.XLETTERRED;
        } else {
            return Settings.OLETTERRED;
        }
    }

    public void addPoint(String figure) {
        if ("x".equals(figure)) {
            Settings.getInstance().setxScore(Settings.getInstance().getxScore() + 1);
            xLbl.setText(Settings.getInstance().getxScore().toString());
        } else {
            Settings.getInstance().setoScore(Settings.getInstance().getoScore() + 1);
            oLbl.setText(Settings.getInstance().getoScore().toString());
        }

    }

    public String figure(Image image) {
        if (Settings.XLETTER.equals(image) || Settings.XLETTERRED.equals(image)) {
            return "x";
        } else {
            return "o";
        }
    }

    public void computerMove() {
        if (Settings.HARD.equals(Settings.getInstance().getLevel())) {
            winStrategyMove();
        } else if (Settings.MEDIUM.equals(Settings.getInstance().getLevel())) {
            blockingStrategyMove();
        } else if (Settings.EASY.equals(Settings.getInstance().getLevel())) {
            randomComputerMove();
        } else {
            randomComputerMove();
        }
    }

    public void randomComputerMove() {
        Image computer = Settings.getInstance().getComputer();


        if (Settings.TRANSP.equals(image11.getImage())) {
            image11.setImage(computer);
        } else if (Settings.TRANSP.equals(image01.getImage())) {
            image01.setImage(computer);
        } else if (Settings.TRANSP.equals(image10.getImage())) {
            image10.setImage(computer);
        } else if (Settings.TRANSP.equals(image22.getImage())) {
            image22.setImage(computer);
        } else if (Settings.TRANSP.equals(image00.getImage())) {
            image00.setImage(computer);
        } else if (Settings.TRANSP.equals(image02.getImage())) {
            image02.setImage(computer);
        } else if (Settings.TRANSP.equals(image12.getImage())) {
            image12.setImage(computer);
        } else if (Settings.TRANSP.equals(image20.getImage())) {
            image20.setImage(computer);
        } else if (Settings.TRANSP.equals(image21.getImage())) {
            image21.setImage(computer);
        } else {
            System.out.println("PROBLEM");
        }
        System.out.println("endGame: " + Settings.getInstance().isEndGame());

    }

    public void blockingStrategyMove() {
        Image player = Settings.getInstance().getPlayer();
        Image computer = Settings.getInstance().getComputer();
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

    public void winStrategyMove() {
        Image computer = Settings.getInstance().getComputer();
        if (checkLineToBlock(computer, image00, image01, image02).getaBoolean()) {
            checkLineToBlock(computer, image00, image01, image02).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image10, image11, image12).getaBoolean()) {
            checkLineToBlock(computer, image10, image11, image12).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image20, image21, image22).getaBoolean()) {
            checkLineToBlock(computer, image20, image21, image22).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image00, image10, image20).getaBoolean()) {
            checkLineToBlock(computer, image00, image10, image20).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image01, image11, image21).getaBoolean()) {
            checkLineToBlock(computer, image01, image11, image21).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image02, image12, image22).getaBoolean()) {
            checkLineToBlock(computer, image02, image12, image22).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image00, image11, image22).getaBoolean()) {
            checkLineToBlock(computer, image00, image11, image22).getImageView().setImage(computer);
        } else if (checkLineToBlock(computer, image20, image11, image02).getaBoolean()) {
            checkLineToBlock(computer, image20, image11, image02).getImageView().setImage(computer);
        } else {
            blockingStrategyMove();
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
            if (Settings.TRANSP.equals(image1.getImage())) {
                return new ExtendedImageView(image1, tmpBoolean);
            } else if (Settings.TRANSP.equals(image2.getImage())) {
                return new ExtendedImageView(image2, tmpBoolean);
            } else if (Settings.TRANSP.equals(image3.getImage())) {
                return new ExtendedImageView(image3, tmpBoolean);
            }
        } else {
            tmpBoolean = false;
            return new ExtendedImageView(image1, tmpBoolean);
        }
        return new ExtendedImageView(new ImageView(), false);
    }

}
