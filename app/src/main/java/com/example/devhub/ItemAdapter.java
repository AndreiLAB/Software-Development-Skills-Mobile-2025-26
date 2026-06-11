package com.example.devhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    private Context ctx;
    private String[] items = {"Advanced Android App", "AI Chat Assistant", "Fitness Tracker App"};
    private LayoutInflater inflater;

    public ItemAdapter(Context context) {
        this.ctx = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override public int getCount() { return items.length; }
    @Override public Object getItem(int p) { return items[p]; }
    @Override public long getItemId(int p) { return p; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setText(items[position]);
        return convertView;
    }
}