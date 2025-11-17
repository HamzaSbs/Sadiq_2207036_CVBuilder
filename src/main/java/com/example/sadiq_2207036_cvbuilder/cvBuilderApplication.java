package com.example.sadiq_2207036_cvbuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class cvBuilderApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(cvBuilderApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(loader.load(), 600, 600);
        stage.setTitle("CV Builder 2207036");
        stage.setScene(scene);
        stage.show();
    }
}
