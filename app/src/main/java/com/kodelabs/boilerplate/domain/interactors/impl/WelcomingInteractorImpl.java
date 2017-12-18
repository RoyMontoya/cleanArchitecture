package com.kodelabs.boilerplate.domain.interactors.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.WelcomingInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;

/**
 * Created by Roy on 12/18/17.
 */

public class WelcomingInteractorImpl extends AbstractInteractor implements WelcomingInteractor {

    private WelcomingInteractor.CallBack callBack;
    private MessageRepository messageRepository;

    public WelcomingInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                   CallBack callBack, MessageRepository messageRepository) {
        super(threadExecutor, mainThread);
        this.callBack = callBack;
        this.messageRepository = messageRepository;
    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callBack.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    private void postMessage(final String message) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callBack.onMessageRetrieve(message);
            }
        });
    }


    @Override
    public void run() {
        // retrieve the message
        final String message = messageRepository.getWelcomeMessage();

        // check if we have failed to retrieve our message
        if (message == null || message.length() == 0) {

            // notify the failure on the main thread
            notifyError();

            return;
        }

        // we have retrieved our message, notify the UI on the main thread
        postMessage(message);
    }
}
