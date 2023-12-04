package com.example.sdco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void bt(View view) {
        Intent i = new Intent(MainActivity2.this, s.class);
        startActivity(i);
    }

    public void bt2(View view) {
        Intent i = new Intent(MainActivity2.this, d.class);
        startActivity(i);
    }

    public void bt3(View view) {
        Intent i = new Intent(MainActivity2.this, c.class);
        startActivity(i);
    }

    public void bt4(View view) {

        Intent i = new Intent(MainActivity2.this, mdo.class);
        startActivity(i);
    }
}