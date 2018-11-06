package com.example.kirkegaard.mathirialdesign.Features.Controls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kirkegaard.mathirialdesign.*;

public class ControlsOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //overridePendingTransition(
                ////R.anim.in_animation,
                ////R.anim.no_animation);

        setContentView(R.layout.activity_controls_overview);

        Button textInputLayoutButton = (Button)findViewById(R.id.ControlsOverviewTextInputLayout);
        textInputLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateToPage(TextInputLayoutActivity.class);
            }
        });

        Button switchesButton = (Button)findViewById(R.id.ControlsOverviewSwitches);
        switchesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NavigateToPage(SwithesActivity.class);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isFinishing())
        {
            overridePendingTransition(
                    R.anim.no_animation,
                    R.anim.out_animation);
        }
    }

    private void NavigateToPage(Class<?> activityClass)
    {
        Intent intent = new Intent(this, activityClass);
        //this.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        this.startActivity(intent);
    }
}
