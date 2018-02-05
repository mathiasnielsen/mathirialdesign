package com.example.kirkegaard.mathirialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentSharedTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_shared_transaction);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, SharedTransactionA.newInstance())
                .commit();
    }
}
