package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.subhrajyoti.jokesdisplay.JokeDisplay;

public class MainActivityFragment extends Fragment implements JokeReceivedListener{

    private Button jokeButton;
    private ProgressDialog progressDialog;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.progress_text));
        jokeButton = (Button) rootView.findViewById(R.id.jokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                new EndpointsAsyncTask().execute(MainActivityFragment.this);
            }
        });
        return rootView;
    }


    @Override
    public void onReceived(String joke) {
        if (progressDialog != null && progressDialog.isShowing())
           progressDialog.hide();
        Intent intent = new Intent(getContext(), JokeDisplay.class);
        intent.putExtra("Joke", joke);
        startActivity(intent);
    }
}