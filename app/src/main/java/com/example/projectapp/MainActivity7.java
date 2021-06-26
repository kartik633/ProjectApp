package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Button btnMenu = findViewById(R.id.btnMenu);

        CarouselView carouselView = findViewById(R.id.carso);
        carouselView.setPageCount(5);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                switch (position){
                    case 0:
                        imageView.setImageResource(R.drawable.chickenbiryani);
//                        imageView.setAdjustViewBounds(true);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.fishbiryani);
//                        imageView.setAdjustViewBounds(true);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.chickenkeema);
//                        imageView.setAdjustViewBounds(true);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.pannertikka);
//                        imageView.setAdjustViewBounds(true);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.vegbiryani);
//                        imageView.setAdjustViewBounds(true);
                        break;
                }
            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity7.this,"Clicked item" + position,Toast.LENGTH_SHORT).show();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity7.this,MainActivity.class));
            }
        });

    }
}