package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.architecture2.Utils.logins;
import static com.example.architecture2.Utils.passwords;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Button log;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.et_Login);
        password = findViewById(R.id.et_Password);
        log = findViewById(R.id.btn_Login);
        reg = findViewById(R.id.btn_Reg);

        log.setOnClickListener(v -> {
            if(checkLogin(login.getText().toString()) && checkPassword(password.getText().toString())) {
                startActivity();
            }
            else{
                Toast.makeText(this, "Логин или пароль были введены неправильно", Toast.LENGTH_SHORT).show();
            }
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

    private boolean checkLogin(String logins) {
        boolean a=false;
        for(int i = 0; i< Utils.logins.size(); i++) {
            if(Utils.logins.get(i).equals(logins)) {
                a = true;
            } else {
                a = false;
            }
            if(a=true) {
                return a;
            } else {
                continue;
            }
        }
        return a;
    }

    private boolean checkPassword(String passwords) {
        boolean a=false;
        for(int i = 0; i< Utils.passwords.size(); i++) {
            if(Utils.passwords.get(i).equals(passwords)) {
                a = true;
            } else {
                a = false;
            }
            if(a=true) {
                return a;
            } else {
                continue;
            }
        }
        return a;
    }
}