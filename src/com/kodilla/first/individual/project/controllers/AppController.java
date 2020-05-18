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

    //ToDO
    //dodac czysty Screen po kliknieciu reste planszy
    //usunac paczke sample
    //oczyscic i uprościc kod jak się da

    @FXML
    public void initialize() {
        initScoreBoard();
        play();
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

    public void clearGameBoard() {
        image00.setImage(Settings.TRANSP);
        image01.setImage(Settings.TRANSP);
        image02.setImage(Settings.TRANSP);
        image10.setImage(Settings.TRANSP);
        image11.setImage(Settings.TRANSP);
        image12.setImage(Settings.TRANSP);
        image20.setImage(Settings.TRANSP);
        image21.setImage(Settings.TRANSP);
        image22.setImage(Settings.TRANSP);
    }

    @FXML
    public void play() {
        Settings.getInstance().setEndGame(false);
        clearGameBoard();
        if (Settings.getInstance().isSoloGame()) {
            initComputerFirstMove();
        }
    }

    public void initComputerFirstMove() {
        if (!Settings.getInstance().getStartingFigure().getUrl().equals(Settings.getInstance().getPlayer().getUrl())) {
            image11.setImage(Settings.getInstance().getComputer());
        }
    }

    public void refreshScoreBoard() {
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


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void checkOneLine(ImageView imageView1, ImageView imageView2, ImageView imageView3) {
        if (imageView1.getImage().equals(imageView2.getImage())
                && imageView2.getImage().equals(imageView3.getImage())
                && !Settings.TRANSP.equals(imageView1.getImage())
                && !Settings.getInstance().isEndGame()) {
            imageView1.setImage(changeImage(imageView1.getImage()));
            imageView2.setImage(changeImage(imageView2.getImage()));
            imageView3.setImage(changeImage(imageView3.getImage()));
            if (!Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getxScore())
                    || !Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getoScore())) {
                mainController.loadCleanScreen();
            }
            addPoint(figure(imageView1.getImage()));
            Settings.getInstance().setEndGame(true);
            checkIfGameIsFinished();
            refreshScoreBoard();
            Settings.getInstance().reverseStartingFigure();
        }
    }

    public void checkLines() {
        checkOneLine(image00, image01, image02);
        checkOneLine(image10, image11, image12);
        checkOneLine(image20, image21, image22);
        checkOneLine(image00, image10, image20);
        checkOneLine(image01, image11, image21);
        checkOneLine(image02, image12, image22);
        checkOneLine(image00, image11, image22);
        checkOneLine(image02, image11, image20);
    }

    public void checkIfGameIsFinished() {
        if (Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getxScore())
                || Settings.getInstance().getNumberOfGames().equals(Settings.getInstance().getoScore())) {
            mainController.loadFinishScreen();
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
        } else {
            easyComputerMove();
        }
    }

    public void easyComputerMove() {
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
        }
    }

    public void blockingStrategyMove() {
        commonComputerStrategy("MEDIUM");
    }

    public void winStrategyMove() {
        commonComputerStrategy("HARD");
    }

    public void commonComputerStrategy(String strategy) {
        Image imageToCheck = Settings.getInstance().getComputer();
        if ("MEDIUM".equals(strategy)) {
            imageToCheck = Settings.getInstance().getPlayer();
        }
        Image imageToSet = Settings.getInstance().getComputer();
        if (checkLineForComputerStrategy(imageToCheck, image00, image01, image02).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image00, image01, image02).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image10, image11, image12).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image10, image11, image12).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image20, image21, image22).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image20, image21, image22).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image00, image10, image20).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image00, image10, image20).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image01, image11, image21).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image01, image11, image21).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image02, image12, image22).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image02, image12, image22).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image00, image11, image22).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image00, image11, image22).getImageView().setImage(imageToSet);
        } else if (checkLineForComputerStrategy(imageToCheck, image20, image11, image02).getaBoolean()) {
            checkLineForComputerStrategy(imageToCheck, image20, image11, image02).getImageView().setImage(imageToSet);
        } else {
            if ("HARD".equals(strategy)) {
                blockingStrategyMove();
            } else {
                easyComputerMove();
            }
        }
    }

    public ExtendedImageView checkLineForComputerStrategy(Image pattern, ImageView image1, ImageView image2, ImageView image3) {
        int counter = 0;
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
            if (Settings.TRANSP.equals(image1.getImage())) {
                return new ExtendedImageView(image1, true);
            } else if (Settings.TRANSP.equals(image2.getImage())) {
                return new ExtendedImageView(image2, true);
            } else if (Settings.TRANSP.equals(image3.getImage())) {
                return new ExtendedImageView(image3, true);
            }
        } else {
            return new ExtendedImageView(image1, false);
        }
        return new ExtendedImageView(new ImageView(), false);
    }

    public void logicForSoloGame() {
        checkLines();
        if (!Settings.getInstance().isEndGame()) {
            computerMove();
        }
    }

    public void logicForDuoGame() {
        changePlayer();
    }

    public void gameLogicForButton() {

        if (Settings.getInstance().isSoloGame()) {
            logicForSoloGame();
        } else {
            logicForDuoGame();
        }
        checkLines();
    }

    @FXML
    public void image00Clicked() {
        if (!Settings.getInstance().isEndGame() && Settings.TRANSP.equals(image00.getImage())) {
            image00.setImage(Settings.getInstance().getPlayer());
            gameLogicForButton();
        }
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

    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void settingsMenu() {
        mainController.loadSettingsScreen();
    }

}