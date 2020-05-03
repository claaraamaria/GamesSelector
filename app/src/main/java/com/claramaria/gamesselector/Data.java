package com.claramaria.gamesselector;

public class Data {

    private final String description;

    private final String imagePath;

    public Data(String imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

}
