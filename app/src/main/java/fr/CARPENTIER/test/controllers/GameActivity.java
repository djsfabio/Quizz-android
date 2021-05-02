package fr.CARPENTIER.test.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Objects;

import fr.CARPENTIER.test.R;
import fr.CARPENTIER.test.models.Question;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;


public class GameActivity extends AppCompatActivity {

    private TextView question;
    private Button bouton1 ;
    private Button bouton2 ;
    private Button bouton3 ;
    private Button bouton4 ;
    private TextView score ;

    private int scoreNombre = 0 ;

    private int i = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        question = findViewById(R.id.Question) ;
        bouton1 = findViewById(R.id.Bouton1) ;
        bouton2 = findViewById(R.id.Bouton2) ;
        bouton3 = findViewById(R.id.Bouton3) ;
        bouton4 = findViewById(R.id.Bouton4) ;
        score = findViewById(R.id.Score);

        updateQuestions();


        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(bouton1.getText()).equals(GameUtility.getListOfQuestion().get(i-1).getCorrectAnswer())){
                    scoreNombre += 1 ;
                    score.setText("Score : " + String.valueOf(scoreNombre));
                }
                updateQuestions();
            }
        });

        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(bouton2.getText()).equals(GameUtility.getListOfQuestion().get(i-1).getCorrectAnswer())){
                    scoreNombre += 1 ;
                    score.setText("Score : " + String.valueOf(scoreNombre));
                }
                updateQuestions();
            }
        });

        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bouton3.getText().equals("")){
                    Toast.makeText(GameActivity.this, "Bouton invalide", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(String.valueOf(bouton3.getText()).equals(GameUtility.getListOfQuestion().get(i-1).getCorrectAnswer())){
                        scoreNombre += 1 ;
                        score.setText("Score : " + String.valueOf(scoreNombre));
                    }
                    updateQuestions();
                }

            }
        });

        bouton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bouton4.getText().equals("")){
                    Toast.makeText(GameActivity.this, "Bouton invalide", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(String.valueOf(bouton4.getText()).equals(GameUtility.getListOfQuestion().get(i-1).getCorrectAnswer())){
                        scoreNombre += 1 ;
                        score.setText("Score : " + String.valueOf(scoreNombre));
                    }
                    updateQuestions();
                }

            }
        });
    }

    private void updateQuestions(){
        if(i != GameUtility.getListOfQuestion().size()){
            question.setText(GameUtility.getListOfQuestion().get(i).getQuestion());
            if(GameUtility.getListOfQuestion().get(i).getAllAnswers().size() == 2)
            {
                bouton1.setText(GameUtility.getListOfQuestion().get(i).getAllAnswers().get(0));
                bouton2.setText(GameUtility.getListOfQuestion().get(i).getAllAnswers().get(1));
                bouton3.setText("");
                bouton4.setText("");
            }
            else{
                bouton1.setText(GameUtility.getListOfQuestion().get(i).getAllAnswers().get(0));
                bouton2.setText(GameUtility.getListOfQuestion().get(i).getAllAnswers().get(1));
                bouton3.setText(GameUtility.getListOfQuestion().get(i).getAllAnswers().get(2));
                bouton4.setText(GameUtility.getListOfQuestion().get(i).getAllAnswers().get(3));
            }
            Log.i("COucou" , GameUtility.getListOfQuestion().get(i).getCorrectAnswer()) ;
            i++;
        }
        else{

            Toast.makeText(GameActivity.this, "C'est finis votre score est de : " + String.valueOf(scoreNombre), Toast.LENGTH_SHORT).show();
            GameUtility.clearListOfQuestion();
            UserScore scoreUtilisateur = new UserScore(SettingsUtility.getUsername() , scoreNombre) ;
            UserScore.setScoreUtilisateur(scoreUtilisateur);
            Intent intent = new Intent(GameActivity.this, ClassementActivity.class);
            startActivity(intent);

        }

    }



}