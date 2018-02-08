package com.example.kirkegaard.mathirialdesign.LottieAnimations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kirkegaard.mathirialdesign.R;

public class LottieAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_animations);

        // Good links
        // http://airbnb.io/lottie/android/android.html#getting-started

        // Set lottie programatically
        /*
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation("hello-world.json");
        animationView.loop(true);
        animationView.playAnimation();
        */
    }
}
