package com.example.assignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Assignment2 extends AppCompatActivity {

    private EditText nameEditText;
    private CheckBox subscribeCheckBox1, subscribeCheckBox2, subscribeCheckBox3;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private SeekBar volumeSeekBar;
    private Switch notificationsSwitch;
    private Button submitButton;
    private RatingBar ratingBar;
    private TextView seekBarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assginment2);  // Make sure the layout name is correct

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        subscribeCheckBox1 = findViewById(R.id.subscribeCheckBox1);
        subscribeCheckBox2 = findViewById(R.id.subscribeCheckBox2);
        subscribeCheckBox3 = findViewById(R.id.subscribeCheckBox3);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        notificationsSwitch = findViewById(R.id.notificationsSwitch);
        submitButton = findViewById(R.id.submitButton);
        ratingBar = findViewById(R.id.ratingBar);
        //seekBarValue = findViewById(R.id.volumeSeekBar);  // Ensure this TextView exists in your XML

        // SeekBar listener
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText("Volume: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: do something when the user starts to touch the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: do something when the user stops touching the SeekBar
            }
        });

        // Button listener
        submitButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            StringBuilder subscriptions = new StringBuilder();
            if (subscribeCheckBox1.isChecked()) subscriptions.append("SSC ");
            if (subscribeCheckBox2.isChecked()) subscriptions.append("HSC ");
            if (subscribeCheckBox3.isChecked()) subscriptions.append("BSC ");

            String gender = maleRadioButton.isChecked() ? "Male" : "Female";
            boolean notificationsEnabled = notificationsSwitch.isChecked();
            float rating = ratingBar.getRating();

            // Displaying the collected information
            String message = "Name: " + name + "\n" +
                    "Subscriptions: " + subscriptions.toString() + "\n" +
                    "Gender: " + gender + "\n" +
                    "Notifications: " + (notificationsEnabled ? "Enabled" : "Disabled") + "\n" +
                    "Rating: " + rating;

            Toast.makeText(Assignment2.this, message, Toast.LENGTH_LONG).show();
        });
    }
}
