package com.claramaria.gamesselector.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String telephone;
    private String userName;

    private String image;

    public User(int id, String userName, String name, String telephone, String email, String image) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.telephone = telephone;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
