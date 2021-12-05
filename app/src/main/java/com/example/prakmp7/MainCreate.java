package com.example.prakmp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejudul, Eartis;
    private String Sjudul, Sartis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Eartis = (EditText) findViewById(R.id.create_artis);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sartis = String.valueOf(Eartis.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul lagu",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sartis.equals("")) {
                    Eartis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi artist",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Ejudul.setText("");
                    Eartis.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMusic(new Music(null, Sjudul,
                            Sartis));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
