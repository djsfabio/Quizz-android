package fr.CARPENTIER.test.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

import fr.CARPENTIER.test.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
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

            buttonPlay.setBackgroundColor(Color.parseColor("#FF8A5B"));
            myTextView.setText(SettingsUtility.getUsername() + "\n" + SettingsUtility.getaNumberOfQuestions() + " Questions\nCategory : " + SettingsUtility.getaCategory() + "\nDifficulty : " + SettingsUtility.getaDifficulty() + "\nType : " + SettingsUtility.getaType());
        }


        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SettingsUtility.getUsername() == null) {
                    Snackbar.make(findViewById(R.id.mainLayout), "Before playing, please make your settings", Snackbar.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}