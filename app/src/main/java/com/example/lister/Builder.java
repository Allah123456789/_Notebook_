package com.example.lister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Builder extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        EditText editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        ImageButton enter = findViewById(R.id.imageButton11);
        ImageButton clear = findViewById(R.id.imageButton9);
        dataBaseHelper = new DataBaseHelper(this);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TextView textView = findViewById(R.id.editTextTextMultiLine);
                    textView.setText("");
                }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextTextMultiLine.getText().toString();
                String name = editTextTextPersonName.getText().toString();
                dataBaseHelper.saveNote(name,text);
            }
        });

    }
    public void exit(View view) { finish();}

}