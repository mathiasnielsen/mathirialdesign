package com.example.kirkegaard.mathirialdesign.Features.Controls;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kirkegaard.mathirialdesign.R;

public class TextInputLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(
                R.anim.in_animation,
                R.anim.hide_behind_animation);

        setContentView(R.layout.activity_text_input_layout);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isFinishing())
        {
            overridePendingTransition(
                    R.anim.comes_back_animation,
                    R.anim.out_animation);
        }
    }
}
