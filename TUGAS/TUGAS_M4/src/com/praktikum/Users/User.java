package com.praktikum.Users;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void displayInfo(){
    }

    public abstract boolean login(String username, String password);
    public abstract void displayAppMenu();
}
