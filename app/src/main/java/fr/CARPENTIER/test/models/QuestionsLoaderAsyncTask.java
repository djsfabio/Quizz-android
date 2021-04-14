package fr.CARPENTIER.test.models;


import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class QuestionsLoaderAsyncTask extends AsyncTask<String, Void, JSONObject> {
    private final QuestionsLoaderInterface aListener;

    public QuestionsLoaderAsyncTask(final QuestionsLoaderInterface pListener){
        this.aListener = pListener;
    }

    @Override
    protected  JSONObject doInBackground(String... strings){
        URL url =null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try{
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream
            result = readStream(in); // Read Stream
        }
        catch(MalformedURLException e){

        }
        catch(IOExceptionn e){

        }
        finally {

        }

        JSONObject json = null;
        try{
            
        }
        catch (JSONException e){

        }

        return json; // return the result
    }

    @Override
    protected void onPostExecute(JSONObject s){
        List<Question> questions = new ArrayList<>();

        try{
            JSONArray results = s.getJSONArray("results");
            for (int i = 0; i < results.length(); i++){
                questions.add(new Question(results.getJSONObject(i)));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
            aListener.onError(e);
        }

        aListener.onTaskCompleted(questions);
    }

    private String readStream(InputStream is) throws  IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is), 1000);

    }
}
