package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.babai.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.subhrajyoti.jokesdisplay.JokeDisplay;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog progressDialog;


    EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Making up something funny");
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://iconic-scholar-353.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.sayHi().execute().getData();

        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.hide();
        Intent intent = new Intent(context, JokeDisplay.class);
        intent.putExtra("Joke",result);
        context.startActivity(intent);
    }
}