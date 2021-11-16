package com.example.mymemorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button b1, b2, b3, b4, b5;
    int notAvtive = Color.parseColor("#b1e3be");
    int active = Color.parseColor("#a2e8e6");
    int level = MainActivity.getlvl();

    int time = 0;
    int count = 1;

    int[] queque = new int[10];
    int[] userOrder = new int[10];
    Random r = new Random();
    int number = 0;
    boolean ifPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);

        setVariable();

        for (int j = 0; j < count; j++) {
            queque[j] = 1 + r.nextInt(5);
        }

        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                b1.setBackgroundColor(notAvtive);
                b2.setBackgroundColor(notAvtive);
                b3.setBackgroundColor(notAvtive);
                b4.setBackgroundColor(notAvtive);
                b5.setBackgroundColor(notAvtive);

                System.out.println(number);


                switch (queque[number]) {
                    case 1:
                        b1.setBackgroundColor(active);
                        b1.setText(String.valueOf(number + 1));
                        break;
                    case 2:
                        b2.setBackgroundColor(active);
                        b2.setText(String.valueOf(number + 1));
                        break;
                    case 3:
                        b3.setBackgroundColor(active);
                        b3.setText(String.valueOf(number + 1));
                        break;
                    case 4:
                        b4.setBackgroundColor(active);
                        b4.setText(String.valueOf(number + 1));
                        break;
                    case 5:
                        b5.setBackgroundColor(active);
                        b5.setText(String.valueOf(number + 1));
                        break;
                    default:
                        break;
                }

                number++;

                if (number == count) {
                    number = 0;
                    ifPlay = true;
                }

            }

            @Override
            public void onFinish() {
                if (number != 0) number = 0;
                b1.setBackgroundColor(notAvtive);
                b2.setBackgroundColor(notAvtive);
                b3.setBackgroundColor(notAvtive);
                b4.setBackgroundColor(notAvtive);
                b5.setBackgroundColor(notAvtive);
                b1.setText("Click");
                b2.setText("Click");
                b3.setText("Click");
                b4.setText("Click");
                b5.setText("Click");

            }
        }.start();


    }

    public void onClickB1(View view) {
        if (ifPlay) {

            b1.setText(String.valueOf(number + 1));
            b1.setBackgroundColor(active);
            userOrder[number] = 1;
            number++;

            if (number == count) finishGame(b1, toCheck());
        }
    }

    public void onClickB2(View view) {
        if (ifPlay) {

            b2.setText(String.valueOf(number + 1));
            b2.setBackgroundColor(active);
            userOrder[number] = 2;
            number++;

            if (number == count) finishGame(b2, toCheck());
        }
    }

    public void onClickB3(View view) {
        if (ifPlay) {

            b3.setText(String.valueOf(number + 1));
            b3.setBackgroundColor(active);
            userOrder[number] = 3;
            number++;

            if (number == count) finishGame(b3, toCheck());


        }
    }

    public void onClickB4(View view) {
        if (ifPlay) {

            b4.setText(String.valueOf(number + 1));
            b4.setBackgroundColor(active);
            userOrder[number] = 4;
            number++;

            if (number == count) finishGame(b4, toCheck());


        }
    }

    public void onClickB5(View view) {
        if (ifPlay) {

            b5.setText(String.valueOf(number + 1));
            b5.setBackgroundColor(active);
            userOrder[number] = 5;
            number++;

            if (number == count) finishGame(b5, toCheck());


        }
    }

    public void setVariable() {
        if (this.level == 1) {
            time = 5000;
            count = 4;
        } else if (level == 2) {
            time = 8000;
            count = 7;
        } else if (level == 3) {
            time = 11000;
            count = 10;
        }
    }

    public boolean toCheck() {
        for (int i = 0; i < count; i++) {
            if (userOrder[i] != queque[i]) return false;
        }
        return true;
    }


    public void finishGame(Button button, boolean ifWin) {
        if (ifWin) {
            button.setTextColor(Color.parseColor("#ffffff"));
            button.setText("You win!!!");
            button.setBackgroundColor(Color.parseColor("#dbb251"));
        } else {
            button.setTextColor(Color.parseColor("#ffffff"));
            button.setText("You lose :(");
            button.setBackgroundColor(Color.parseColor("#000000"));
        }

            sentMessage();

    }

    public void sentMessage() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("You want to leave or play again?");
        alert.setTitle("Alert");
        alert.setPositiveButton("Play", (dialog, which) -> {
            finish();

        });

        alert.setNegativeButton("Leave", (dialog, which) -> {
            finishAffinity();
            System.exit(0);
        });

        alert.create().show();
    }

}

