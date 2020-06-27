package com.claramaria.gamesselector.model;

public class CardImage {
    private final String description;
    private final int imagePath;

    public CardImage(int imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getImagePath() {
        return imagePath;
    }

}
