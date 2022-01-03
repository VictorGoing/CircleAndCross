package com.kodilla.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    //File file = new File("resources/com/kodilla/game/Background2.png") ;



    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setScene(scene);
        if(getClass().getResourceAsStream("imagejpg.jpg") == null) System.out.println("null");
        else System.out.println("JEST!");
        try {
            Image imageBack = new Image(Objects.requireNonNull(getClass().getResourceAsStream("imagejpg.jpg")));
            ImageView imageView = new ImageView(imageBack);

            BackgroundSize backgroundSize = new BackgroundSize(100, 100,true, true, true, false);

            BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
            Background background = new Background(backgroundImage);

            Group root = new Group();
            root.getChildren().addAll(imageView);



            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
        }catch(NullPointerException e){
            System.out.println("Brak obrazu");
        }
        //Image imageBack = new Image("file:resources/Background2.png");



        stage.setHeight(600);
        stage.setWidth(800);
        stage.setTitle("CircleAndCross!");

        stage.show();
    }
}