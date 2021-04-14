package fr.CARPENTIER.test.controllers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.CARPENTIER.test.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener  {

    String username ;
    int numberOfQuestions ;

    String category ;
    String difficulty ;
    String type ;

    EditText usernameInput ;
    EditText numberOfQuestionsInput ;

    Button buttonSubmit ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        usernameInput = (EditText) findViewById(R.id.usernameInput) ;
        numberOfQuestionsInput = (EditText) findViewById(R.id.numberOfQuestionsInput) ;


        /* Spinner category */
        Spinner spinnerCategory = (Spinner) findViewById(R.id.categoryInput);

        List<String> listCategory = Arrays.asList("Any Category", "History", "Art");


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listCategory
        );
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerCategory.setAdapter(adapter);

        /* Spinner difficulty */
        Spinner spinnerDifficulty = (Spinner) findViewById(R.id.difficultyInput);

        List<String> listDifficulty = Arrays.asList("Any Difficulty", "Easy", "Medium", "Hard");

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterD = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listDifficulty
        );
        // Specify the layout to use when the list of choices appears
        adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerDifficulty.setAdapter(adapterD);

        /* Spinner type */
        Spinner spinnerType = (Spinner) findViewById(R.id.typeInput);

        List<String> listType = Arrays.asList("Any Type", "Multiple Choice", "True / False");

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterT = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listType
        );
        // Specify the layout to use when the list of choices appears
        adapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerType.setAdapter(adapterT);


        // Action button, récupère les valeurs entrées

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit) ;
        buttonSubmit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameInput.getText().toString() ;
                numberOfQuestions = Integer.valueOf(numberOfQuestionsInput.getText().toString()) ;
                category = spinnerCategory.getSelectedItem().toString() ;
                difficulty = spinnerDifficulty.getSelectedItem().toString() ;
                type = spinnerType.getSelectedItem().toString() ;

                Intent intent = new Intent(getBaseContext(), SettingsUtility.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("NUMBER_OF_QUESTIONS", numberOfQuestions);
                intent.putExtra("CATEGORY", category);
                intent.putExtra("DIFFICULTY", difficulty);
                intent.putExtra("TYPE", type);


                Toast.makeText(SettingsActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        }));

    }
    @Override
    public void onClick(View v) {

    }
}
