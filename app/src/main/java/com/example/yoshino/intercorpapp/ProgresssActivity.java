package com.example.yoshino.intercorpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import github.nisrulz.stackedhorizontalprogressbar.StackedHorizontalProgressBar;

public class ProgresssActivity extends AppCompatActivity {


    private TextView textView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresss);

        textView = findViewById(R.id.txtnum);
        int primary_pts = 80;
        int secondary_pts = 50;
        int max = 100;

        StackedHorizontalProgressBar stackedHorizontalProgressBar;
        stackedHorizontalProgressBar = (StackedHorizontalProgressBar) findViewById(R.id.stackedhorizontalprogressbar);
        stackedHorizontalProgressBar.setMax(max);
        stackedHorizontalProgressBar.setProgress(primary_pts);
        textView.setText(""+80+"%");
    }
}
