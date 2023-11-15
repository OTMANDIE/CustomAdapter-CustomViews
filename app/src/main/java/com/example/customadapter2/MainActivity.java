package com.example.customadapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    HashMap<String,Integer> Language = new HashMap<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvLanguage);

        Language.put("Java",1995);
        Language.put("Python",1991);
        Language.put("JavaScript",1995);
        Language.put("C++",1983);

        ArrayList<String> languageList = new ArrayList<>(Language.keySet());

        adapter = new MyAdapter(this, Language);
        lv.setAdapter(adapter);
    }
}