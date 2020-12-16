package com.example.architecture2;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public ArrayList<UserModel> users;

    public Utils() {
        users = new ArrayList<>();
        users.add(new UserModel("login1", "password1"));
        users.add(new UserModel("login2", "password2"));
        users.add(new UserModel("login3", "password3"));

    };

    public ArrayList<UserModel> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserModel> users) {
        this.users = users;
    }
}
