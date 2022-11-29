package com.bkmovieapplication.business;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String passWord;
    private String email;

    public User() {
        userName = "";
        passWord = "";
        email = "";
    }

    public User(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public String getFirstName() {
        return userName;
    }

    public void setFirstName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return passWord;
    }

    public void setLastName(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
