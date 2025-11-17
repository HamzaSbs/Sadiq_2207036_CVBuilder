package com.example.sadiq_2207036_cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;


public class cvPreviewController {
    @FXML private Label nameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label addressLabel;
    @FXML private TextArea educationLabel;
    @FXML private TextArea skillsLabel;
    @FXML private TextArea experienceLabel;
    @FXML private TextArea projectsLabel;
    @FXML private ImageView profileImageView;

    public void setCV(CV cv) {
        nameLabel.setText(cv.fullName());
        emailLabel.setText(cv.email());
        phoneLabel.setText(cv.phone());
        addressLabel.setText(cv.address());
        educationLabel.setText(cv.education());
        skillsLabel.setText(cv.skills());
        experienceLabel.setText(cv.experience());
        projectsLabel.setText(cv.projects());
        if (cv.profileImage() != null) {
            profileImageView.setImage(cv.profileImage());
        }
    }
}
