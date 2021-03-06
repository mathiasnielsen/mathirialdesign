package com.example.kirkegaard.mathirialdesign.Features.Dialogs;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kirkegaard.mathirialdesign.R;

import java.io.Console;

public class DialogsActivity extends AppCompatActivity implements ItemListDialogFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        Button btnBottomDialog = (Button)findViewById(R.id.btn_show_bottom_dialog);
        btnBottomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        FragmentManager fm = getSupportFragmentManager();
        ItemListDialogFragment itemListDialogFragment = ItemListDialogFragment.newInstance(20);
        itemListDialogFragment.show(fm, "fragment_edit_name");
    }

    @Override
    public void onItemClicked(int position) {
        Log.w("Did click", "The position" + position);
    }
}
