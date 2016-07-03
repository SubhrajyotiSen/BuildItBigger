package com.subhrajyoti.jokesdisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_dsiplay);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("Joke");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(joke);
    }
}
