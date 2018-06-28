package com.example.kirkegaard.mathirialdesign.Features.Controls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kirkegaard.mathirialdesign.R;

public class ControlsOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls_overview);

        Button textInputLayoutButton = (Button)findViewById(R.id.ControlsOverviewTextInputLayout);
        textInputLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateToPage(TextInputLayoutActivity.class);
            }
        });
    }

    private void NavigateToPage(Class<?> activityClass)
    {
        Intent intent = new Intent(this, activityClass);
        this.startActivity(intent);
    }
}
