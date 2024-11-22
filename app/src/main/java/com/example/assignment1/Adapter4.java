package com.example.assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter4 extends RecyclerView.Adapter<Adapter4.ViewHolder> {

    private List<Model> modelList;

    // Constructor to initialize the list
    public Adapter4(List<Model> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout (itemr.xml)
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemr, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the model at the current position
        Model model = modelList.get(position);
        // Set the title and description
        holder.titleText.setText(model.getTitle());
        holder.descriptionText.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    // ViewHolder class to hold the views
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView descriptionText;

        public ViewHolder(View itemView) {
            super(itemView);
            // Initialize the TextViews
            titleText = itemView.findViewById(R.id.itemText);
            descriptionText = itemView.findViewById(R.id.itemDescription);
        }
    }
}
