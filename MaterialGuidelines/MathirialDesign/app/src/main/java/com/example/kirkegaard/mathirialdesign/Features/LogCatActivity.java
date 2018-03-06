package com.example.kirkegaard.mathirialdesign.Features.Features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kirkegaard.mathirialdesign.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogCatActivity extends AppCompatActivity {

    TextView logCatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_cat);

        logCatTextView = (TextView)findViewById(R.id.logcat_textview);

        final Button outputButton = (Button)findViewById(R.id.output_to_logcat);
        outputButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Log.w("hello", "hello you");
            }
        });

        final Button clearLogCatButton = (Button)findViewById(R.id.btn_clear_logcat);
        clearLogCatButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ClearLogCat();
            }
        });

        final Button retrieveLogButton = (Button)findViewById(R.id.btn_retrieve_logcat);
        retrieveLogButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ShowLogCat();
            }
        });
    }

    private void ClearLogCat()
    {
        ProcessBuilder process = new ProcessBuilder();
        process.command("logcat", "-c");
        process.redirectErrorStream(true);
        try {
            process.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowLogCat()
    {
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            logCatTextView.setText(log.toString());
        }
        catch (IOException e)
        {
            Log.w("ShowLogCat failed", "Failing show log cat");
        }
    }
}
