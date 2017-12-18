package com.kodelabs.boilerplate.threading;

import com.kodelabs.boilerplate.domain.executor.MainThread;

/**
 * Created by Roy on 12/18/17.
 */

public class TestMainThread implements MainThread {

    @Override
    public void post(Runnable runnable) {
        // tests can run on this thread, no need to invoke other threads
        runnable.run();
    }

}
