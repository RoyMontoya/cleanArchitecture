package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.executor.impl.ThreadExecutor;
import com.kodelabs.boilerplate.domain.repository.WelcomeMessageRepository;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;
import com.kodelabs.boilerplate.presentation.presenters.impl.MainPresenterImpl;
import com.kodelabs.boilerplate.threading.MainThreadImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenterImpl mainPresenter;
    @BindView(R.id.welcome_textview) private TextView mWelcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(), this, new WelcomeMessageRepository());
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainPresenter.resume();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void displayWelcomeMessage(String message) {
        mWelcomeTextView.setText(message);
    }
}
