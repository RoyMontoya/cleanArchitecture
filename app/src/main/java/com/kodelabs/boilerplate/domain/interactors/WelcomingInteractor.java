package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;

/**
 * Created by Roy on 12/18/17.
 */

public interface WelcomingInteractor extends Interactor {

    interface CallBack{

        void onMessageRetrieve(String message);

        void onRetrievalFailed(String error);

    }

}
