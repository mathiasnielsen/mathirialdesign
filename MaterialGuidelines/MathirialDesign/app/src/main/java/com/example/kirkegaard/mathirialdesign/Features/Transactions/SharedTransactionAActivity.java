package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kirkegaard.mathirialdesign.R;

public class SharedTransactionAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_transaction_a);

        final ImageView imageView = (ImageView)findViewById(R.id.simple_activity_a_imageView);

        Button startTransitionButton = (Button)findViewById(R.id.startTransitionButton);
        startTransitionButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(SharedTransactionAActivity.this, SharedTransactionAActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(
                                SharedTransactionAActivity.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });

        Slide slide = new Slide(Gravity.LEFT);
        slide.setDuration(2000);
        slide.excludeTarget(android.R.id.statusBarBackground, true);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        slide.addTarget(R.id.simple_activity_A_transtext);

        //Slide slide2 = new Slide(Gravity.RIGHT);
        Fade slide2 = new Fade(Fade.IN);
        slide2.setDuration(4000);
        slide2.addTarget(R.id.my_root);
        slide2.excludeTarget(android.R.id.statusBarBackground, true);
        slide2.excludeTarget(android.R.id.navigationBarBackground, true);

        TransitionSet transSet = new TransitionSet();
        transSet.addTransition(slide);
        transSet.addTransition(slide2);

        getWindow().setEnterTransition(transSet);
    }
}
