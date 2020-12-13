package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText logReg;
    EditText passReg;
    Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        logReg = findViewById(R.id.et_Login_reg);
        passReg = findViewById(R.id.et_Password_reg);
        registration = findViewById(R.id.btn_Registration);

        registration.setOnClickListener(v -> {
            if(logReg.length()>=3) {
                if (passReg.length()>=8) {
                    Utils.logins.add(logReg.getText().toString()); //Ввод логина в массив
                    Utils.passwords.add(passReg.getText().toString()); //Ввод пароля в массив
                    regReturn();
                }
                else {
                    Toast.makeText(this, "Пароль должен иметь не меньше 8 символов и иметь хотя бы одну большую букву", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Логин должен иметь не меньше 3 символов", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void regReturn() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}