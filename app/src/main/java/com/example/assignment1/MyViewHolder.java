package com.example.assignment1;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nameText;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameText=(TextView)itemView.findViewById(R.id.CityId);
    }
}
