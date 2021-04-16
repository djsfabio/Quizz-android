package fr.CARPENTIER.test.controllers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.CARPENTIER.test.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    String username = null;
    String numberOfQuestions = null;
    String category = null;
    String difficulty = null;
    String type = null;

    EditText usernameInput;
    EditText numberOfQuestionsInput;

    Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        usernameInput = (EditText) findViewById(R.id.usernameInput);


        /* Spinner number of questions */
        Spinner spinnerNumberOfQuestions = (Spinner) findViewById(R.id.numberOfQuestionsInput);
        List<String> listNumberOfQuestions = new ArrayList<>();
        for (int i = 10; i <= 50; i+=5) {
            listNumberOfQuestions.add(String.valueOf(i));
        }


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listNumberOfQuestions
        );
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerNumberOfQuestions.setAdapter(adapter1);


        /* Spinner category */
        Spinner spinnerCategory = (Spinner) findViewById(R.id.categoryInput);

        List<String> listCategory = Arrays.asList("Any Category", "General Knowledge", "Entertainment: Books",
                "Entertainment: Film", "Entertainment: Music", "Entertainment: Musicals & Theatres",
                "Entertainment: Television", "Entertainment: Video Games", "Entertainment: Board Games", "Science & Nature",
                "Science: Computers", "Science: Mathematics", "Mythology", "Sports", "Geography", "History",
                "Politics", "Art", "Celebrities", "Animals", "Vehicles", "Entertainment: Comics",
                "Science: Gadgets", "Entertainment: Japanese Anime & Manga", "Entertainment: Cartoon & Animations");


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

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(usernameInput.getText().toString().equals("")){
                    Snackbar.make(findViewById(R.id.settingsLayout), "Please, use a valid username", Snackbar.LENGTH_SHORT).show();
                }
                else{
                    username = usernameInput.getText().toString();
                    numberOfQuestions = spinnerNumberOfQuestions.getSelectedItem().toString();
                    category = spinnerCategory.getSelectedItem().toString();
                    difficulty = spinnerDifficulty.getSelectedItem().toString().toLowerCase();
                    type = spinnerType.getSelectedItem().toString();

                    if(type.equals("Multiple Choice")){
                        type = "multiple" ;
                    }
                    if(type.equals("True / False")){
                        type = "boolean" ;
                    }
                    if(difficulty.equals("any difficulty")){
                        difficulty = null ;
                    }
                    if(type.equals("Any Type")){
                        type = null ;
                    }



                    switch(category){
                        case "Any Category" :
                            category = null ;
                            break ;
                        case "General Knowledge" :
                            category = "9" ;
                            break ;
                        case "Entertainment: Books" :
                            category = "10" ;
                            break ;
                        case "Entertainment: Film" :
                            category = "11" ;
                            break ;
                        case "Entertainment: Music" :
                            category = "12" ;
                            break ;
                        case "Entertainment: Musicals & Theatres" :
                            category = "13" ;
                            break ;
                        case "Entertainment: Television" :
                            category = "14" ;
                            break ;
                        case "Entertainment: Video Games" :
                            category = "15" ;
                            break ;
                        case "Entertainment: Board Games" :
                            category = "16" ;
                            break ;
                        case "Science & Nature" :
                            category = "17" ;
                            break ;
                        case "Science: Computers" :
                            category = "18" ;
                            break ;
                        case "Science: Mathematics" :
                            category = "19" ;
                            break ;
                        case "Mythology" :
                            category = "20" ;
                            break ;
                        case "Sports" :
                            category = "21" ;
                            break ;
                        case "Geography" :
                            category = "22" ;
                            break ;
                        case "History" :
                            category = "23" ;
                            break ;
                        case "Politics" :
                            category = "24" ;
                            break ;
                        case "Art" :
                            category = "25" ;
                            break ;
                        case "Celebrities" :
                            category = "26" ;
                            break ;
                        case "Animals" :
                            category = "27" ;
                            break ;
                        case "Vehicles" :
                            category = "28" ;
                            break ;
                        case "Entertainment: Comics" :
                            category = "29" ;
                            break ;
                        case "Science: Gadgets" :
                            category = "30" ;
                            break ;
                        case "Entertainment: Japanese Anime & Manga" :
                            category = "31" ;
                            break ;
                        case "Entertainment: Cartoon & Animations" :
                            category = "32" ;
                            break ;
                    }

                    SettingsUtility.setUsername(username);
                    SettingsUtility.setCategory(category);
                    SettingsUtility.setDifficulty(difficulty);
                    SettingsUtility.setNumberOfQuestions(numberOfQuestions);
                    SettingsUtility.setType(type);


                    Toast.makeText(SettingsActivity.this, "Welcome " + SettingsUtility.getUsername() + ".", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(SettingsActivity.this, MainActivity.class);
                    startActivity(intent2);
                }

            }
        }));

    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onBackPressed() {
        if(SettingsUtility.getUsername() == null) {
            Snackbar.make(findViewById(R.id.settingsLayout), "Please, use a valid username.", Snackbar.LENGTH_SHORT).show();
        }
        else{
            super.onBackPressed();
        }

    }
}
