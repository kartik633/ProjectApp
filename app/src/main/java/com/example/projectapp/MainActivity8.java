package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        Button btnCounter = findViewById(R.id.btnCounter);
        TextView tvPricelay = findViewById(R.id.tvPricelay);

        String passedArg = getIntent().getExtras().getString("arg");
        tvPricelay.setText("Price: " + passedArg);

        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity8.this,MainActivity9.class));
            }
        });
    }
}