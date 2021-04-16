package fr.CARPENTIER.test.controllers;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import fr.CARPENTIER.test.R;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import okhttp3.Callback;


public class GameActivity extends AppCompatActivity {

    private TextView Titre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Titre = findViewById(R.id.Titre);

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("https://opentdb.com/api.php")).newBuilder();
        urlBuilder.addQueryParameter("amount", SettingsUtility.getNumberOfQuestions());
        if(!StringUtils.isBlank(SettingsUtility.getCategory())){
            urlBuilder.addQueryParameter("category", SettingsUtility.getCategory());
        }
        if(!StringUtils.isBlank(SettingsUtility.getDifficulty())){
            urlBuilder.addQueryParameter("difficulty", SettingsUtility.getDifficulty());
        }
        if(!StringUtils.isBlank(SettingsUtility.getType())){
            urlBuilder.addQueryParameter("type", SettingsUtility.getType());
        }
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = Objects.requireNonNull(response.body()).string();
                    GameActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Titre.setText(url);
                        }
                    });
                }
            }
        });


    }
}