package com.example.assignment1;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Assignment2 extends AppCompatActivity {

    // Declare UI components
    private EditText nameEditText;
    private CheckBox subscribeCheckBox1, subscribeCheckBox2, subscribeCheckBox3;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private SeekBar brightnessSeekBar;
    private Switch darkModeSwitch;
    private Button submitButton;
    private RatingBar ratingBar;
    private TextView ratingValueTextView;  // TextView to display live rating value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assginment2);

        // Initialize UI components
        nameEditText = findViewById(R.id.nameEditText);
        subscribeCheckBox1 = findViewById(R.id.subscribeCheckBox1);
        subscribeCheckBox2 = findViewById(R.id.subscribeCheckBox2);
        subscribeCheckBox3 = findViewById(R.id.subscribeCheckBox3);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        brightnessSeekBar = findViewById(R.id.brightnessSeekBar);
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        submitButton = findViewById(R.id.submitButton);
        ratingBar = findViewById(R.id.ratingBar);
        ratingValueTextView = findViewById(R.id.ratingValueTextView);  // Initialize TextView

        // Set initial brightness level
        setInitialBrightness();

        // Handle dark mode toggle
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppCompatDelegate.setDefaultNightMode(
                    isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
            );
        });

        // Handle brightness adjustments
        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setScreenBrightness(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: Feedback when adjustment starts
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: Feedback when adjustment stops
            }
        });

        // Handle live rating score display
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            // Update the TextView with the current rating
            ratingValueTextView.setText("Rating: " + rating);
        });

        // Handle submit button click
        submitButton.setOnClickListener(v -> {
            // Capture user inputs
            String name = nameEditText.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder subscriptions = new StringBuilder();
            if (subscribeCheckBox1.isChecked()) subscriptions.append("SSC ");
            if (subscribeCheckBox2.isChecked()) subscriptions.append("HSC ");
            if (subscribeCheckBox3.isChecked()) subscriptions.append("BSC ");

            // Validate gender selection
            int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select your gender.", Toast.LENGTH_SHORT).show();
                return;
            }
            String gender = (selectedGenderId == R.id.maleRadioButton) ? "Male" : "Female";

            boolean darkModeEnabled = darkModeSwitch.isChecked();
            float rating = ratingBar.getRating();

            // Prepare the message for the dialog
            String message = "Name: " + name + "\n" +
                    "Subscriptions: " + subscriptions.toString().trim() + "\n" +
                    "Gender: " + gender + "\n" +
                    "Dark Mode: " + (darkModeEnabled ? "Enabled" : "Disabled") + "\n" +
                    "Brightness Level: " + brightnessSeekBar.getProgress() + "\n" +
                    "Rating: " + rating;

            // Create and show a dialog
            new AlertDialog.Builder(this)
                    .setTitle("User Information")
                    .setMessage(message)
                    .setPositiveButton("OK", (dialog, which) -> {
                        // Optional: Action after clicking "OK"
                        dialog.dismiss();
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                        // Optional: Action after clicking "Cancel"
                        dialog.dismiss();
                    })
                    .show();
        });
    }

    // Retrieve and set the initial brightness level
    private void setInitialBrightness() {
        try {
            ContentResolver contentResolver = getContentResolver();
            int brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
            brightnessSeekBar.setProgress(brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Set screen brightness dynamically
    private void setScreenBrightness(int brightness) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = brightness / 255.0f;
        getWindow().setAttributes(layoutParams);
    }
}
