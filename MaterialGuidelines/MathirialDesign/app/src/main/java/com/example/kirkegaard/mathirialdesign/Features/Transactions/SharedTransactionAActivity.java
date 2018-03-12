package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                Intent intent = new Intent(SharedTransactionAActivity.this, SharedTransactionBActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(
                                SharedTransactionAActivity.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });
    }
}
