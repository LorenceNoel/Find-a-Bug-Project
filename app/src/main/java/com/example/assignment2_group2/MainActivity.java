package com.example.assignment2_group2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView title = findViewById(R.id.txtTitle);
        Button btnStartGame = findViewById(R.id.btnStartGame);
        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnAbout = findViewById(R.id.btnAbout);

//        title.setText(R.string.guessing_game);
//        title.setTextColor(getResources().getColor(android.R.color.black));
//
//        btnStartGame.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
//        btnSettings.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
//        btnAbout.setBackgroundColor(getResources().getColor(android.R.color.black));
//        btnAbout.setTextColor(getResources().getColor(android.R.color.white));

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GuessActivity.class));
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
    }
}
