 package com.example.myapplication.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tview = findViewById(R.id.tvkkk);
        Bundle bundleReceive = getIntent().getExtras();
        if (bundleReceive != null){
            User user = (User) bundleReceive.get("object_user");
            if (user != null){
                tview.setText(user.toString());
            }
        }
    }
}