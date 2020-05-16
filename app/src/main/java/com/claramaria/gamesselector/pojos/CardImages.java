package com.claramaria.gamesselector.pojos;

public class CardImages {
    private final String description;
    private final int imagePath;

    public CardImages(int imagePath, String description) {
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
