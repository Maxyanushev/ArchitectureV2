package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

//import static com.example.architecture2.Utils.logins;
//import static com.example.architecture2.Utils.passwords;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Button log;
    Button reg;
    ArrayList<UserModel> users;
    HashMap<String, UserModel> userTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.et_Login);
        password = findViewById(R.id.et_Password);
        log = findViewById(R.id.btn_Login);
        reg = findViewById(R.id.btn_Reg);
        users = new Utils().getUsers();

        userTypes.put("ENGINEER", users.get(2));

        UserModel userEngineer = userTypes.get("ENGINEER");

        log.setOnClickListener(v -> {
            if(checkLogin(login.getText().toString(), password.getText().toString())) {
                System.out.println("1");
                startActivity();
            }
            System.out.println("2");
//            else{
//                Toast.makeText(this, "Логин или пароль были введены неправильно", Toast.LENGTH_SHORT).show();
//            }
        });

        reg.setOnClickListener(v -> registr());
    }

    // Переход на SecondActivity
    private void startActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    // Переход на RegistrationActivity
    private void registr() {
        Intent intent1 = new Intent(this, RegistrationActivity.class);
        startActivity(intent1);
        finish();
    }

    private boolean checkLogin(String logins, String password) {
        for (UserModel userModel : users) {
            if (userModel.getLogUser().equals(logins) && userModel.getPassUser().equals(password)) return true;
        }
        return false;
//        boolean a=false;
//        for(int i = 0; i< Utils.logins.size(); i++) {
//            if(Utils.logins.get(i).equals(logins)) {
//                a = true;
//            } else {
//                a = false;
//            }
//            if(a=true) {
//                return a;
//            } else {
//                continue;
//            }
//        }
//        return a;
    }

//    private boolean checkPassword(String passwords) {
//        return true;
//////        boolean a=false;
//////        for(int i = 0; i< Utils.passwords.size(); i++) {
//////            if(Utils.passwords.get(i).equals(passwords)) {
//////                a = true;
//////            } else {
//////                a = false;
//////            }
//////            if(a=true) {
//////                return a;
//////            } else {
//////                continue;
//////            }
//////        }
//////        return a;
//    }
}