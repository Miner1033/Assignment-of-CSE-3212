package com.example.assignment1;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Form_Assignment extends AppCompatActivity {

    private EditText etName, etId, etPhone, etEmail, etPassword;
    private Button btnSubmit;
    private ImageView ivTogglePassword;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_assignment);

        // Initialize views
        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        ivTogglePassword = findViewById(R.id.ivTogglePassword);

        // Set submit button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    Toast.makeText(Form_Assignment.this, "Form Submitted Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Toggle password visibility
        ivTogglePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });
    }

    // Method to validate the form
    private boolean validateForm() {
        String name = etName.getText().toString().trim();
        String id = etId.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate Name (should not be empty)
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            return false;
        }

        // Validate Student ID (should be 5 digits and start with '01')
        if (!id.matches("^01\\d{3}$")) {
            etId.setError("Student ID must be 5 digits and start with 01");
            return false;
        }

        // Validate Phone (should be 11 digits and start with '01')
        if (!phone.matches("^01\\d{9}$")) {
            etPhone.setError("Phone Number must be 11 digits and start with 01");
            return false;
        }

        // Validate Email (should be a valid Gmail or Yahoo email)
        if (!isValidEmail(email)) {
            etEmail.setError("Enter a valid email (Gmail or Yahoo)");
            return false;
        }

        // Validate Password (6+ characters, upper and lower case)
        if (!isValidPassword(password)) {
            etPassword.setError("Password must be at least 6 characters, with upper and lower case letters");
            return false;
        }

        return true; // All validations passed
    }

    // Helper method to validate email (Gmail or Yahoo)
    private boolean isValidEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() && (email.endsWith("gmail.com") || email.endsWith("yahoo.com"));
    }

    // Helper method to validate password (6+ characters, upper and lower case)
    private boolean isValidPassword(String password) {
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).{6,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Method to toggle password visibility
    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Hide the password
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivTogglePassword.setImageResource(R.drawable.eye_24); // Set the eye icon
        } else {
            // Show the password
            etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            ivTogglePassword.setImageResource(R.drawable.eye_24); // Set the eye-off icon
        }
        // Move the cursor to the end of the text after toggling
        etPassword.setSelection(etPassword.length());
        isPasswordVisible = !isPasswordVisible;
    }
}
