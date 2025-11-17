package com.example.sadiq_2207036_cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private void goToCVForm(ActionEvent event) throws IOException {
        Parent cvForm = FXMLLoader.load(getClass().getResource("/com/example/sadiq_2207036_cvbuilder/cv-view.fxml"));
        Scene scene = new Scene(cvForm);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
