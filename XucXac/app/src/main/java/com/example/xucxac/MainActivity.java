package com.example.xucxac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.Random;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView roll;
    ImageView imgResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCotrol();
        imgResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
                animation.start();
                RollDice();
            }
        });
    }

    private void RollDice() {
        Random random = new Random();
        int randomInt = random.nextInt(6) + 1;
        int drawableImage;
        switch (randomInt) {
            case 1:
                drawableImage = R.drawable.dice_1;
                break;
            case 2:
                drawableImage = R.drawable.dice_2;
                break;
            case 3:
                drawableImage = R.drawable.dice_3;
                break;
            case 4:
                drawableImage = R.drawable.dice_4;
                break;
            case 5:
                drawableImage = R.drawable.dice_5;
                break;
            default:
                drawableImage = R.drawable.dice_6;
        }

        String tvText = String.valueOf(randomInt);

// Assuming resultImages is an ImageView
        imgResult.setImageResource(drawableImage);
        roll.setText("Dice Roll " + tvText);
        Toast.makeText(this, "Dice Roll ", Toast.LENGTH_SHORT).show();
    }

    public void addCotrol(){
        roll = findViewById(R.id.txtRoll);
        imgResult = findViewById(R.id.imgDice);
    }
}