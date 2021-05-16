package com.example.lister;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, "notes.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Notes\n" +
                "(\n" +
                "    _id      INTEGER not null\n" +
                "        constraint Notes_pk\n" +
                "            primary key autoincrement,\n" +
                "    Name    TEXT,\n" +
                "    Context TEXT\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveNote(String name, String text) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("INSERT INTO Notes (Name, Context) VALUES (?, ?)", new String[]{name, text});
        writableDatabase.close();
    }

    public Cursor getNotes() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        return readableDatabase.rawQuery("SELECT _id, Name, Context FROM Notes", new String[]{});
    }

    public void removeNote(long id){
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM Notes WHERE _id = ?", new String[]{String.valueOf(id)});
        writableDatabase.close();

    }
}
