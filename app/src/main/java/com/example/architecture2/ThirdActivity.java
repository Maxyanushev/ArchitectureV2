package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonReset = findViewById(R.id.buttonReset);

        buttonReset.setOnClickListener(v -> {
            Intent intent3 = new Intent(this, MainActivity.class);
            startActivity(intent3);
        });
    }
}