package com.udacity.gradle.builditbigger;


import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

import com.subhrajyoti.jokes.Jokes;

import org.junit.Assert;
import org.junit.Test;

public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> {

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    @Test
    public void testonPostExecute(){
        Assert.assertNotNull(new EndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), (new Jokes()).getJoke())));

    }
}
