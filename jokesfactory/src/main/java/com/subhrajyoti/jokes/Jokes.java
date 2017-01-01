package com.subhrajyoti.jokes;

import java.util.Random;

public class Jokes {
    private static String[] jokes = {"Chuck Norris can slam a revolving door",
            "Chuck Norris once kicked a horse in the chin. Its descendants are known today as Giraffes",
            "There is no theory of evolution. Just a list of animals Chuck Norris allows to live",
            "There is no theory of evolution. Just a list of animals Chuck Norris allows to live",
            "Chuck Norris can finish Mario Bros without using the jump button"
    };

    public String getJoke(){
        return jokes[(new Random()).nextInt(jokes.length)];
    }
}
