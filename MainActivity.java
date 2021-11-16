package com.example.mymemorygame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int notAvtive = Color.parseColor("#b1e3be");
    int active = Color.parseColor("#a2e8e6");

    Button e,m,h;
    public static int lvl = 0;
    Intent i1 = new Intent("android.intent.action.GAME");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.easy);
        m = findViewById(R.id.medium);
        h = findViewById(R.id.hard);

        e.setBackgroundColor(notAvtive);
        m.setBackgroundColor(notAvtive);
        h.setBackgroundColor(notAvtive);

    }

    public void Easy(View view) {
        lvl = 1;
        e.setBackgroundColor(active);
        startActivity(i1);

    }

    public void Medium(View view) {
        lvl = 2;
        m.setBackgroundColor(active);
        startActivity(i1);

    }

    public void Hard(View view) {
        lvl = 3;
        h.setBackgroundColor(active);
        startActivity(i1);

    }

    public static int getlvl(){
        return lvl;
    }
}