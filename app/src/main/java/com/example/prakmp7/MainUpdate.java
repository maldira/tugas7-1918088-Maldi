package com.example.prakmp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdate extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjudul, Sartis;
    private EditText Ejudul, Eartis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Sartis = i.getStringExtra("Iartis");
        Ejudul = (EditText) findViewById(R.id.update_judul);
        Eartis = (EditText) findViewById(R.id.update_artis);
        Ejudul.setText(Sjudul);
        Eartis.setText(Sartis);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sartis = String.valueOf(Eartis.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdate.this, "Silahkan isi judul lagu",
                            Toast.LENGTH_SHORT).show();
                } else if (Sartis.equals("")){
                    Eartis.requestFocus();
                    Toast.makeText(MainUpdate.this, "Silahkan isi artist",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMusic(new Music(Sid, Sjudul, Sartis));
                    Toast.makeText(MainUpdate.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMusic(new Music(Sid, Sjudul, Sartis));
                Toast.makeText(MainUpdate.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

