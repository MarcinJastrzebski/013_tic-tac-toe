package com.kodilla.first.individual.project.controllers;

import java.io.IOException;
import com.kodilla.first.individual.project.Logic.Settings;
import com.kodilla.first.individual.project.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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

    public void loadAppScreen() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/AppScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppController appController = loader.getController();
        appController.setMainController(this);
        ImageView imageView = new ImageView(new Image("file:resources/woodenBcg3.jpg"));
        imageView.setFitHeight(400);
        imageView.setY(130);
        setBackgroundAndScreen(imageView, pane);
    }

    public void loadSettingsScreen() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/SettingsScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SettingsController settingsController = loader.getController();
        settingsController.setMainController(this);
        ImageView imageView = new ImageView(new Image("file:resources/boardEmpty.png"));
        setBackgroundAndScreen(imageView, pane);
    }

    public void loadFinishScreen() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/FinishScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FinishController finishController = loader.getController();
        finishController.setMainController(this);
        ImageView imageView = new ImageView(new Image("file:resources/boardEmpty.png"));
        imageView.setOpacity(0.9);
        setScreenWithoutClearing(imageView, pane);
    }

    public void loadCleanScreen() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/CleanScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CleanController cleanController = loader.getController();
        cleanController.setMainController(this);
        ImageView imageView = new ImageView(new Image("file:resources/boardEmpty.png"));
        imageView.setOpacity(0.4);
        setScreenWithoutClearing(imageView, pane);
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

    public void setScreenWithoutClearing(ImageView imageView, Pane pane) {
        mainStackPane.getChildren().add(imageView);
        mainStackPane.getChildren().add(pane);
    }

    public void removeLastScreenWithoutClearing(Pane pane) {
        mainStackPane.getChildren().remove(mainStackPane.getChildren().size() - 1);
    }

    public static void initScoreImages(ImageView xImgV, Label xLbl, ImageView oImgV, Label oLbl) {
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
}