package com.app.controller;

import com.app.model.User;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserController {
    private User user;
    private boolean statusLogin = false;

    public UserController(User user) {
        this.user = user;
    }

    public Scene createLoginScene(Stage primaryStage) {
        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();
        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        Button btnLogin = new Button("Login");
        Label lblMessage = new Label();

        btnLogin.setOnAction(e -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                statusLogin = true;
                lblMessage.setText("Login successful!");
                primaryStage.setScene(createProfileScene(primaryStage));
            } else {
                lblMessage.setText("Invalid login credentials.");
            }
        });

        VBox vbox = new VBox(10, lblUsername, txtUsername, lblPassword, txtPassword, btnLogin, lblMessage);
        vbox.setStyle("-fx-padding: 20px;");

        Scene loginScene = new Scene(vbox, 300, 200);
        loginScene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());

        return loginScene;
    }

    public Scene createProfileScene(Stage primaryStage) {
        Label lblProfile = new Label("Profile Information");
        Label lblID = new Label("ID: " + user.getID());
        Label lblUsername = new Label("Username: " + user.getUsername());
        Label lblRoles = new Label("Roles: " + user.getRoles());
        Button btnLogout = new Button("Logout");

        btnLogout.setOnAction(e -> {
            statusLogin = false;
            primaryStage.setScene(createLoginScene(primaryStage));
        });

        VBox vbox = new VBox(10, lblProfile, lblID, lblUsername, lblRoles, btnLogout);
        vbox.setStyle("-fx-padding: 20px;");
        return new Scene(vbox, 300, 200);
    }
}
