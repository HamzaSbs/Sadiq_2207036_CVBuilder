package com.example.sadiq_2207036_cvbuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class cvController {
    @FXML private TextField fullName;
    @FXML private TextField email;
    @FXML private TextField phone;
    @FXML private TextField address;
    @FXML private TextArea education;
    @FXML private TextArea skills;
    @FXML private TextArea experience;
    @FXML private TextArea projects;
    @FXML private ImageView profileImageView;
    @FXML private Button uploadPhotoButton;

    private File profileImageFile;

    @FXML
    private void generateCV() throws Exception {
        if (fullName.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all required fields.");
            alert.show();
            return;
        }

        Image profileImage = null;
        if (profileImageFile != null) {
            try (FileInputStream fis = new FileInputStream(profileImageFile)) {
                profileImage = new Image(fis);
            } catch (IOException e) {
                // ignore, image will be null
            }
        }

        CV cv = new CV(
                fullName.getText(),
                email.getText(),
                phone.getText(),
                address.getText(),
                education.getText(),
                skills.getText(),
                experience.getText(),
                projects.getText(),
                profileImage
        );

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cv-preview.fxml"));
        Scene previewScene = new Scene(loader.load(), 600, 650);

        cvPreviewController controller = loader.getController();
        controller.setCV(cv);

        Stage stage = (Stage) fullName.getScene().getWindow();
        stage.setScene(previewScene);
    }

    @FXML
    private void uploadPhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(profileImageView.getScene().getWindow());
        if (selectedFile != null) {
            profileImageFile = selectedFile;
            try (FileInputStream fis = new FileInputStream(selectedFile)) {
                Image image = new Image(fis);
                profileImageView.setImage(image);
            } catch (IOException e) {
                // Optionally show error
            }
        }
    }
}
