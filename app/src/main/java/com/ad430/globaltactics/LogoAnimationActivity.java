package com.ad430.globaltactics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LogoAnimationActivity extends AppCompatActivity {
    //declare variables
    private static int splash_screen = 3500;

    ImageView ivGlobalG, ivGlobalLOne, ivGlobalO, ivGlobalB, ivGlobalA, ivGlobalLTwo,
            ivTacticsTOne, ivTacticsA, ivTacticsCOne, ivTacticsTTwo, ivTacticsI, ivTacticsCTwo, ivTacticsS,
            topLine, bottomLine;

    Animation fromTop, fromBottom, fromLeft, fromRight, fromTopLeft, fromBottomLeft, fromBottomRight,
            fromTopRight, rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_animation);

        // get the letters
        topLine = findViewById(R.id.ivTopLine);
        ivGlobalG = findViewById(R.id.ivGlobalG);
        ivGlobalLOne = findViewById(R.id.ivGlobalLOne);
        ivGlobalO = findViewById(R.id.ivGlobalO);
        ivGlobalB = findViewById(R.id.ivGlobalB);
        ivGlobalA = findViewById(R.id.ivGlobalA);
        ivGlobalLTwo = findViewById(R.id.ivGlobalLTwo);
        ivTacticsTOne = findViewById(R.id.ivTacticsTOne);
        ivTacticsA = findViewById(R.id.ivTacticsA);
        ivTacticsCOne = findViewById(R.id.ivTacticsCOne);
        ivTacticsTTwo = findViewById(R.id.ivTacticsTTwo);
        ivTacticsI = findViewById(R.id.ivTacticsI);
        ivTacticsCTwo = findViewById(R.id.ivTacticsCTwo);
        ivTacticsS = findViewById(R.id.ivTacticsS);
        bottomLine = findViewById(R.id.ivBottomLine);

        // get the animations
        fromTop = AnimationUtils.loadAnimation(this, R.anim.from_top);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fromLeft = AnimationUtils.loadAnimation(this, R.anim.from_left);
        fromRight = AnimationUtils.loadAnimation(this, R.anim.from_right);
        fromTopLeft = AnimationUtils.loadAnimation(this, R.anim.from_top_left);
        fromBottomLeft = AnimationUtils.loadAnimation(this, R.anim.from_bottom_left);
        fromBottomRight = AnimationUtils.loadAnimation(this, R.anim.from_bottom_right);
        fromTopRight = AnimationUtils.loadAnimation(this, R.anim.from_top_right);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        // set the animations
        topLine.setAnimation(fromLeft);
        ivGlobalG.setAnimation(fromTopLeft);
        ivGlobalLOne.setAnimation(fromTop);
        ivGlobalO.setAnimation(rotate);
        ivGlobalB.setAnimation(fromBottom);
        ivGlobalA.setAnimation(fromBottomLeft);
        ivGlobalLTwo.setAnimation(fromBottomRight);
        ivTacticsTOne.setAnimation(fromTopRight);
        ivTacticsA.setAnimation(fromTopRight);
        ivTacticsCOne.setAnimation(fromTop);
        ivTacticsTTwo.setAnimation(fromBottomLeft);
        ivTacticsI.setAnimation(fromBottomRight);
        ivTacticsCTwo.setAnimation(fromTopLeft);
        ivTacticsS.setAnimation(fromBottom);
        bottomLine.setAnimation(fromRight);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(splash_screen);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        timer.start();
    }
}