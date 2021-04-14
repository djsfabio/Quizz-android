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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuestionsLoaderAsyncTask extends AsyncTask<String, Void, JSONObject> {
    private final QuestionsLoaderInterface aListener;

    public QuestionsLoaderAsyncTask(final QuestionsLoaderInterface pListener){
        this.aListener = pListener;
    }

    @Override
    protected  JSONObject doInBackground(String... strings){
        URL url;
        HttpURLConnection urlConnection = null;
        String result = null;
        try{
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream
            result = readStream(in); // Read Stream
        }
        catch(MalformedURLException e){
            e.printStackTrace();
            aListener.onError(e);
        }
        catch(IOException e){
            e.printStackTrace();
            aListener.onError(e);
        }
        finally {
            if(urlConnection != null)
                urlConnection.disconnect();
        }

        JSONObject json = null;
        try{
            json = new JSONObject(result);
        }
        catch (JSONException e){
            e.printStackTrace();
            aListener.onError(e);
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
        for (String line = r.readLine(); line != null; line = r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }
}
