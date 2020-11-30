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
    private static int splash_screen = 4000;

    ImageView ivGlobalG, ivGlobalLOne, ivGlobalO, ivGlobalB, ivGlobalA, ivGlobalLTwo,
            ivTacticsTOne, ivTacticsA, ivTacticsCOne, ivTacticsTTwo, ivTacticsI, ivTacticsCTwo, ivTacticsS,
            topLine, bottomLine;

    Animation fromTop, fromBottom, fromLeft, fromRight, fromTopLeft, fromBottomLeft, fromBottomRight,
            fromTopRight, rotate, letter_g, letter_l_one, letter_b, letter_a_one, letter_l_two, letter_t_one,
            letter_a_two, letter_c_one, letter_t_two, letter_i_one, letter_c_two, letter_s;

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
        letter_g = AnimationUtils.loadAnimation(this, R.anim.letter_g);
        letter_l_one = AnimationUtils.loadAnimation(this, R.anim.letter_l_one);
        letter_b = AnimationUtils.loadAnimation(this, R.anim.letter_b);
        letter_a_one = AnimationUtils.loadAnimation(this, R.anim.letter_a_one);
        letter_l_two = AnimationUtils.loadAnimation(this, R.anim.letter_l_two);
        letter_t_one = AnimationUtils.loadAnimation(this, R.anim.letter_t_one);
        letter_a_two = AnimationUtils.loadAnimation(this, R.anim.letter_a_two);
        letter_c_one = AnimationUtils.loadAnimation(this, R.anim.letter_c_one);
        letter_t_two = AnimationUtils.loadAnimation(this, R.anim.letter_t_two);
        letter_i_one = AnimationUtils.loadAnimation(this, R.anim.letter_i);
        letter_c_two = AnimationUtils.loadAnimation(this, R.anim.letter_c_two);
        letter_s = AnimationUtils.loadAnimation(this, R.anim.letter_s);

        // set the animations
        topLine.setAnimation(fromLeft);
        ivGlobalG.setAnimation(letter_g);
        ivGlobalLOne.setAnimation(letter_l_one);
        ivGlobalO.setAnimation(rotate);
        ivGlobalB.setAnimation(letter_b);
        ivGlobalA.setAnimation(letter_a_one);
        ivGlobalLTwo.setAnimation(letter_l_two);
        ivTacticsTOne.setAnimation(letter_t_one);
        ivTacticsA.setAnimation(letter_a_two);
        ivTacticsCOne.setAnimation(letter_c_one);
        ivTacticsTTwo.setAnimation(letter_t_two);
        ivTacticsI.setAnimation(letter_i_one);
        ivTacticsCTwo.setAnimation(letter_c_two);
        ivTacticsS.setAnimation(letter_s);
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