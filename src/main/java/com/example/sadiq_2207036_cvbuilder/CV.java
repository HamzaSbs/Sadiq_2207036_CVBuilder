package com.example.sadiq_2207036_cvbuilder;

import javafx.scene.image.Image;

public record CV(
        String fullName,
        String email,
        String phone,
        String address,
        String education,
        String skills,
        String experience,
        String projects,
        Image profileImage
) {}
