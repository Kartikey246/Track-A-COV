package com.web;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane root = FXMLLoader.load(getClass().getResource("/com/web/sample.fxml"));
        primaryStage.setTitle("Track a cov");
        primaryStage.setScene(new Scene(root, 911, 583));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
