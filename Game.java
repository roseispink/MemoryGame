package com.example.mymemorygame;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {

    ArrayList<Button> buttons  = new ArrayList<>(5);
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
    boolean ifWin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);

        setVariable();

        for (int j = 0; j < count; j++) {
            queque[j] = 1 + r.nextInt(5);
        }

        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                for(Button butt : buttons){
                    butt.setBackgroundColor(notAvtive);
                }

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

                for(Button butt : buttons){
                    butt.setBackgroundColor(notAvtive);
                    butt.setText("Click");
                }

            }
        }.start();


    }

    public void onClickB1(View view) {
        if (ifPlay) {

            b1.setText(String.valueOf(number + 1));
            b1.setBackgroundColor(active);
            userOrder[number] = 1;
            number++;

            if (number == count) {
                toCheck();
                finishGame(b1);
            }
        }
    }

    public void onClickB2(View view) {
        if (ifPlay) {

            b2.setText(String.valueOf(number + 1));
            b2.setBackgroundColor(active);
            userOrder[number] = 2;
            number++;

            if (number == count) {
                toCheck();
                finishGame(b2);
            }
        }
    }

    public void onClickB3(View view) {
        if (ifPlay) {

            b3.setText(String.valueOf(number + 1));
            b3.setBackgroundColor(active);
            userOrder[number] = 3;
            number++;

            if (number == count) {
                toCheck();
                finishGame(b3);
            }


        }
    }

    public void onClickB4(View view) {
        if (ifPlay) {

            b4.setText(String.valueOf(number + 1));
            b4.setBackgroundColor(active);
            userOrder[number] = 4;
            number++;

            if (number == count) {
                toCheck();
                finishGame(b4);
            }


        }
    }

    public void onClickB5(View view) {
        if (ifPlay) {

            b5.setText(String.valueOf(number + 1));
            b5.setBackgroundColor(active);
            userOrder[number] = 5;
            number++;

            if (number == count) {
                toCheck();
                finishGame(b5);
            }


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

    public void toCheck() {
        for (int i = 0; i < count; i++) {
            if (userOrder[i] != queque[i]) ifWin = false;
        }
    }


    public void finishGame(Button button) {
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
        if(ifWin) alert.setTitle("WIN");
        else alert.setTitle("LOSE");
        alert.setPositiveButton("Play", (dialog, which) -> finish());

        alert.setNegativeButton("Leave", (dialog, which) -> {
            finishAffinity();
            System.exit(0);
        });

        alert.create().show();
    }

}

