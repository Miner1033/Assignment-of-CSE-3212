package com.example.assignment1;


import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment_4 extends AppCompatActivity {
    ArrayList<String> CityNames = new ArrayList<>(Arrays.asList("sylhet", "dhaka", "noakhali", "cumilla", "habiganj", "sunamganj", "khulna", "jossere", "bhola", "coxsbazar","bogura", "feni", "gazipur", "jashore", "khulna", "noakhali", "narail", "pabna"));
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleviewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(this, CityNames);
        recyclerView.setAdapter(adapter);

        // Add smooth scrolling with a delay for demonstration
        autoScroll();
    }

    // Method to perform animated scroll
    private void autoScroll() {
        final Handler handler = new Handler();
        final int scrollInterval = 3000; // Time in milliseconds between each scroll

        handler.postDelayed(new Runnable() {
            int position = 0;

            @Override
            public void run() {
                if (position < adapter.getItemCount()) {
                    recyclerView.smoothScrollToPosition(position++);
                    handler.postDelayed(this, scrollInterval); // Continue scrolling after the interval
                }
            }
        }, scrollInterval);
    }
}