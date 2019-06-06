package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.kirkegaard.mathirialdesign.R;

public class SharedTransactionFragmentHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_transaction_fragment_holder);

        SharedTransactionAFragment fragment = SharedTransactionAFragment.newInstance();
        int targetId = R.id.fragment_a_btn;
        TransHelper.AddSlideTransition(fragment, targetId);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(SharedTransactionAFragment.TAG)
                .replace(R.id.content, fragment)
                .commit();
    }
}
