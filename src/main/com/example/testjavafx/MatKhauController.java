package main.com.example.testjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MatKhauController extends Application {

    @Override
    public void start(Stage primaryStage) {
        PasswordField passwordField = new PasswordField();
        Button showButton = new Button("Show Password");

        showButton.setOnAction(event -> {
            String password = passwordField.getText();
            System.out.println("Entered Password: " + password);
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(passwordField, showButton);

        Scene scene = new Scene(root, 300, 150);

        primaryStage.setTitle("Password Masking Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

