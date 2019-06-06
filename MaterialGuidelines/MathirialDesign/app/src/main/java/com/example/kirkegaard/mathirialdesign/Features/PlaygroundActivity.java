package com.example.kirkegaard.mathirialdesign.Features;

import android.app.ActionBar;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.example.kirkegaard.mathirialdesign.R;

public class PlaygroundActivity extends AppCompatActivity {

    ConstraintLayout rootConstraintLayout;
    ConstraintSet constraintSet;
    View fakeTopView1;

    int initialHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        fakeTopView1 = findViewById(R.id.fakeTop1);

        constraintSet = new ConstraintSet();
        rootConstraintLayout = findViewById(R.id.rootConstraintLayout);
        constraintSet.clone(rootConstraintLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        NestedScrollView scrollView = findViewById(R.id.myNestedScrollView);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY)
            {
                if (initialHeight == 0)
                {
                    initialHeight = fakeTopView1.getMeasuredHeight();
                }

                int scrollOffSet = initialHeight - scrollY;

                // With layout parms
                /*
                ViewGroup.LayoutParams layoutParams = fakeTopView1.getLayoutParams();
                layoutParams.height = scrollOffSet;
                fakeTopView1.setLayoutParams((layoutParams));
                */

                // With constraintLayout constraintSet
                constraintSet.constrainHeight(R.id.fakeTop1, scrollOffSet);
                constraintSet.applyTo(rootConstraintLayout);
            }
        });
    }
}
