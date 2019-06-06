package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;

import com.example.kirkegaard.mathirialdesign.R;

public class SharedTransactionBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_transaction_b);

        Slide slide = new Slide(Gravity.LEFT);
        slide.setDuration(2000);
        slide.addTarget(R.id.simple_activity_b_transtext);
        slide.excludeTarget(android.R.id.statusBarBackground, true);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(slide);
    }
}
