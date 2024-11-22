package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;

    // Constructor
    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder pattern for better performance
        ViewHolder holder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

            // Initialize ViewHolder
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.textViewTitle);
            holder.subtitle = convertView.findViewById(R.id.textViewSubtitle);

            // Set the ViewHolder as a tag to reuse
            convertView.setTag(holder);
        } else {
            // Reuse the ViewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the data for the current item
        Item currentItem = items.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.subtitle.setText(currentItem.getSubtitle());

        return convertView;
    }

    // ViewHolder class to hold references to views
    static class ViewHolder {
        TextView title;
        TextView subtitle;
    }
}
