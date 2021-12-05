package com.example.prakmp7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Music> Music;
    public CustomListAdapter(Activity activity, List<Music>
            Music) {
        this.activity = activity;
        this.Music = Music;
    }
    @Override
    public int getCount() {
        return Music.size();
    }
    @Override
    public Object getItem(int location) {
        return Music.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView judul = (TextView)
                convertView.findViewById(R.id.text_judul);
        TextView artis = (TextView)
                convertView.findViewById(R.id.text_artis);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Music m = Music.get(position);
        judul.setText("Judul Lagu : "+ m.get_judul());
        artis.setText("Artist : "+ m.get_artis());
        return convertView;
    }
}

