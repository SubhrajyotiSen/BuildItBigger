package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.subhrajyoti.jokesdisplay.JokeDisplay;

public class MainActivityFragment extends Fragment implements JokeReceivedListener {

    ProgressDialog progressDialog;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.progress_text));
        AdView adView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                new EndpointsAsyncTask().execute(MainActivityFragment.this);
            }
        });


        return root;
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