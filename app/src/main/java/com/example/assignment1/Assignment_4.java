package com.example.assignment1;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Assignment_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment4);

        ListView listView = findViewById(R.id.listView);

        // Sample data with 15 items (dynamically generated titles and subtitles)
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            items.add(new Item("Custom ListView " + i, "Subtitle " + i));
        }

        // Set adapter
        MyAdapter adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);
    }
}
