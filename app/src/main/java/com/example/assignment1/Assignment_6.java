package com.example.assignment1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Assignment_6 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter4 modelAdapter;
    private List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyleview);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list with 15 items (title and description)
        modelList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            modelList.add(new Model("RecyclerView_item" + i, "This is the description for item " + i));
        }

        // Set the adapter to RecyclerView
        modelAdapter = new Adapter4(modelList);
        recyclerView.setAdapter(modelAdapter);
    }
}
