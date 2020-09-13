package com.kodilla.first.individual.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("fxml/MainScreen.fxml"));

        Image image = new Image("file:resources/board1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setX(-60);

        Group root = new Group();
        StackPane stackPane = loader.load();

        root.getChildren().addAll(imageView);
        root.getChildren().add(stackPane);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Kółko i krzyżyk");
        primaryStage.show();
    }
}
