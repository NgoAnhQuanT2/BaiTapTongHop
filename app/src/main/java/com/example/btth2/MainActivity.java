package com.example.btth2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMusic;
    ArrayList<Music> arrayMusic;
    MusicAdapter adapter;
    EditText edtadd;
    Button btnadd;
    int vitri=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnadd = (Button) findViewById(R.id.button);
        edtadd = (EditText) findViewById(R.id.editTextTextPersonName);

        adapter = new MusicAdapter(this, R.layout.dong_nhac, arrayMusic);
        lvMusic.setAdapter(adapter);

        lvMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        lvMusic.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = edtadd.getText().toString();
                arrayMusic.add(new Music(monhoc, R.drawable.soundcloud));
                adapter.notifyDataSetChanged();
            }
        });

        lvMusic.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Ngô Anh Quân");
                b.setMessage("Bạn có đồng ý xóa không ?");
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayMusic.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = b.create();
                al.show();
                return false;
            }
        });
    }

    private void Anhxa() {
        lvMusic = (ListView) findViewById(R.id.listview);
        arrayMusic = new ArrayList<>();

        arrayMusic.add(new Music("Our Song", R.drawable.soundcloud));
        arrayMusic.add(new Music("Breathing", R.drawable.soundcloud));
        arrayMusic.add(new Music("I Don’t Think That I Like Her", R.drawable.soundcloud));
        arrayMusic.add(new Music("That Girl", R.drawable.soundcloud));
        arrayMusic.add(new Music("Left And Right ", R.drawable.soundcloud));
        arrayMusic.add(new Music("All Falls Down ", R.drawable.soundcloud));
    }
}