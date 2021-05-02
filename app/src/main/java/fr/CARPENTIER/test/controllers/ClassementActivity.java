package fr.CARPENTIER.test.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.CARPENTIER.test.R;

public class ClassementActivity extends AppCompatActivity {

    private Button relancer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        relancer = findViewById(R.id.relancer) ;

        relancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassementActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }


}