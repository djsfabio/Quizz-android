package fr.CARPENTIER.test.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.CARPENTIER.test.R;

public class ClassementActivity extends AppCompatActivity {

    private TextView user1;
    private TextView user2;
    private TextView user3;
    private TextView user4;
    private TextView user5;
    private Button relancer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        relancer = findViewById(R.id.relancer) ;

        user1 = findViewById(R.id.utilisateur1);
        user2 = findViewById(R.id.utilisateur2);
        user3 = findViewById(R.id.utilisateur3);
        user4 = findViewById(R.id.utilisateur4);
        user5 = findViewById(R.id.utilisateur5);

        updateScore();




        relancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UserScore.getListScoreUtilisateur().size() == 5){
                    UserScore.clearListOfUser();
                }
                Intent intent = new Intent(ClassementActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateScore(){
        if(UserScore.getListScoreUtilisateur().size() == 1){
            user1.setText(UserScore.getListScoreUtilisateur().get(0).getUser() + " : " + UserScore.getListScoreUtilisateur().get(0).getScore());
        }
        if(UserScore.getListScoreUtilisateur().size() == 2){
            user1.setText(UserScore.getListScoreUtilisateur().get(0).getUser() + " : " + UserScore.getListScoreUtilisateur().get(0).getScore());
            user2.setText(UserScore.getListScoreUtilisateur().get(1).getUser() + " : " + UserScore.getListScoreUtilisateur().get(1).getScore());
        }
        if(UserScore.getListScoreUtilisateur().size() == 3){
            user1.setText(UserScore.getListScoreUtilisateur().get(0).getUser() + " : " + UserScore.getListScoreUtilisateur().get(0).getScore());
            user2.setText(UserScore.getListScoreUtilisateur().get(1).getUser() + " : " + UserScore.getListScoreUtilisateur().get(1).getScore());
            user3.setText(UserScore.getListScoreUtilisateur().get(2).getUser() + " : " + UserScore.getListScoreUtilisateur().get(2).getScore());
        }
        if(UserScore.getListScoreUtilisateur().size() == 4){
            user1.setText(UserScore.getListScoreUtilisateur().get(0).getUser() + " : " + UserScore.getListScoreUtilisateur().get(0).getScore());
            user2.setText(UserScore.getListScoreUtilisateur().get(1).getUser() + " : " + UserScore.getListScoreUtilisateur().get(1).getScore());
            user3.setText(UserScore.getListScoreUtilisateur().get(2).getUser() + " : " + UserScore.getListScoreUtilisateur().get(2).getScore());
            user4.setText(UserScore.getListScoreUtilisateur().get(3).getUser() + " : " + UserScore.getListScoreUtilisateur().get(3).getScore());
        }
        if(UserScore.getListScoreUtilisateur().size() == 5){
            user1.setText(UserScore.getListScoreUtilisateur().get(0).getUser() + " : " + UserScore.getListScoreUtilisateur().get(0).getScore());
            user2.setText(UserScore.getListScoreUtilisateur().get(1).getUser() + " : " + UserScore.getListScoreUtilisateur().get(1).getScore());
            user3.setText(UserScore.getListScoreUtilisateur().get(2).getUser() + " : " + UserScore.getListScoreUtilisateur().get(2).getScore());
            user4.setText(UserScore.getListScoreUtilisateur().get(3).getUser() + " : " + UserScore.getListScoreUtilisateur().get(3).getScore());
            user5.setText(UserScore.getListScoreUtilisateur().get(4).getUser() + " : " + UserScore.getListScoreUtilisateur().get(4).getScore());
        }


    }

}