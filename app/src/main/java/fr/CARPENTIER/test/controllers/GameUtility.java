package fr.CARPENTIER.test.controllers;

import java.util.ArrayList;

import fr.CARPENTIER.test.models.Question;

public class GameUtility {
    private static String aResultatAPI = null ;

    private static final ArrayList<String> aQuestion = new ArrayList<String>() ;
    private static final ArrayList<String> aCategory = new ArrayList<String>() ;
    private static final ArrayList<String> aDifficulty = new ArrayList<String>() ;
    private static final ArrayList<String> aCorrectAnswer = new ArrayList<String>() ;
    private static final ArrayList<String> incorrectAnswer = new ArrayList<String>() ;
    private static final ArrayList<Question> listOfQuestion = new ArrayList<Question>() ;

    public static void setQuestion(final Question question) {
        listOfQuestion.add(question) ;
    }

    public static ArrayList<Question> getListOfQuestion(){
        return listOfQuestion ;
    }

    public static void clearListOfQuestion(){
        listOfQuestion.clear();
    }



    public static String getResultatAPI(){
        return aResultatAPI ;
    }
    public static void setaResultatAPI(final String resultatAPI){
        aResultatAPI = resultatAPI;
    }

    /* public static void setaQuestion(final String question) {
        aQuestion.add(question) ;
    }
    public static ArrayList<String> getListQuestion(){
        return aQuestion ;
    }
    public static void clearListOfQuestions(){
        aQuestion.clear();
    }*/



}
