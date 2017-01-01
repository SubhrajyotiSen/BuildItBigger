package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.babai.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.subhrajyoti.jokesdisplay.JokeDisplay;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://iconic-scholar-353.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];
        try {
            return myApiService.sayHi().execute().getData();

        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeDisplay.class);
        intent.putExtra("Joke",result);
        context.startActivity(intent);
    }
}