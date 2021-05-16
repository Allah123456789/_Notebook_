package com.example.lister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class New extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new); Button buttonBack;
        buttonBack = findViewById(R.id.button);
        buttonBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, Saved.class);
        startActivity(i);
    }
    public void exit(View view) {
        finish();
    }


    public void builder(View view) {
        Intent i;
        i = new Intent(this, Builder.class);
        startActivity(i);
    }
}