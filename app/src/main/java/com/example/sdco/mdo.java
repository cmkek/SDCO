package com.example.sdco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class mdo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo);
    }

    public void burbuja(View view) {
        Intent i = new Intent(this, b.class);
        startActivity(i);
    }

    public void wit(View view) {
        Intent i = new Intent(this, q.class);
        startActivity(i);
    }
}