package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void testOnPostExecute() throws ExecutionException, InterruptedException {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertNotNull(new EndpointsAsyncTask().execute(appContext).get());

    }
}
