package com.claramaria.gamesselector;

public class Data {

    private final String description;

    private final int imagePath;

    public Data(int imagePath, String description) {
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
