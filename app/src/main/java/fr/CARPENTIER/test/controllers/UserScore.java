package fr.CARPENTIER.test.controllers;

import java.util.ArrayList;

import fr.CARPENTIER.test.models.Question;

public class UserScore {
    private final String user;
    private final int score;
    private static final ArrayList<UserScore> listScoreUtilisateur = new ArrayList<UserScore>() ;

    public static void setScoreUtilisateur(final UserScore userScore) {
        listScoreUtilisateur.add(userScore) ;
    }

    public static ArrayList<UserScore> getListScoreUtilisateur(){
        return listScoreUtilisateur ;
    }

    public static void clearListOfUser(){
        listScoreUtilisateur.clear();
    }

    public UserScore(String user, int score) {
        this.user = user;
        this.score = score;
    }

    public String getUser(){
        return user ;
    }

    public int getScore(){
        return score ;
    }
}
