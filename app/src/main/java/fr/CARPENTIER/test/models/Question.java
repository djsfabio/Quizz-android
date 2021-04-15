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
        this.answers = new ArrayList<>(incorrect_answers);
        this.answers.add(correct_answer);
        Collections.shuffle(this.answers);
    }

    public Question(final JSONObject jsonObject) throws JSONException {
        this.category = Html.fromHtml(jsonObject.getString("category")).toString();
        this.type = Html.fromHtml(jsonObject.getString("type")).toString();
        this.difficulty = Html.fromHtml(jsonObject.getString("difficulty")).toString();
        this.question = Html.fromHtml(jsonObject.getString("question")).toString();
        this.correct_answer = Html.fromHtml(jsonObject.getString("correct_answer")).toString();

        this.incorrect_answers = new ArrayList<>();
        JSONArray incorrect_answers_raw = jsonObject.getJSONArray("incorrect_answer");
        for (int i = 0; i < incorrect_answers_raw.length(); i++){
            incorrect_answers.add(Html.fromHtml(incorrect_answers_raw.get(i).toString()).toString());
        }

        this.answers = new ArrayList<>(incorrect_answers);
        this.answers.add(correct_answer);
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
