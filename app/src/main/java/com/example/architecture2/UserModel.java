package com.example.architecture2;

public class UserModel {
    private String password;
    private String login;

    public UserModel(String logUser, String passUser) {
        this.login = logUser;
        this.password = passUser;
    }

    public String getLogUser() {
        return login;
    }

    public void setLogUser(String logUser) {
        this.login = logUser;
    }

    public String getPassUser() {
        return password;
    }

    public void setPassUser(String passUser) {
        this.password = passUser;
    }
}
