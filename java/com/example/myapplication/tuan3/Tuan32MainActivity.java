package com.example.myapplication.tuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Tuan32MainActivity extends AppCompatActivity {
    ListView lv;
    T32Adapter adapter;
    ArrayList<Tuan32contact> ls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan32_main);
        lv = findViewById(R.id.tuan32listview);
        ls.add(new Tuan32contact("Nguyen Minh Hai","20",R.drawable.ic_launcher_background));
        ls.add(new Tuan32contact("Nguyen Hai Minh","16",R.drawable.ic_launcher_background));
        ls.add(new Tuan32contact("Nguyen Huong Tra","17",R.drawable.ic_launcher_background));
        ls.add(new Tuan32contact("Nguyen Quang Tu","20",R.drawable.ic_launcher_background));
        ls.add(new Tuan32contact("Nguyen Cong Cuong","20",R.drawable.ic_launcher_background));
        adapter = new T32Adapter(ls,this);
        lv.setAdapter(adapter);
    }
}