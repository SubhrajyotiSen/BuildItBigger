package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.babai.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<JokeReceivedListener, Void, String> {
    private static MyApi myApiService = null;
    private JokeReceivedListener jokeReceivedListener;

    @Override
    protected String doInBackground(JokeReceivedListener... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://iconic-scholar-353.appspot.com/_ah/api/");

            myApiService = builder.build();
        }
        jokeReceivedListener = params[0];
        try {
            return myApiService.tellJoke().execute().getData();

        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        jokeReceivedListener.onReceived(result);
    }
}