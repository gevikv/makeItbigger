package com.example;

import java.util.Random;

public class Jokes {
    private Random rnd = new Random();

    public String get(){
        String jokeStr;
        switch (rnd.nextInt(4)) {
            case 0:
                jokeStr = "My first joke";
                break;
            case 1:
                jokeStr = "My Second joke";
                break;
            case 2:
                jokeStr = "My third joke";
                break;
            default:
                jokeStr = "My forth joke";
                break;
        }
        return jokeStr;
    }


}
