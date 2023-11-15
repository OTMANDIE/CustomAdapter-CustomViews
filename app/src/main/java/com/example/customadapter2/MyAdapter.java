package com.example.customadapter2;

import static java.lang.String.valueOf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    HashMap<String, Integer> data;
    Context context;
    HashMap<String, Integer> languageImages;
    MyAdapter(Context context,HashMap<String,Integer> data) {
        this.context = context;
        this.data = data;


        languageImages = new HashMap<String, Integer>();
        languageImages.put("Java", R.drawable.java_image);
        languageImages.put("Python", R.drawable.python_image);
        languageImages.put("JavaScript", R.drawable.javascript_image);
        languageImages.put("C++", R.drawable.cpp_image);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        List<String> keys = new ArrayList<>(data.keySet());
        return keys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.customview,null);
            TextView textViewLanguage = (TextView) view.findViewById(R.id.textViewTop);
            TextView textViewYear = (TextView) view.findViewById(R.id.textViewBottom);
            ImageView imageView = view.findViewById(R.id.imageView);

            String language = (String) getItem(position);

            textViewLanguage.setText(language);
            textViewYear.setText(data.get(language).toString());
            if (languageImages.containsKey(language)) {
                imageView.setImageResource(languageImages.get(language));
            } else {
                imageView.setImageResource(R.drawable.unknown_image);
            }
        }

        return view;
    }
}
