package com.app.view;

import com.app.controller.UserController;
import com.app.model.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // Create the User object and UserController
        User user = new User();
        user.setID("001");
        user.setRoles("Admin");
        user.setUsername("user1");
        user.setPassword("pass123");

        UserController userController = new UserController(user);

        // Display the login scene
        Scene loginScene = userController.createLoginScene(primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
