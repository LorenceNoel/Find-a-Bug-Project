package com.example.assignment2_group2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {
    private Switch soundSwitch;
    private Switch darkModeSwitch;
    private Spinner difficultySpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        soundSwitch = findViewById(R.id.soundSwitch);
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        difficultySpinner = findViewById(R.id.difficultySpinner);
        saveButton = findViewById(R.id.btnSaveSettings);

        // Set up the difficulty spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.difficulty_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        // Load saved settings
        SharedPreferences preferences = getSharedPreferences("GameSettings", MODE_PRIVATE);
        soundSwitch.setChecked(preferences.getBoolean("SoundEnabled", true));
        darkModeSwitch.setChecked(preferences.getBoolean("DarkMode", false));
        difficultySpinner.setSelection(preferences.getInt("Difficulty", 0));

        // Apply dark mode immediately based on saved preference
        if (darkModeSwitch.isChecked()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        // Set listener for the dark mode switch to apply theme immediately
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("DarkMode", isChecked);
            editor.apply();

            // Apply dark or light theme instantly
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        // Save settings when button is clicked
        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("SoundEnabled", soundSwitch.isChecked());
            editor.putBoolean("DarkMode", darkModeSwitch.isChecked());
            editor.putInt("Difficulty", difficultySpinner.getSelectedItemPosition());
            editor.apply();
            Toast.makeText(SettingsActivity.this, "Settings Saved!", Toast.LENGTH_SHORT).show();
        });
    }
}
