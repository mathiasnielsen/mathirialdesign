package com.example.kirkegaard.scrolltestproject;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText theEditText;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout root = (LinearLayout)findViewById(R.id.root_linearLayout);
        ScrollView scrollRoot = (ScrollView)findViewById(R.id.root_scrollview);
        //ConstraintLayout constRoot = (ConstraintLayout)findViewById(R.id.root_constraintlayout);
        theEditText = (EditText)findViewById(R.id.theEditText);
        theEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                int length = theEditText.length();
                theEditText.setSelection(length - 1);
            }
        });

        //KeyboardOnGlobalLayoutListener listener = new KeyboardOnGlobalLayoutListener(this, scrollRoot);
    }

    @Override
    protected void onResume() {
        super.onResume();

        theEditText.setText("hello");

        if (theEditText.hasFocus())
        {
            theEditText.setSelection(pos);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        pos = theEditText.getSelectionStart();
    }
}
