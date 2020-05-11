package com.claramaria.gamesselector;

public class CardImagesData {
    private final String description;
    private final int imagePath;

    CardImagesData(int imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
    }

    String getDescription() {
        return description;
    }

    int getImagePath() {
        return imagePath;
    }

}
