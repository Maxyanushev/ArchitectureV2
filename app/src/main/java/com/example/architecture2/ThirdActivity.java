package com.example.architecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    Editable str;
    String strs;
    String result = "";

    EditText phone;

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

    Editable x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        phone = findViewById(R.id.editTextTextPersonName4);
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

            if(phone.getText().equals("")) {
                phone.setText("1");
            } else {
                x = phone.getText();
                phone.setText(x +"1");
            }
        });

        btn2.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("4");
            } else {
                x = phone.getText();
                phone.setText(x +"4");
            }
        });

        btn3.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("7");
            } else {
                x = phone.getText();
                phone.setText(x + "7");
            }
        });

        btn4.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("*");
            } else {
                x = phone.getText();
                phone.setText(x + "*");
            }
        });

        btn5.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("2");
            } else {
                x = phone.getText();
                phone.setText(x + "2");
            }
        });

        btn6.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("5");
            } else {
                x = phone.getText();
                phone.setText(x + "5");
            }
        });

        btn7.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("8");
            } else {
                x = phone.getText();
                phone.setText(x + "8");
            }
        });

        btn8.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("0");
            } else {
                x = phone.getText();
                phone.setText(x + "0");
            }
        });

        btn9.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("3");
            } else {
                x = phone.getText();
                phone.setText(x + "3");
            }
        });

        btn10.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("6");
            } else {
                x = phone.getText();
                phone.setText(x + "6");
            }
        });

        btn11.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText("9");
            } else {
                x = phone.getText();
                phone.setText(x + "9");
            }
        });

        btn12.setOnClickListener(v -> {
            if(phone.getText().equals("")) {
                phone.setText(".");
            } else {
                x = phone.getText();
                phone.setText(x + ".");
            }
        });

        btnDelete.setOnClickListener(v -> {

            /*
            Создали дейсвия при нажатии на кнопку "Стереть"
             */

            str = phone.getText();
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
            phone.setText(result);
            result = "";
        });
    }
}