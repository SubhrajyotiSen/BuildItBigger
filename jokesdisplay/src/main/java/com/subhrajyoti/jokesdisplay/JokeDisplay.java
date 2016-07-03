package com.subhrajyoti.jokesdisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class JokeDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_dsiplay);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("Joke");
        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }
}
