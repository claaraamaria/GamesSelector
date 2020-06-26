package com.claramaria.gamesselector.model;

public class User {

    private int userId;
    private String name;
    private String email;
    private String telephone;
    private String userName;
    private String imageUrl;
    private String password;

    public User() {
    }

    /*public User(int userId, String userName, String name, String telephone, String email, String imageUrl, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.telephone = telephone;
        this.imageUrl = imageUrl;
        this.password = password;
    }*/

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
