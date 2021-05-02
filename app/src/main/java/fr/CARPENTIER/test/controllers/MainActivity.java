package fr.CARPENTIER.test.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import fr.CARPENTIER.test.R;
import okhttp3.HttpUrl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue mQueue ;

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
            myTextView.setText(SettingsUtility.getUsername() + "\n" + SettingsUtility.getNumberOfQuestions() + " Questions\nCategory : " + SettingsUtility.getCategory() + "\nDifficulty : " + SettingsUtility.getDifficulty() + "\nType : " + SettingsUtility.getType());
        }


        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameUtility.clearListOfQuestion();
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