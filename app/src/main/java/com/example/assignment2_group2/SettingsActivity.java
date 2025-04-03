package com.example.assignment2_group2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {
    private Switch soundSwitch;
    private Switch darkModeSwitch;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load theme
        SharedPreferences preferences = getSharedPreferences("GameSettings", MODE_PRIVATE);
        boolean isDarkMode = preferences.getBoolean("DarkMode", false);
        AppCompatDelegate.setDefaultNightMode(isDarkMode ?
                AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_settings);

        soundSwitch = findViewById(R.id.soundSwitch);
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        saveButton = findViewById(R.id.btnSaveSettings);

        // Restore saved settings
        soundSwitch.setChecked(preferences.getBoolean("SoundEnabled", true));
        darkModeSwitch.setChecked(isDarkMode);

        // making darkmode when toggled
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppCompatDelegate.setDefaultNightMode(isChecked ?
                    AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        });

        // Saving settings
        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("SoundEnabled", soundSwitch.isChecked());
            editor.putBoolean("DarkMode", darkModeSwitch.isChecked());
            editor.apply();
            Toast.makeText(SettingsActivity.this, "Settings Saved!", Toast.LENGTH_SHORT).show();
        });
    }
}
