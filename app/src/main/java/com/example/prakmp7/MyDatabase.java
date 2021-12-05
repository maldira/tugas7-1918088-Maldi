package com.example.prakmp7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_musik";
    private static final String tb_music = "tb_music";
    private static final String tb_music_id = "id";
    private static final String tb_music_judul = "judul";
    private static final String tb_music_artis = "artis";
    private static final String CREATE_TABLE_MUSIC = "CREATE TABLE " +
    tb_music +"("
            + tb_music_id + " INTEGER PRIMARY KEY ,"
            + tb_music_judul + " TEXT ,"
            + tb_music_artis + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MUSIC);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMusic(Music data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_music_id, data.get_id());
        values.put(tb_music_judul, data.get_judul());
        values.put(tb_music_artis, data.get_artis());
        db.insert(tb_music, null, values);
        db.close();
    }
    public List<Music> ReadMusic() {
        List<Music> listMsc = new ArrayList<Music>();
        String selectQuery = "SELECT * FROM " + tb_music;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Music data = new Music();
                data.set_id(cursor.getString(0));
                data.set_judul(cursor.getString(1));
                data.set_artis(cursor.getString(2));
                listMsc.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMsc;
    }
    public int UpdateMusic (Music data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_music_artis, data.get_judul());
        values.put(tb_music_artis, data.get_artis());
        return db.update(tb_music, values, tb_music_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMusic(Music data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_music,tb_music_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

