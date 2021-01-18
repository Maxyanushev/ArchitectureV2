package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.architecture2.threads.SomeThing;
import com.example.architecture2.threads.SomeThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private SomeThread thread1;

    private static final int REQUEST_PHONE_CALL = 22222;

    EditText etPhone;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;

    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;

    Button btnDelete;

    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(100);


        etPhone = findViewById(R.id.editTextTextPersonName4);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);

        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);

        btnDelete = findViewById(R.id.button13);

        btnCall = findViewById(R.id.btnCall);

        /*
        Задали id каждому элементу экрана
         */

        btn1.setOnClickListener(v -> {

            /*
            Условный оператор "Когда нажали на кнопку (btn1.setOnClickListener)" спрашивает у нас, пусто ли сейчас поле ввода.
            Если так оно и есть, то мы выводим в поле ввода тот текст, который должа выводить эта кнопка.
            Если же нет, то в переменную "х" мы заносим весь текст, который на данный момент находиться в поле ввода.
            После чего мы проделываем всё то же самое, только перед этим ставим тот текст, что там был до этого
             */

            etPhone.setText(etPhone.getText().append("1"));

//            if(etPhone.getText().equals("")) {
//                etPhone.setText("1");
//            } else {
//                x = etPhone.getText();
//                etPhone.setText(x +"1");
//            }
        });

        btn2.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("4"));
        });

        btn3.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("7"));
        });

        btn4.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("*"));
        });

        btn5.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("2"));
        });

        btn6.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("5"));
        });

        btn7.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("8"));
        });

        btn8.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("0"));
        });

        btn9.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("3"));
        });

        btn10.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("6"));
        });

        btn11.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("9"));
        });

        btn12.setOnClickListener(v -> {
            etPhone.setText(etPhone.getText().append("."));
        });

        btnDelete.setOnClickListener(v -> {

            Editable str;
            String strs;
            String result = "";

            /*
            Создали дейсвия при нажатии на кнопку "Стереть"
             */

            str = etPhone.getText();
            strs = str.toString();

            /*
            Перевели данные поля ввода в строку
             */

            // Перевод строки в ArrayList
            List<String> myList = new ArrayList<String>(Arrays.asList(strs.split("")));

            myList.remove(myList.size()-1); // Удаление последнего элемента в поле ввода

            /*
            Возращаем конечный результат в поле ввода
             */

            for (String a : myList) {
                result = result + a;
            }
            etPhone.setText(result);

        });

        btnCall.setOnClickListener(v -> call(etPhone.getText().toString()));

        startThreads();
        setProgress();

    }

    private void setProgress() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i <= 100; i += 3) {
                progressBar.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("MyThread");
        thread.start();
    }

    private void startThreads() {
        // Запуск потока первый способ
        thread1 = new SomeThread();
        thread1.start();

        // Запуск потока второй способ (рекомендуется)
        SomeThing someThing = new SomeThing();
        Thread thread2 = new Thread(someThing);
        thread2.start();

        // Запуск потока третий способ
        Thread thread3 = new Thread(() -> System.out.println("Привет из потока №3"));

        // Запуск потока четвёртый способ
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет из потока №4");
            }
        });
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
        } else {
            startActivity(intent);

        }
    }
}