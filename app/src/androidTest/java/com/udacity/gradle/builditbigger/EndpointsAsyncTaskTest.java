package com.udacity.gradle.builditbigger;


import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

import com.subhrajyoti.jokes.Jokes;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> {

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    @Test
    public void testonPostExecute() throws ExecutionException, InterruptedException {
        assertNotNull(new EndpointsAsyncTask().execute(getContext()).get());

    }
}
