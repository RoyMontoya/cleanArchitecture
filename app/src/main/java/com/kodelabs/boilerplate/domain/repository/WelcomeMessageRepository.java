package com.kodelabs.boilerplate.domain.repository;

/**
 * Created by Roy on 12/18/17.
 */

public class WelcomeMessageRepository implements MessageRepository {

    @Override
    public String getWelcomeMessage() {
        String message = "Welcome, friend";
        //simulate api

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return message;
    }

}
