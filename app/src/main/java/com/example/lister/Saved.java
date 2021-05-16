package com.example.lister;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import static android.widget.CursorAdapter.FLAG_AUTO_REQUERY;
import static android.widget.CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER;

public class Saved extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;
    private ArrayAdapter<String> mAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        dataBaseHelper = new DataBaseHelper(getBaseContext());
         cursor = dataBaseHelper.getNotes();
        ListView listView = findViewById(R.id.memory);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(getBaseContext(), android.R.layout.simple_list_item_2, cursor, new String[]{"Name", "Context"}, new int[]{android.R.id.text1, android.R.id.text2}, FLAG_AUTO_REQUERY);
        listView.setAdapter(simpleCursorAdapter);
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            dataBaseHelper.removeNote(id);
            cursor.requery();
            Toast.makeText(getApplicationContext(),
                    "заметка удалена",
                    Toast.LENGTH_SHORT).show();
            return true;
        });
    }
    public void exit(View view) {
        finish();
    }
}