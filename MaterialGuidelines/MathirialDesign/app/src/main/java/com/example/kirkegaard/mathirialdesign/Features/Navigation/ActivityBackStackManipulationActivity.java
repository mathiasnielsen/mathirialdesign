package com.example.kirkegaard.mathirialdesign.Features.Navigation;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.kirkegaard.mathirialdesign.R;

public class ActivityBackStackManipulationActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack_manipulation);

        View decorView = getWindow().getDecorView();

        TextView textView = GetTextView(this);
    }

    public class ActivityB extends  AppCompatActivity
    {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_back_stack_manipulation);

            TextView textView = GetTextView(this);
        }
    }

    public class ActivityC extends  AppCompatActivity
    {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_back_stack_manipulation);

            TextView textView = GetTextView(this);
        }
    }

    public class ActivityD extends  AppCompatActivity
    {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_back_stack_manipulation);

            TextView textView = GetTextView(this);
        }
    }

    public class ActivityE extends  AppCompatActivity
    {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_back_stack_manipulation);

            TextView textView = GetTextView(this);
        }
    }

    private TextView GetTextView(AppCompatActivity activity)
    {
        return (TextView)activity.findViewById(R.id.backstack_activity_textview);
    }
}
