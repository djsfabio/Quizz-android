package fr.CARPENTIER.test.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

import fr.CARPENTIER.test.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = findViewById(R.id.button_play);
        buttonPlay.setOnClickListener(this);


        Button buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(this);

        if (SettingsUtility.getUsername() != null) {
            TextView myTextView = (TextView) findViewById(R.id.myTextView);
            myTextView.setText(SettingsUtility.getUsername() + "\n" + SettingsUtility.getaNumberOfQuestions() + " Question(s)\nCategory : " + SettingsUtility.getaCategory() + "\nDifficulty : " + SettingsUtility.getaDifficulty() + "\nType : " + SettingsUtility.getaType());
        }


        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }
}