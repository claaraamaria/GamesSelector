package com.claramaria.gamesselector.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                name.equals(user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(telephone, user.telephone) &&
                userName.equals(user.userName) &&
                Objects.equals(imageUrl, user.imageUrl) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, telephone, userName, imageUrl, password);
    }
}
