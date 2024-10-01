package com.app.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HealthDiaryApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/app/menu.fxml"));
        primaryStage.setTitle("My Health Diary");
        primaryStage.setScene(new Scene(root, 335, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
