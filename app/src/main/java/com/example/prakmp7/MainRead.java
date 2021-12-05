package com.example.prakmp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Music> ListMusic = new ArrayList<Music>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMusic);
        mListView = (ListView) findViewById(R.id.list_music);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMusic.clear();
        List<Music> music = db.ReadMusic();
        for (Music msc : music) {
            Music daftar = new Music();
            daftar.set_id(msc.get_id());
            daftar.set_judul(msc.get_judul());
            daftar.set_artis(msc.get_artis());
            ListMusic.add(daftar);
            if ((ListMusic.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Music detailMsc = (Music)o;
        String Sid = detailMsc.get_id();
        String Sjudul = detailMsc.get_judul();
        String Sartis = detailMsc.get_artis();
        Intent goUpdate = new Intent(MainRead.this,
                MainUpdate.class);
        goUpdate.putExtra("Iid", Sid);
        goUpdate.putExtra("Ijudul", Sjudul);
        goUpdate.putExtra("Iartis", Sartis);
        startActivity(goUpdate);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMusic.clear();
        mListView.setAdapter(adapter_off);
        List<Music> music = db.ReadMusic();
        for (Music msc : music) {
            Music daftar = new Music();
            daftar.set_id(msc.get_id());
            daftar.set_judul(msc.get_judul());
            daftar.set_artis(msc.get_artis());
            ListMusic.add(daftar);
            if ((ListMusic.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

