package com.kodilla.first.individual.project.controllers;

import com.kodilla.first.individual.project.Logic.Settings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


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
    Button playDuoGameBtn;
    @FXML
    ImageView xImgV;
    @FXML
    ImageView oImgV;
    @FXML
    Label xLbl;
    @FXML
    Label oLbl;

    public void initScoreBoard() {

        if (Settings.XLETTER.getUrl().equals(Settings.getInstance().getPlayer().getUrl())){
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
    public void resetScore(){
        Settings.getInstance().resetScore();
        initScoreBoard();
    }

    @FXML
    public void initialize() {
        initScoreBoard();
        choiceBoxInit();
        menuInit();

    }

    @FXML
    public void playDuoGame(){

    }

    @FXML
    public void playDuoGameBtnMouseEntered(){

    }

    @FXML
    public void playDuoGameBtnMouseExited(){

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void easyOnClick() {
        easyBtn.setDefaultButton(true);
        mediumBtn.setDefaultButton(false);
        hardBtn.setDefaultButton(false);
        Settings.getInstance().setLevel(Settings.EASY);
    }

    @FXML
    public void mediumOnClick() {
        easyBtn.setDefaultButton(false);
        mediumBtn.setDefaultButton(true);
        hardBtn.setDefaultButton(false);
        Settings.getInstance().setLevel(Settings.MEDIUM);
    }

    @FXML
    public void hardOnClick() {
        easyBtn.setDefaultButton(false);
        mediumBtn.setDefaultButton(false);
        hardBtn.setDefaultButton(true);
        Settings.getInstance().setLevel(Settings.HARD);
    }

    @FXML
    public void oneOnClick() {
        oneBtn.setDefaultButton(true);
        threeBtn.setDefaultButton(false);
        fiveBtn.setDefaultButton(false);
        Settings.getInstance().setNumberOfGames(1);
    }

    @FXML
    public void threeOnClick() {
        oneBtn.setDefaultButton(false);
        threeBtn.setDefaultButton(true);
        fiveBtn.setDefaultButton(false);
        Settings.getInstance().setNumberOfGames(3);

    }

    @FXML
    public void fiveOnClick() {
        oneBtn.setDefaultButton(false);
        threeBtn.setDefaultButton(false);
        fiveBtn.setDefaultButton(true);
        Settings.getInstance().setNumberOfGames(5);

    }

    @FXML
    public void playSinglePlayer() {
        mainController.loadSinglePlayerScreen();
    }

    @FXML
    public void scoreBtnMouseEntered() {
        //Button button = this.getClass().
        resetBtn.setDefaultButton(true);
    }

    @FXML
    public void scoreBtnMouseExited() {
        //Button button = this.getClass().
        resetBtn.setDefaultButton(false);
    }

    @FXML
    public void playSinglePlayerBtnMouseEntered() {
        playSinglePlayerBtn.setDefaultButton(true);
    }

    @FXML
    public void playSinglePlayerBtnMouseExited() {
        playSinglePlayerBtn.setDefaultButton(false);
    }

    @FXML
    public void menuBtnMouseEntered() {
        menuBtn.setDefaultButton(true);
    }

    @FXML
    public void menuBtnMouseExited() {
        menuBtn.setDefaultButton(false);
    }

    @FXML
    public void imageViewOfStartingFigureOnClicked(){
        if (Settings.XLETTERRED.getUrl().equals(imageViewOfStartingFigure.getImage().getUrl())){
            choiceBoxOfStartingFigure.setValue(Settings.getInstance().getNameOfImage(Settings.OLETTER));
        } else{
            choiceBoxOfStartingFigure.setValue(Settings.getInstance().getNameOfImage(Settings.XLETTER));
        }
    }

    @FXML
    public void imageViewOfPickedFigureOnClicked(){
        if (Settings.XLETTERRED.getUrl().equals(imageViewOfPickedFigure.getImage().getUrl())){
            choiceBoxOfPickedFigure.setValue(Settings.getInstance().getNameOfImage(Settings.OLETTER));
        } else{
            choiceBoxOfPickedFigure.setValue(Settings.getInstance().getNameOfImage(Settings.XLETTER));
        }
    }

    public void menuInit() {
        if (Settings.HARD.equals(Settings.getInstance().getLevel())) {
            hardBtn.setDefaultButton(true);
        } else if (Settings.MEDIUM.equals(Settings.getInstance().getLevel())) {
            mediumBtn.setDefaultButton(true);
        } else if (Settings.EASY.equals(Settings.getInstance().getLevel())) {
            easyBtn.setDefaultButton(true);
        }
        if (Settings.getInstance().getNumberOfGames() == 1) {
            oneBtn.setDefaultButton(true);
        } else if (Settings.getInstance().getNumberOfGames() == 3) {
            threeBtn.setDefaultButton(true);
        } else if (Settings.getInstance().getNumberOfGames() == 5) {
            fiveBtn.setDefaultButton(true);
        }

    }


    private void choiceBoxInit() {
        choiceBoxOfPickedFigure.getItems().add(Settings.OLETTERSTRING);
        choiceBoxOfPickedFigure.getItems().add(Settings.XLETTERSTRING);

        choiceBoxOfPickedFigure.setValue(Settings.getInstance().getNameOfImage(Settings.getInstance().getPlayerRed()));
        imageViewOfPickedFigure.setImage(Settings.getInstance().getPlayerRed());


        //Settings.getInstance().setPlayer(Settings.getInstance().getPlayer());
        //Settings.getInstance().setComputer(Settings.getInstance().getComputer());

        choiceBoxOfPickedFigure.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                //System.out.println(choiceBoxOfPickedFigure.getItems().get((Integer) t1));

                if (Settings.XLETTERSTRING.equals(choiceBoxOfPickedFigure.getItems().get((Integer) t1))) {
                    imageViewOfPickedFigure.setImage(Settings.XLETTERRED);
                    Settings.getInstance().setPlayer(Settings.XLETTER);
                    Settings.getInstance().setPlayerRed(Settings.XLETTERRED);
                    Settings.getInstance().setComputer(Settings.OLETTER);
                    Settings.getInstance().setComputerRed(Settings.OLETTERRED);
                } else {
                    imageViewOfPickedFigure.setImage(Settings.OLETTERRED);
                    Settings.getInstance().setPlayer(Settings.OLETTER);
                    Settings.getInstance().setPlayerRed(Settings.OLETTERRED);
                    Settings.getInstance().setComputer(Settings.XLETTER);
                    Settings.getInstance().setComputerRed(Settings.XLETTERRED);
                }
                initScoreBoard();
            }
        });

        choiceBoxOfStartingFigure.getItems().add(Settings.OLETTERSTRING);
        choiceBoxOfStartingFigure.getItems().add(Settings.XLETTERSTRING);

        choiceBoxOfStartingFigure.setValue(Settings.getInstance().getNameOfImage(Settings.getInstance().getStartingFigureRed()));
        imageViewOfStartingFigure.setImage(Settings.getInstance().getStartingFigureRed());
//
//        Settings.getInstance().setPlayer(Settings.XLETTER);
//        Settings.getInstance().setComputer(Settings.OLETTER);

        choiceBoxOfStartingFigure.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                //System.out.println(choiceBoxOfStartingFigure.getItems().get((Integer) t1));

                if (Settings.XLETTERSTRING.equals(choiceBoxOfStartingFigure.getItems().get((Integer) t1))) {
                    imageViewOfStartingFigure.setImage(Settings.XLETTERRED);
                    Settings.getInstance().setStartingFigure(Settings.XLETTER);
                    Settings.getInstance().setStartingFigureRed(Settings.XLETTERRED);
                } else {
                    imageViewOfStartingFigure.setImage(Settings.OLETTERRED);
                    Settings.getInstance().setStartingFigure(Settings.OLETTER);
                    Settings.getInstance().setStartingFigureRed(Settings.OLETTERRED);
                }
            }
        });
    }


}
