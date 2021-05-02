package fr.CARPENTIER.test.models;

import android.text.Html;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private final String category;
    private final String type;
    private final String difficulty;
    private final String question;
    private final String correct_answer;
    private final List<String> incorrect_answers;
    private final List<String> answers;

    public Question(final String category, final String type,
                    final String difficulty, final String question,
                    final String correct_answer, final List<String> incorrect_answers,
                    final List<String> answers){
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
        this.answers = answers ;
        Collections.shuffle(this.answers);
    }

    public  String getCategory(){ return category; }

    public  String getType(){ return type; }

    public  String getDifficulty(){ return difficulty; }

    public  String getQuestion(){ return question; }

    public  String getCorrectAnswer(){ return correct_answer; }

    public  List<String> getIncorrectAnswers(){ return incorrect_answers; }

    public  List<String> getAllAnswers(){ return answers; }
}
