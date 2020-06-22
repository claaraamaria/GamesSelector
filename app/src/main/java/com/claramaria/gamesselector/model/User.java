package com.claramaria.gamesselector.model;

public class User {


    private int userId;
    private String name;
    private String email;
    private String telephone;
    private String userName;
    private String imageUrl;
    private String pass;

    public User(int userId, String userName, String name, String telephone, String email, String imageUrl, String pass) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.telephone = telephone;
        this.imageUrl = imageUrl;
        this.pass = pass;
    }

    public int getUserId() {
        return userId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
