package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Button log;
    ArrayList<UserModel> users;
//    HashMap<String, UserModel> userTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.et_Login);
        password = findViewById(R.id.et_Password);
        log = findViewById(R.id.btn_Login);
        users = new Utils().getUsers();

//        userTypes.put("ENGINEER", users.get(0));
//
//        UserModel userEngineer = userTypes.get("ENGINEER");

        log.setOnClickListener(v -> {
            if (checkLogin(login.getText().toString(), password.getText().toString())) {
                startActivity();
            } else {
                Toast.makeText(this, "Логин или пароль были введены неправильно", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Переход на ThirdActivity
    private void startActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean checkLogin(String logins, String password) {
        for (UserModel userModel : users) {
            if (userModel.getLogUser().equals(logins) && userModel.getPassUser().equals(password)) {
                return true;
            }
        }
        return false;
    }

}