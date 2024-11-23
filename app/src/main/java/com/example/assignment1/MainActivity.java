package com.example.assignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1, b2, b3;
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.custombutton1);

        ImageView imageView = findViewById(R.id.imageView); // Get the ImageView

        b1.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Red Button Clicked", Toast.LENGTH_SHORT).show();
        });

        b2.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Green Button Clicked", Toast.LENGTH_SHORT).show();
        });

        b3.setOnClickListener(v -> {
            imageView.setImageResource(R.drawable.new_image); // Change the image
            Toast.makeText(MainActivity.this, "Image Updated!", Toast.LENGTH_SHORT).show();
        });
    }
}
