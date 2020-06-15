package com.claramaria.gamesselector.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String telephone;
    private String username;

    public User(int id, String username, String name, String telephone, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
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
}
