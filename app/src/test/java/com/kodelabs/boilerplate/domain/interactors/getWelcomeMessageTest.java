package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.impl.WelcomingInteractorImpl;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Created by Roy on 12/18/17.
 */

public class getWelcomeMessageTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private MessageRepository mMessageRepository;
    @Mock
    private WelcomingInteractor.CallBack mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    private void testWelcomeMessageFount() throws Exception {

        String msg = "Welcome, friend!";

        when(mMessageRepository.getWelcomeMessage()).thenReturn(msg);

        WelcomingInteractorImpl welcomingInteractor = new WelcomingInteractorImpl(
                mExecutor, mMainThread, mMockedCallback, mMessageRepository);
        welcomingInteractor.run();

        Mockito.verify(mMessageRepository).getWelcomeMessage();
        Mockito.verifyNoMoreInteractions(mMessageRepository);
        Mockito.verify(mMockedCallback).onMessageRetrieve(msg);

    }
}
