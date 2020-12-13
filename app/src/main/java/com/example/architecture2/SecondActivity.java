package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btn2start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn2start = findViewById(R.id.btn2start);

        btn2start.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, ThirdActivity.class);
            startActivity(intent2);

        });

    }
}