package com.example.user.ks_intern_2017.screen.second;

import android.support.annotation.NonNull;

/**
 * Created by User on 14.07.2017.
 */

public class SecondPresenter implements SecondContract.Presenter {
    private SecondContract.View view;
    private String email;

    public SecondPresenter(SecondContract.View view) {
        this.view = view;

    }

    @Override
    public void init() {

    }

    @Override
    public void initEmail(@NonNull String email) {
        this.email = email;
        view.initEmailField(email);
    }

    @Override
    public void sendMessage() {
        view.startSendIntent(email);
    }

    @Override
    public void cancel() {
        view.closeActivity();
    }
}
