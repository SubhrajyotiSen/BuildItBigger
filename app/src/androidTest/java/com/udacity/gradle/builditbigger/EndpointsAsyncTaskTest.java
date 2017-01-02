package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements JokeReceivedListener {

    private String joke;

    @Test
    public void testOnPostExecute() throws ExecutionException, InterruptedException {
        new EndpointsAsyncTask().execute(this).get();
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }

    @Override
    public void onReceived(String joke) {
        this.joke = joke;
    }
}
